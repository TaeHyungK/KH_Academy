package kr.register.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.register_1.domain.Register_1Dto;

public class Register_1Dao {
	
	private static Register_1Dao instance = 
			new Register_1Dao();
	
	public static Register_1Dao getInstance() {
		return instance;
	}
	
	private Register_1Dao() {}
	
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
	
	//회원상세정보
	public Register_1Dto getRegister(String id)throws Exception{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Register_1Dto register=null;
		String sql=null;
		
		try {
			conn=getConnection();
			sql="SELECT * FROM register_1 WHERE id=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			if(rs.next()) {
				register=new Register_1Dto();
				register.setId(rs.getString("id"));
				register.setPasswd(rs.getString("passwd"));
				register.setName(rs.getString("name"));
				register.setPhone(rs.getInt("phone"));
				register.setSex(rs.getString("sex"));
				register.setCard_num(rs.getInt("card_num"));
			}
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(rs,pstmt,conn);
		}
		return register;
	}
	
	//회원정보수정
	public void updateRegister(Register_1Dto register)throws Exception{
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql=null;
		int cnt=0;
		
		try {
			conn=getConnection();
			sql="UPDATE register_1 SET passwd=?,name=?,"
						+ "phone=?,sex=?,card_num=? WHERE id=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(++cnt, register.getPasswd());
			pstmt.setString(++cnt, register.getName());
			pstmt.setInt(++cnt, register.getPhone());
			pstmt.setString(++cnt, register.getSex());
			pstmt.setInt(++cnt, register.getCard_num());
			pstmt.setString(++cnt, register.getId());
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(null, pstmt, conn);
		}
	}
	
	//회원탈퇴
	public void deleteRegister(String id)throws Exception{
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql=null;
		
		try {
			conn=getConnection();
			sql="DELETE FROM register_1 WHERE id=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(null, pstmt, conn);
		}
	}
}
