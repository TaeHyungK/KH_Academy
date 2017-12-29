package kr.air.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.air.domain.ManagerDto;
import kr.air.domain.ReservationDto;


public class ReservationDao {
	//�̱��� ����
		private static ReservationDao instance = new ReservationDao();
		public static ReservationDao getInstance() {
			return instance;
		}
		private ReservationDao() {}
		
		private Connection getConnection() throws Exception{
			Context initCtx = new InitialContext();
			DataSource ds = 
					(DataSource)initCtx.lookup("java:comp/env/jdbc/xe");
			return ds.getConnection();
			
		}
		//�ڿ�����
		private void executeClose(ResultSet rs,PreparedStatement pstmt,Connection conn) {
			if(rs!=null)try {rs.close();}catch(SQLException e) {}
			if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		//��ü �����,�˻� �����
		public int getReservationCount(String keyfield,String keyword)throws Exception{

			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;
			int count = 0;

			try {
				conn = getConnection();
				if(keyword == null || "".equals(keyword)) {
					//��ü���� ����
					sql = "SELECT COUNT(*) FROM reservation";
					pstmt = conn.prepareStatement(sql);
				}else {
					//�˻����� ����
					sql = "SELECT COUNT(*) FROM reservation WHERE " + keyfield + " like ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, "%"+keyword+"%");
				}
				rs = pstmt.executeQuery();

				if(rs.next()) {
					count = rs.getInt(1);
				}
			}catch(Exception e) {
				throw new Exception(e);
			}finally {
				executeClose(rs,pstmt,conn);
			}

			return count;
		}
		public ReservationDto getReservation(String id)throws Exception{
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ReservationDto reservation = null;
			String sql = null;
			
			try {
				conn = getConnection();
				sql = "select * FROM reservation WHERE id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					reservation = new ReservationDto();
					reservation.setId(rs.getString("id"));
					reservation.setRegdate(rs.getDate("regdate"));
					reservation.setStart_lo(rs.getString("start_lo"));
					reservation.setEnd_lo(rs.getString("end_lo"));
					reservation.setAp_num(rs.getString("ap_num"));
					reservation.setRsv_num(rs.getString("rsv_num"));
				}
				
			}catch(Exception e) {
				throw new Exception(e);
			}finally {
				executeClose(rs,pstmt,conn);
			}
			
			return reservation;
			
		}
		//������
		public List<ReservationDto> getListReservation(String id,int start,int end,String keyfield,String keyword)throws Exception{
			List<ReservationDto> list = null;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;

			try {
				conn = getConnection();

				if(keyword==null||"".equals(keyword)) {
					//��ü ����
					sql = "SELECT * FROM(SELECT a.*,rownum rnum FROM (SELECT * FROM reservation WHERE id=? ORDER BY regdate DESC)a) WHERE rnum >= ? AND rnum <= ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, id);
					pstmt.setInt(2, start);
					pstmt.setInt(3, end);
				}else {
					//�˻� ����
					sql = "SELECT * FROM(SELECT a.*,rownum rnum FROM (SELECT * FROM reservation WHERE "+keyfield+" like ? ORDER BY regdate DESC)a) WHERE rnum >= ? AND rnum <= ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, "%"+keyword+"%");
					pstmt.setInt(2, start);
					pstmt.setInt(3, end);
				}
				rs = pstmt.executeQuery();

				list = new ArrayList<ReservationDto>();
				while(rs.next()) {
					ReservationDto reservation = new ReservationDto();
					reservation.setId(rs.getString("id"));
					reservation.setRegdate(rs.getDate("regdate"));
					reservation.setStart_lo(rs.getString("start_lo"));
					reservation.setEnd_lo(rs.getString("end_lo"));
					reservation.setAp_num(rs.getString("ap_num"));
					reservation.setRsv_num(rs.getString("rsv_num"));

					list.add(reservation);
				}

			}catch(Exception e) {
				throw new Exception(e);
			}finally {
				executeClose(rs,pstmt,conn);
			}
			return list;

	}
	//�������� ����
	public void deleteReservation(String rsv_num) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			conn = getConnection();
			sql = "DELETE FROM reservation WHERE rsv_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rsv_num);
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(null,pstmt,conn);
		}
	}
	//���࿩��Ȯ��
		public ReservationDto getListCount(String id)throws Exception{
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;
			ReservationDto reservation = null;
			
			try {
				conn = getConnection();
				sql = "select * from reservation WHERE id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				
				rs = pstmt.executeQuery();
				
			 	while(rs.next()) {
					reservation = new ReservationDto();
				}
				
			}catch(Exception e) {
				throw new Exception(e);
			}finally {
				executeClose(rs, pstmt, conn);
			}
					
			return reservation;
		}
	
}
