package kr.member.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.member.domain.MemberDto;

//DAO : date Access Object
public class MemberDao {
	
	/*
	 * �̱��� ������ �����ڸ� private���� �����ؼ� �ܺο��� ȣ���Ҽ� ������ ó���ϰ�
	 * static �޼��带 ȣ���ؼ� ��ü�� �ѹ��� �����ǰ� ������ ��ü�� �����Ҽ� �ֵ��� ó���ϴ� ����� �ǹ��� 
	 */
	private static MemberDao instance = new MemberDao();
	
	public static MemberDao getInstance() {
		return instance;
	}
	
	private MemberDao() {}
	
	
	
	//context.xml���� ���� ������ �о�鿩 
	//Ŀ�ؼǵ�κ��� Ŀ�ؼ��� �Ҵ� ����
	private Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		DataSource ds = (DataSource)initCtx.lookup("java:comp/env/jdbc/xe");
				return ds.getConnection();
	}
	
	
	//�ڿ� ����
	private void executeClose(ResultSet rs,PreparedStatement pstmt,Connection conn) {
		if(rs!=null)try {rs.close();}catch(SQLException e) {}
		if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
		if(conn!=null)try {conn.close();}catch(SQLException e) {}
	}
	
	
    // ȸ�� ����
	public void insertMember(MemberDto member) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int cnt = 0;
		
		try {
			//Ŀ�ؼǵ�κ��� Ŀ�ؼ��� �Ҵ�
			conn = getConnection();
			//SQl �� �ۼ�
			sql = "INSERT into smember(id,name,passwd,email,phone,reg_date) values(?,?,?,?,?,sysdate)";
			//preparedstatement ��ü ����
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(++cnt, member.getId());
			pstmt.setString(++cnt, member.getName());
			pstmt.setString(++cnt, member.getPasswd());
			pstmt.setString(++cnt, member.getEmail());
			pstmt.setString(++cnt, member.getPhone());
			
			//SQL�� �ݿ�
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			//�ڿ� ����
			executeClose(null,pstmt,conn);
		}
	}
	//ȸ�� �� ����
	public MemberDto getMember(String id) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDto member = null;
		String sql = null;
		
		try {
			//Ŀ�ؼ�
			conn = getConnection();
			//SQL ���ۼ�
			sql = "SELECT * FROM smember WHERE id=?";
			//PreparedStatement ��ü ����
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			//sql���� �ݿ��ϰ� ������� ResultSet�� ����
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new MemberDto();
				member.setId(rs.getString("id"));
				member.setPasswd(rs.getString("passwd"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				member.setPhone(rs.getString("phone"));
				member.setReg_date(rs.getDate("reg_date"));
			}
			
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			//�ڿ�����
			executeClose(rs,pstmt,conn);
		}
		
		return member;
	}
	//ȸ�� ���� ���� 
	public void updateMember(MemberDto member) throws Exception{
		Connection conn =null;
		PreparedStatement pstmt = null;
		String sql = null;
		int cnt = 0;
		
		try {
			//Ŀ�ؼ�Ǯ�κ��� Ŀ�ؼ��� �Ҵ�
			conn = getConnection();
			//sql�� �ۼ�
			sql = "UPDATE smember SET name=?,passwd=?,email=?,phone=? where id=?";
			//���̺��:smember
			//�÷�:name,passwd,email,phone
			//�⺻Ű : id
			
			//PreparedStatement ��ü����
			pstmt = conn.prepareStatement(sql);
			//sql���� ?�� ������ ���ε�
			pstmt.setString(++cnt, member.getName());
			pstmt.setString(++cnt, member.getPasswd());
			pstmt.setString(++cnt, member.getEmail());
			pstmt.setString(++cnt, member.getPhone());
			pstmt.setString(++cnt, member.getId());
			
			pstmt.executeUpdate();
			//sql�� �ݿ�
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			//�ڿ� ����
			executeClose(null,pstmt,conn);
		}
		
	}
	//ȸ��Ż��,ȸ������ ����
	public void deleteMember(String id) throws Exception{
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			//Ŀ�ؼ�Ǯ�κ��� Ŀ�ؼ� �Ҵ�
			conn = getConnection();
			//SQL�� 
			sql = "DELETE FROM smember WHERE id=?";
			//PreparedStatement ��ü ����
			pstmt = conn.prepareStatement(sql);
			//SQL���� ?�� ������ ���ε�
			pstmt.setString(1, id);
			//SQL�� �ݿ�
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			//�ڿ�����
			executeClose(null,pstmt,conn);
		}
		
	}
	
}
