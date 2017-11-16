package kr.guestbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.guestbook.domain.GuestbookDto;

public class GuestbookDao {
	//싱글턴 패턴
	private static GuestbookDao instance = new GuestbookDao();
	public static GuestbookDao getInstance() {
		return instance;
	}
	private GuestbookDao() {}

	//context.xml에서 설정정보를 읽어들여 커넥션풀로부터 커넥션을 할당 받음
	private Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		DataSource ds = (DataSource)initCtx.lookup("java:comp/env/jdbc/xe");
		return ds.getConnection();
	}

	//자원정리
	private void executeClose(ResultSet rs,PreparedStatement pstmt,Connection conn) {
		if(rs!=null)try {rs.close();} catch(SQLException e) {}
		if(pstmt!=null)try {pstmt.close();} catch(SQLException e) {}
		if(conn!=null)try {conn.close();} catch(SQLException e) {}
	}
	
	//글 저장
	public void insert(GuestbookDto book) throws Exception{
		Connection conn=null;
		PreparedStatement pstmt =null;
		String sql=null;
		int cnt=0;
		
		try {
			//커넥션풀로부터 커넥션을 할당
			conn = getConnection();
			//SQL문
			//테이블명 : guestbook
			//컬러명 : num, name, passwd, email, content, register
			sql = "INSERT INTO guestbook VALUES(guestbook_seq.nextval,?,?,?,?,SYSDATE)";
			//PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			//SQL문의 ?에 데이터를 바인딩
			pstmt.setString(++cnt, book.getName());
			pstmt.setString(++cnt, book.getPasswd());
			pstmt.setString(++cnt, book.getEmail());
			pstmt.setString(++cnt, book.getContent());
			//SQL문 실행
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			//자원 정리
			executeClose(null, pstmt, conn);
		}
	}
	//글의 총 갯수
	public int getCount() throws Exception{
		int count = 0;
		
		return count;
	}
	//글 목록
	public List<GuestbookDto> getList(int startRow, int endRow) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		List<GuestbookDto> list = null;
		
		try {
			//커넥션 풀로부터 커넥션을 할당
			conn = getConnection();
			sql = "SELECT * FROM guestbook ORDER BY num DESC";
			
			pstmt = conn.prepareStatement(sql);
			//sql문을 실행하고 결과행을 ResultSet에 반환
			rs = pstmt.executeQuery();
			list = new ArrayList<GuestbookDto>(); 
			while(rs.next()) {
				//자바빈 생성
				GuestbookDto book = new GuestbookDto();
				book.setNum(rs.getInt("num"));
				book.setName(rs.getString("name"));
				book.setPasswd(rs.getString("passwd"));
				book.setEmail(rs.getString("email"));
				book.setContent(rs.getString("content"));
				book.setRegister(rs.getDate("register"));
				
				list.add(book);
			}
			
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			//자원정리
			executeClose(rs, pstmt, conn);
		}
		
		return list;
	}
	//글 상세
	public GuestbookDto getGuestbook(int num) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		String sql= null;
		GuestbookDto book = null;
		
		try {
			//커넥션 풀로부터 커넥션을 할당
			conn = getConnection();
			
			//SQL문 작성
			sql = "SELECT * FROM guestbook WHERE num=?";
			//PreparedStatement객체 생성
			pstmt= conn.prepareStatement(sql);
			//SQL문의 ?에 데이터 바인딩
			pstmt.setInt(1, num);
			//SQL문을 반영하고 결과행을 ResultSet에 저장
			rs = pstmt.executeQuery();
			//if문을 사용하여 자바빈에 한건의 레코드 데이터 저장
			if(rs.next()) {
				book = new GuestbookDto();
				book.setNum(rs.getInt("num"));
				book.setName(rs.getString("name"));
				book.setPasswd(rs.getString("passwd"));	
				book.setEmail(rs.getString("email"));
				book.setContent(rs.getString("content"));
				book.setRegister(rs.getDate("register"));
			}
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			//자원 정리
			executeClose(rs, pstmt, conn);
		}
		
		return book;
	}
	//글 수정
	public void update(GuestbookDto book) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		String sql = null;
		
		try{
			//커넥션 풀로부터 커넥션을 할당
			conn = getConnection();
			//sql문 작성
			//name, email, content 변경 가능
			//기본키 : num
			sql = "UPDATE guestbook SET name=?, email=?, content=? WHERE num =?";
			//PreParedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);			
			//SQL문의 ?에 데이터 바인딩
			pstmt.setString(++cnt, book.getName());
			pstmt.setString(++cnt, book.getEmail());
			pstmt.setString(++cnt, book.getContent());
			pstmt.setInt(++cnt, book.getNum());
			//SQL문 실행
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(null, pstmt, conn);
		}
	}
	//글 삭제
	public void delete(int num) throws Exception{
		
	}
	

}
