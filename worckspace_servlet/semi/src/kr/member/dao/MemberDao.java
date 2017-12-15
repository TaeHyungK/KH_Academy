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
	private static MemberDao instance = 
			new MemberDao();

	public static MemberDao getInstance() {
		return instance;
	}

	private MemberDao() {}	

	//context.xml���� ���������� �о�鿩
	//Ŀ�ؼ�Ǯ�κ��� Ŀ�ؼ��� �Ҵ� ����
	private Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		DataSource ds = (DataSource)initCtx.lookup("java:comp/env/jdbc/xe");
		return ds.getConnection();
	}

	//�ڿ�����
	private void executeClose(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if(rs!=null)try {rs.close();}catch(SQLException e) {}
		if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
		if(conn!=null)try {conn.close();}catch(SQLException e) {}
	}
	
	//ȸ������
	public void insertMember(MemberDto member) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int cnt= 0;
		
		try {
			conn = getConnection();
			
			sql = "INSERT INTO register_1 (id, passwd, name, phone, sex, card_num) VALUES (?,?,?,?,?,?)";
			pstmt= conn.prepareStatement(sql);
			
			pstmt.setString(++cnt, member.getId());
			pstmt.setString(++cnt, member.getPasswd());
			pstmt.setString(++cnt, member.getName());
			pstmt.setString(++cnt, member.getPhone());
			pstmt.setString(++cnt, member.getSex());
			pstmt.setString(++cnt, member.getCard_num());
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(null, pstmt, conn);
		}
	}
	//���̵� �ߺ� üũ
	public MemberDto checkId(String id) throws Exception{
		MemberDto member = null;
		
		return member;
	}
	//ȸ��������
	public MemberDto getMember(String id) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDto member = null;
		String sql = null;
		
		try {
			conn = getConnection();
			
			sql = "SELECT * FROM register_1 WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new MemberDto();
				member.setId(rs.getString("id"));
				member.setPasswd(rs.getString("passwd"));
				member.setName(rs.getString("name"));
				member.setPhone(rs.getString("phone"));
				member.setSex(rs.getString("sex"));
				member.setCard_num(rs.getString("card_num"));
								
			}
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(rs, pstmt, conn);
		}
		
		return member;
	}
	//ȸ����������
	public void updateMember(MemberDto member) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int cnt = 0;
		
		try {
			conn = getConnection();
			sql = "UPDATE register_1 SET name=?, phone=?, sex=?, card_num=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(++cnt, member.getName());
			pstmt.setString(++cnt, member.getPhone());
			pstmt.setString(++cnt, member.getSex());
			pstmt.setString(++cnt, member.getCard_num());
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(null, pstmt, conn);
		}
	}
	//ȸ��Ż��, ȸ������ ����
	public boolean deleteMember(String id){
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		String sql = null;
				
		try {
			conn = getConnection();
			
			conn.setAutoCommit(false);
						
			sql = "DELETE FROM register_1 WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			
			conn.commit();
			return true;
			
		}catch(Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			
			return false;
			
		}finally {
			executeClose(null, pstmt, conn);
		}
	}
}
