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
	 * 싱글턴 패턴은 생성자를 private으로 지정해서
	 * 외부에서 호출할 수 없도록 처리하고 static
	 * 메서드를 호출해서 객체가 한 번만 생성되고
	 * 생성된 객체를 공유할 수 있도록 처리하는 
	 * 방식을 의미함.
	 */
	private static MemberDao instance = 
			new MemberDao();

	public static MemberDao getInstance() {
		return instance;
	}

	private MemberDao() {}	

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
	
	//회원가입
	public void insertMember(MemberDto member)
	                          throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		String sql = null;
		int cnt = 0;
		
		try {
			conn = getConnection();
			//오토 커밋 해제
			conn.setAutoCommit(false);
			
			sql = "INSERT INTO ymember (id, passwd, user_level) VALUES (?,?,1)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPasswd());
			  
			pstmt.executeUpdate();
			  
			//회원 상세
			sql = "INSERT INTO ymember_detail (id,name,"
				+ "phone,email,zipcode,"
				+ "address1,address2,reg_date) VALUES "
				+ "(?,?,?,?,?,?,?,sysdate)";
			pstmt2 = conn.prepareStatement(sql);
			pstmt2.setString(++cnt, member.getId());
			pstmt2.setString(++cnt, member.getName());
			pstmt2.setString(++cnt, member.getPhone());
			pstmt2.setString(++cnt, member.getEmail());
			pstmt2.setString(++cnt, member.getZipcode());
			pstmt2.setString(++cnt, member.getAddress1());
			pstmt2.setString(++cnt, member.getAddress2());
			
			pstmt2.executeUpdate();
			
			//정상 완료시
			conn.commit();
		}catch(Exception e) {
			//오류시 롤백
			conn.rollback();
			throw new Exception(e);
		}finally {
			executeClose(null, pstmt2, null);
			executeClose(null, pstmt, conn);
		}
		
	}
	//아이디 중복 체크
	public MemberDto checkId(String id) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDto member = null;
		String sql = null;
		
		try {
			conn = getConnection();
			sql = "SELECT * FROM ymember WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new MemberDto();
			}
			
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(rs, pstmt, conn);
		}
		
		return member;
	}
	//회원상세정보
	public MemberDto getMember(String id) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDto member = null;
		String sql = null;
		
		try {
			conn = getConnection();
			sql = "SELECT a.id,a.passwd,a.user_level,b.name,b.phone,b.email,b.zipcode,b.address1,b.address2,b.reg_date FROM ymember a JOIN ymember_detail b on a.id = b.id WHERE a.id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new MemberDto();
				member.setId(rs.getString("id"));
				member.setPasswd(rs.getString("passwd"));
				member.setUser_level(rs.getInt("user_level"));
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
	//비밀번호 수정
	public void updatePassword(MemberDto member) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			conn = getConnection();
			sql = "UPDATE ymember SET passwd=? WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getPasswd());
			pstmt.setString(2, member.getId());
			
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(null, pstmt, conn);
		}
	}
	
	//회원정보수정
	public void updateMember(MemberDto member)
	                          throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int cnt = 0;
		
		try {
			conn = getConnection();
			sql = "UPDATE ymember_detail SET name=?,"
				+ "phone=?,email=?,"
				+ "zipcode=?,address1=?,address2=? "
				+ "WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(++cnt, member.getName());
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
	//회원탈퇴,회원정보 삭제
	public void deleteMember(String id)
	                          throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		String sql = null;
		
		try {
			conn = getConnection();
			
			conn.setAutoCommit(false);
			
			sql = "DELETE FROM ymember_detail WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();			
			
			sql = "UPDATE ymember SET user_level=0 WHERE id=?";
			pstmt2 = conn.prepareStatement(sql);
			pstmt2.setString(1, id);
			pstmt2.executeUpdate();
			
			//수정 성공시
			conn.commit();
			
		}catch(Exception e) {
			//수정 실패
			conn.rollback();
			throw new Exception(e);
		}finally {
			executeClose(null, pstmt, conn);
		}
		
	}
}










