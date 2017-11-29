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
	 * 싱글턴 패턴은 생성자를 private으로 지정해서 외부에서 호출할수 없도록 처리하고
	 * static 메서드를 호출해서 객체가 한번만 생성되고 생성된 객체를 공유할수 있도록 처리하는 방식을 의미함 
	 */
	private static MemberDao instance = new MemberDao();
	
	public static MemberDao getInstance() {
		return instance;
	}
	
	private MemberDao() {}
	
	
	
	//context.xml에서 설정 정보를 읽어들여 
	//커넥션들로부터 커넥션을 할당 받음
	private Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		DataSource ds = (DataSource)initCtx.lookup("java:comp/env/jdbc/xe");
				return ds.getConnection();
	}
	
	
	//자원 정리
	private void executeClose(ResultSet rs,PreparedStatement pstmt,Connection conn) {
		if(rs!=null)try {rs.close();}catch(SQLException e) {}
		if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
		if(conn!=null)try {conn.close();}catch(SQLException e) {}
	}
	
	
	//회원가입
	public void insertMember(MemberDto member)throws Exception{
		//테이블명: member
		//컬럼: id,name,passwd,phone,email,zipcode,address1,address2,reg_date
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int cnt = 0;
		
		try {
			conn = getConnection();
			sql = "INSERT INTO member VALUES(?,?,?,?,?,?,?,?,SYSDATE)";
			
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
	//회원 상세 정보
	public MemberDto getMember(String id)throws Exception{
		MemberDto member = null;
		
		return member;
	}
	//회원 정보 수정
	public void updateMember(MemberDto member)throws Exception{
		
	}
	//회원 탈퇴,회원 정보 삭제
	public void deleteMember(String id)throws Exception{
		
	}
	
}
