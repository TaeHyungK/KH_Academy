package kr.reservation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.reservation.domain.ReservationDto;

public class ReservationDao {

	private static ReservationDao instance=new ReservationDao();
	
	public static ReservationDao getInstance() {
		return instance;
	}
	
	private Connection getConnection()throws Exception{
		Context initCtx=new InitialContext();
		DataSource ds=(DataSource)initCtx.lookup("java:comp/env/jdbc/xe");
		
		return ds.getConnection();
	}
	
	private void executeClose(ResultSet rs,PreparedStatement pstmt,
													Connection conn) {
		if(rs!=null)try {rs.close();}catch(SQLException e) {}
		if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
		if(conn!=null)try {conn.close();}catch(SQLException e) {}
	}
	
	//글 상세
	public ReservationDto getReservation(int num)throws Exception{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ReservationDto reservation=null;
		String sql=null;
		
		try {
			conn=getConnection();
			sql="SELECT * FROM reservation WHERE rsv_num=?";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				reservation=new ReservationDto();
				reservation.setRsv_num(rs.getString("rsv_num"));
				reservation.setRegdate(rs.getDate("regdate"));
				reservation.setDeparture(rs.getString("departure"));
				reservation.setDestination(rs.getString("destination"));
				reservation.setAp_num(rs.getString("ap_num"));
				reservation.setId(rs.getString("id"));
			}
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(rs, pstmt, conn);
		}
		return reservation;
	}
	//글 수정
	public void updateReservation(ReservationDto reservation)throws Exception{
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql=null;
		int cnt=0;
		
		try {
			conn=getConnection();
			sql="UPDATE reservation SET departure=?,destination=?,ap_num=? "
				+"WHERE rsv_num=?";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(++cnt,reservation.getDeparture());
			pstmt.setString(++cnt,reservation.getDestination());
			pstmt.setString(++cnt,reservation.getAp_num());
			pstmt.setString(++cnt,reservation.getRsv_num());
			
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(null, pstmt, conn);
		}
	}
	//글 삭제
	public void deleteReservation(int num)throws Exception{
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql=null;
		
		try {
			conn=getConnection();
			conn.setAutoCommit(false);
			
			sql="DELETE FROM reservation WHERE rsv_num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
			conn.commit();
			
		}catch(Exception e) {
			conn.rollback();
			throw new Exception(e);
		}finally {
			executeClose(null, pstmt, conn);
		}
	}
}
