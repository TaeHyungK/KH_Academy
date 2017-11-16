package kr.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	public void insertMember(MemberDto member)throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int cnt = 0;

		try {
			//커넥션풀로부터 커넥션을 할당
			conn = getConnection();

			//SQL문
			sql = "insert into smember(id,name,passwd,email,phone,reg_date) values(?,?,?,?,?,sysdate)";

			//PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(++cnt, member.getId());
			pstmt.setString(++cnt, member.getName());
			pstmt.setString(++cnt, member.getPasswd());
			pstmt.setString(++cnt, member.getEmail());
			pstmt.setString(++cnt, member.getPhone());

			//SQL
			pstmt.executeUpdate();

		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			//자원정리
			executeClose(null, pstmt, conn);
		}

	}
	//회원상세정보
	public MemberDto getMember(String id)throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		MemberDto member = null;

		try {
			//커넥션풀로부터 커넥션을 할당 받음
			conn = getConnection();

			//SQL문
			sql = "SELECT * FROM smember WHERE id=?";

			//PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			//SQL문을 반영하고 결과행을 ResultSet에 담음
			rs = pstmt.executeQuery();
			if(rs.next()) {
				//자바빈 객체 생성
				member = new MemberDto();
				member.setId(rs.getString("id"));
				member.setPasswd(rs.getString("passwd"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				member.setPhone(rs.getString("phone"));
				member.setReg_date(rs.getDate("reg_date"));

			}

		}catch(Exception e) {
			e.printStackTrace();			
		}finally {
			//자원정리
			executeClose(rs, pstmt, conn);
		}

		return member;
	}
	//회원정보수정
	public void updateMember(MemberDto member)throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int cnt = 0;

		try {
			//커넥션풀로부터 커넥션을 할당 받음
			conn = getConnection();
			//SQL문 테이블명:smember 컬럼:name,passwd,email,phone 기본키:id
			sql = "UPDATE smember SET name=?,passwd=?,email=?,phone=? WHERE id=?";
			//PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			//SQL문의 ?에 데이터에 바인딩
			pstmt.setString(++cnt, member.getName());
			pstmt.setString(++cnt, member.getPasswd());
			pstmt.setString(++cnt, member.getEmail());
			pstmt.setString(++cnt, member.getPhone());
			pstmt.setString(++cnt, member.getId());
			//SQL문 반영
			pstmt.executeUpdate();
		}catch(Exception e) {
			//자원정리
			executeClose(null, pstmt, conn);
		}
	}
	//회원탈퇴,회원정보 삭제
	public void deleteMember(String id)throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;

		try {
			//커넥션풀로부터 커넥션을 할당 받음
			conn = getConnection();
			//SQL문
			sql = "DELETE FROM smember WHERE id=?";

			//PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			//SQL문의 ?에 데이터에 바인딩
			pstmt.setString(1, id);

			//SQL문 반영
			pstmt.executeUpdate();

		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			//자원정리
			executeClose(null, pstmt, conn);
		}
	}
}































































