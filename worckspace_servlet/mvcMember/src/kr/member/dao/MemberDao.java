package kr.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.member.domain.MemberDto;

//DAO : Data Access Object
public class MemberDao {

	/*
	 * 싱글턴 패턴은 생성자를 private으로 지정해서 외부에서 호출할 수 없도록 처리하고 static메서드를 호출해서
	 * 객체가 한 번만 생성되고 생성된 객체를 공유할 수 있도록 처리하는 방식을 의미함.
	 */
	private static MemberDao instance = new MemberDao();

	public static MemberDao getInstance() {
		return instance;
	}

	private MemberDao() {}

	//context.xml에서 설정정보를 읽어들여 커넥션풀로부터 커넥션을 할당 받음
	private Connection getConnection()throws Exception{
		Context initCtx = new InitialContext();
		DataSource ds = (DataSource)initCtx.lookup("java:comp/env/jdbc/xe");
		return ds.getConnection();
	}

	//자원정리
	private void executeClose(ResultSet rs,PreparedStatement pstmt,Connection conn) {
		if(rs!=null)try {rs.close();}catch(SQLException e) {}
		if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
		if(conn!=null)try {conn.close();}catch(SQLException e) {}
	}
	
	//회원가입
	public void insertMember(MemberDto member) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int cnt = 0;
		
		try {
			//커넥션 풀로부터 커넥션 할당
			conn = getConnection();
			//sql문 작성
			sql = "INSERT INTO zmember (id,passwd,name,reg_date) VALUES (?,?,?,SYSDATE)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(++cnt, member.getId());
			pstmt.setString(++cnt, member.getPasswd());
			pstmt.setString(++cnt, member.getName());
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(null, pstmt, conn);
		}
	}
	//목록
	public List<MemberDto> getMemberList() throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		MemberDto member = null;
		List<MemberDto> memberList = null;
		
		try {
			conn = getConnection();
			sql = "SELECT * FROM zmember ORDER BY reg_date DESC";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			memberList = new ArrayList<MemberDto>();
			while(rs.next()) {
				member = new MemberDto();
				member.setId(rs.getString("id"));
				member.setPasswd(rs.getString("passwd"));
				member.setName(rs.getString("name"));
				member.setReg_date(rs.getDate("reg_date"));
				
				memberList.add(member);
			}
			
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(rs, pstmt, conn);
		}
		
		return memberList;
	}
	//회원 상세정보
	public MemberDto getMember(String id) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		MemberDto member = null;
		
		try {
			conn = getConnection();
			
			sql = "SELECT * FROM zmember WHERE id=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new MemberDto();
				member.setId(rs.getString("id"));
				member.setPasswd(rs.getString("passwd"));
				member.setName(rs.getString("name"));
				member.setReg_date(rs.getDate("reg_date"));
			}
			
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(rs, pstmt, conn);
		}
		
		return member;
	}
	//회원수정
	public void updateMember(MemberDto member) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt =null;
		String sql = null;
		int cnt = 0;
		
		try {
			conn = getConnection();
			
			sql = "UPDATE zmember SET passwd=?, name=? WHERE id=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(++cnt, member.getPasswd());
			pstmt.setString(++cnt, member.getName());
			pstmt.setString(++cnt, member.getId());
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(null, pstmt, conn);
		}
	}
	//회원삭제
	public void deleteMember(String id) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			conn = getConnection();
			
			sql = "DELETE FROM zmember WHERE id=?";
			
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