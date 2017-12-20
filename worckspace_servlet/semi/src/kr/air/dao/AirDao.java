package kr.air.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.air.dao.AirDao;
import kr.air.domain.AirDto;

public class AirDao {
	private static AirDao instance = 
			new AirDao();

	public static AirDao getInstance() {
		return instance;
	}

	private AirDao() {}	

	//context.xml에서 설정정보를 읽어들여
	//커넥션풀로부터 커넥션을 할당 받음
	private Connection getConnection()
			throws Exception{
		Context initCtx = new InitialContext();
		DataSource ds = 
				(DataSource)initCtx.lookup(
						"java:comp/env/jdbc/xe");
		return ds.getConnection();
	}

	//자원정리
	private void executeClose(ResultSet rs,
			PreparedStatement pstmt,
			Connection conn) {
		if(rs!=null)try {rs.close();}catch(SQLException e) {}
		if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
		if(conn!=null)try {conn.close();}catch(SQLException e) {}
	}
	
	public boolean reserv_num(int num) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		boolean res =false;
		
		try {
			conn = getConnection();
			sql = "select r.snum from reservation r join schedule s on r.snum = s.snum where r.snum=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				res = true;
			}
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(rs, pstmt, conn);
		}
		return res;
	}
	
	public void reservation(AirDto ad)throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int cnt = 0;
		try {
			conn = getConnection();
			sql = "insert into reservation(rsv_num,regdate,departure,destination,ap_num,id) values(a_num_seq.nextval,sysdate,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(++cnt, ad.getStart_lo());
			pstmt.setString(++cnt, ad.getEnd_lo());
			pstmt.setString(++cnt, ad.getAp_num());
			pstmt.setString(++cnt, ad.getId());
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(null, pstmt, conn);
		}
	}
	
	public List<AirDto> searchInfo(AirDto ad)throws Exception{
		List<AirDto> list = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			sql = "select * from schedule where start_lo=? and end_lo=? and go_date=? and return_date=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ad.getStart_lo());
			pstmt.setString(2, ad.getEnd_lo());
			pstmt.setString(3, ad.getGo_date());
			pstmt.setString(4, ad.getReturn_date());
			rs = pstmt.executeQuery();
			list = new ArrayList<AirDto>();
			while(rs.next()) {
				AirDto ad2 = new AirDto();
				ad2.setSnum(rs.getInt("snum"));
				ad2.setStart_lo(rs.getString("start_lo"));
				ad2.setEnd_lo(rs.getString("end_lo"));
				ad2.setGo_date(ad.getGo_date());
				ad2.setGo_time(rs.getString("go_time"));
				ad2.setReturn_date(ad.getReturn_date());
				ad2.setReturn_time(rs.getString("return_time"));
				ad2.setTake_time(rs.getString("take_time"));
				ad2.setAp_num(rs.getString("ap_num"));
				list.add(ad2);
			}
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(rs, pstmt, conn);
		}
		return list;
	}
	
	public List<AirDto> listSchedule()throws Exception{
		List<AirDto> list = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			sql = "select * from schedule";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<AirDto>();
			while(rs.next()) {
				AirDto ad = new AirDto();
				ad.setSnum(rs.getInt("snum"));
				ad.setStart_lo(rs.getString("start_lo"));
				ad.setEnd_lo(rs.getString("end_lo"));
				ad.setGo_date(rs.getString("go_date"));
				ad.setGo_time(rs.getString("go_time"));
				ad.setReturn_date(rs.getString("return_date"));
				ad.setReturn_time(rs.getString("return_time"));
				ad.setTake_time(rs.getString("take_time"));
				ad.setAp_num(rs.getString("ap_num"));
				ad.setSeats(rs.getInt("seats"));
				list.add(ad);
			}
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(rs, pstmt, conn);
		}
		return list;
	}
	
	public AirDto selectAir(int num)throws Exception{
		AirDto ad = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			conn = getConnection();
			sql = "select * from schedule where snum = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				ad = new AirDto();
				ad.setStart_lo(rs.getString("start_lo"));
				ad.setEnd_lo(rs.getString("end_lo"));
				ad.setGo_date(rs.getString("go_date"));
				ad.setReturn_date(rs.getString("return_date"));
				ad.setGo_time(rs.getString("go_time"));
				ad.setReturn_time(rs.getString("return_time"));		
				ad.setTake_time(rs.getString("take_time"));
				ad.setAp_num(rs.getString("ap_num"));
				ad.setSnum(rs.getInt("snum"));
			}
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(rs, pstmt, conn);
		}
		return ad;
	}
	public List<Integer> selectReservNum()throws Exception{
		List<Integer> rsv = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			conn = getConnection();
			sql = "select rsv_num from reservation";
			pstmt = conn.prepareStatement(sql);
			rsv = new ArrayList<Integer>();
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int rsv_num = rs.getInt("rsv_num");
				rsv.add(rsv_num);
			}
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(rs, pstmt, conn);
		}
		return rsv;
	}
	public AirDto selectReservAir(int num)throws Exception{
		AirDto ad = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			conn = getConnection();
			sql = "select * from reservation where rsv_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				ad = new AirDto();
				ad.setStart_lo(rs.getString("start_lo"));
				ad.setEnd_lo(rs.getString("end_lo"));
				ad.setGo_date(rs.getString("go_date"));
				ad.setReturn_date(rs.getString("return_date"));
				ad.setGo_time(rs.getString("go_time"));
				ad.setReturn_time(rs.getString("return_time"));		
				ad.setTake_time(rs.getString("take_time"));
				ad.setAp_num(rs.getString("ap_num"));
				ad.setSnum(rs.getInt("rsv_num"));
				ad.setAdult(rs.getInt("a_ticket"));
				ad.setStudent(rs.getInt("as_ticket"));
				ad.setKid(rs.getInt("c_ticket"));
				ad.setTotal_ticket(rs.getInt("a_ticket")+rs.getInt("as_ticket")+rs.getInt("c_ticket"));
			}
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(rs, pstmt, conn);
		}
		
		return ad;
	}
	
	
	public void updateReserv(AirDto ada, int num, String user_id,int random, int ticket_num,int a_ticket_num,int as_ticket_num,int c_ticket_num)throws Exception{
		System.out.println(ada);
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		String sql = null;
		int cnt = 0;
		
		try {
			conn = getConnection();
			sql = "insert into reservation values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(++cnt, random);
			pstmt.setString(++cnt, ada.getStart_lo());
			pstmt.setString(++cnt, ada.getEnd_lo());
			pstmt.setString(++cnt, ada.getGo_date());
			pstmt.setString(++cnt, ada.getReturn_date());
			pstmt.setString(++cnt, ada.getGo_time());
			pstmt.setString(++cnt, ada.getReturn_time());
			pstmt.setString(++cnt, ada.getTake_time());
			String ap_num = ada.getAp_num();
			pstmt.setString(++cnt, ap_num);
			pstmt.setString(++cnt, user_id);
			pstmt.setInt(++cnt, a_ticket_num);
			pstmt.setInt(++cnt, as_ticket_num);
			pstmt.setInt(++cnt, c_ticket_num);
			pstmt.setInt(++cnt, num);
			pstmt.executeUpdate();
			sql = "update airplane set seats=seats-? where ap_num=?";
			pstmt2 = conn.prepareStatement(sql);
			pstmt2.setInt(1, ticket_num);
			pstmt2.setString(2, ap_num);
			pstmt2.executeUpdate();
			sql = "update schedule set seats=seats-? where snum=?";
			pstmt3 = conn.prepareStatement(sql);
			pstmt3.setInt(1, ticket_num);
			pstmt3.setInt(2, num);
			pstmt3.executeUpdate();
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(null, pstmt, conn);
			executeClose(null, pstmt2, null);
			executeClose(null, pstmt3, null);
		}
		
	}
	public AirDto airName()throws Exception{
		AirDto ad = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			conn = getConnection();
			sql = "";
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(rs, pstmt, conn);
		}
		return ad;
	}
	
	public void deleteAir(int snum)throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			conn = getConnection();
			sql = "delete from schedule where snum=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, snum);
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(null, pstmt, conn);
		}
	}
	public void modifyAir(AirDto ad)throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int cnt = 0;
		try {
			conn = getConnection();
			sql = "update schedule set start_lo=?, end_lo=?, go_date=?,return_date=?,go_time=?,return_time=?,take_time=?,ap_num=?,seats=? where snum=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(++cnt, ad.getStart_lo());
			pstmt.setString(++cnt, ad.getEnd_lo());
			pstmt.setString(++cnt, ad.getGo_date());
			pstmt.setString(++cnt, ad.getReturn_date());
			pstmt.setString(++cnt, ad.getGo_time());
			pstmt.setString(++cnt, ad.getReturn_time());
			pstmt.setString(++cnt, ad.getTake_time());
			pstmt.setString(++cnt, ad.getAp_num());
			pstmt.setInt(++cnt, ad.getSeats());
			pstmt.setInt(++cnt, ad.getSnum());
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(null, pstmt, conn);
		}
	}
	public void insertAir(AirDto ad)throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int cnt = 0;
		try {
			conn = getConnection();
			sql = "insert into schedule values(a_num_seq.nextval,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(++cnt, ad.getStart_lo());
			pstmt.setString(++cnt, ad.getEnd_lo());
			pstmt.setString(++cnt, ad.getGo_date());
			pstmt.setString(++cnt, ad.getReturn_date());
			pstmt.setString(++cnt, ad.getGo_time());
			pstmt.setString(++cnt, ad.getReturn_time());
			pstmt.setString(++cnt, ad.getTake_time());
			pstmt.setString(++cnt, ad.getAp_num());
			pstmt.setInt(++cnt, ad.getSeats());
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(null, pstmt, conn);
		}
	}
	
	public int seats(String ap_num)throws Exception{
		int seats = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			conn = getConnection();
			sql = "select seats from airplane where ap_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ap_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				seats = rs.getInt(1);
			}
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(rs, pstmt, conn);
		}
		return seats;
	}
	
/*	public void insertAirResv(AirDto ad,String user_id)throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int cnt = 0;
		try {
			conn = getConnection();
			sql = "insert into reservation values(a_num_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(++cnt, ad.getStart_lo());
			pstmt.setString(++cnt, ad.getEnd_lo());
			pstmt.setString(++cnt, ad.getGo_date());
			pstmt.setString(++cnt, ad.getReturn_date());
			pstmt.setString(++cnt, ad.getGo_time());
			pstmt.setString(++cnt, ad.getReturn_time());
			pstmt.setString(++cnt, ad.getTake_time());
			pstmt.setString(++cnt, ad.getAp_num());
			pstmt.setString(++cnt, user_id);
			pstmt.setInt(++cnt, ad.getAdult());
			pstmt.setInt(++cnt, ad.getStudent());
			pstmt.setInt(++cnt, ad.getKid());
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(null, pstmt, conn);
		}
	}회원이 자신의 예약 정보 수정시 사용*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
