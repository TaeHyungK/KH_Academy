package kr.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.member.domain.MemberDto;

public class MemberDao {
	/*
	 * �̱��� ������ �����ڸ� private���� �����ؼ�
	 * �ܺο��� ȣ���� �� ������ ó���ϰ� static
	 * �޼��带 ȣ���ؼ� ��ü�� �� ���� �����ǰ�
	 * ������ ��ü�� ������ �� �ֵ��� ó���ϴ� 
	 * ����� �ǹ���.
	 */
	private static MemberDao instance = 
			new MemberDao();

	public static MemberDao getInstance() {
		return instance;
	}

	private MemberDao() {}	

	//context.xml���� ���������� �о�鿩
	//Ŀ�ؼ�Ǯ�κ��� Ŀ�ؼ��� �Ҵ� ����
	private Connection getConnection()
			throws Exception{
		Context initCtx = new InitialContext();
		DataSource ds = 
				(DataSource)initCtx.lookup(
						"java:comp/env/jdbc/xe");
		return ds.getConnection();
	}

	//�ڿ�����
	private void executeClose(ResultSet rs,
			PreparedStatement pstmt,
			Connection conn) {
		if(rs!=null)try {rs.close();}catch(SQLException e) {}
		if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
		if(conn!=null)try {conn.close();}catch(SQLException e) {}
	}
	
	//ȸ������
	public void insertMember(MemberDto member)
	                          throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int cnt = 0;
		
		try {
			conn = getConnection();
			sql = "INSERT INTO member (id,name,"
				+ "passwd,phone,email,zipcode,"
				+ "address1,address2,reg_date) VALUES "
				+ "(?,?,?,?,?,?,?,?,sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(++cnt, member.getId());
			pstmt.setString(++cnt, member.getName());
			pstmt.setString(++cnt, member.getPasswd());
			pstmt.setString(++cnt, member.getPhone());
			pstmt.setString(++cnt, member.getEmail());
			pstmt.setString(++cnt, member.getZipcode());
			pstmt.setString(++cnt, member.getAddress1());
			pstmt.setString(++cnt, member.getAddress2());
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(null, pstmt, conn);
		}
		
	}
	//ȸ��������
	public MemberDto getMember(String id)
	                          throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDto member = null;
		String sql = null;
		
		try {
			conn = getConnection();
			sql = "SELECT * FROM member WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new MemberDto();
				member.setId(rs.getString("id"));
				member.setPasswd(rs.getString("passwd"));
				member.setName(rs.getString("name"));
				member.setPhone(rs.getString("phone"));
				member.setEmail(rs.getString("email"));
				member.setZipcode(rs.getString("zipcode"));
				member.setAddress1(rs.getString("address1"));
				member.setAddress2(rs.getString("address2"));
				member.setReg_date(rs.getDate("reg_date"));
			}
			
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(rs, pstmt, conn);
		}
		
		return member;
	}
	//ȸ����������
	public void updateMember(MemberDto member)
	                          throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int cnt = 0;
		
		try {
			conn = getConnection();
			sql = "UPDATE member SET name=?,"
				+ "passwd=?,phone=?,email=?,"
				+ "zipcode=?,address1=?,address2=? "
				+ "WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(++cnt, member.getName());
			pstmt.setString(++cnt, member.getPasswd());
			pstmt.setString(++cnt, member.getPhone());
			pstmt.setString(++cnt, member.getEmail());
			pstmt.setString(++cnt, member.getZipcode());
			pstmt.setString(++cnt, member.getAddress1());
			pstmt.setString(++cnt, member.getAddress2());
			pstmt.setString(++cnt, member.getId());
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(null, pstmt, conn);
		}
	}
	//ȸ��Ż��,ȸ������ ����
	public void deleteMember(String id)
	                          throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			conn = getConnection();
			sql = "DELETE FROM member WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(null, pstmt, conn);
		}
		
	}
}










