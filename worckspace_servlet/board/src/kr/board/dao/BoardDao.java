package kr.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.board.domain.BoardDto;
import kr.util.StringUtil;

public class BoardDao {
	//싱글턴 패턴
	private static BoardDao instance = new BoardDao();
	public static BoardDao getInstance() {
		return instance;
	}
	private BoardDao() {}

	//context.xml에서 설정정보를 읽어들여
	//커넥션풀로부터 커넥션을 할당 받음
	private Connection getConnection() throws Exception{
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
	
	//글 등록
	public void insertBoard(BoardDto board) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int cnt = 0;
		//테이블명 : board
		//컬럼명 : num, title, content, regdate, filename, ip, id
		
		try {
			conn = getConnection();
			
			sql = "INSERT INTO board(num,title,content,regdate,filename,ip,id) VALUES(board_seq.nextval, ?, ?, SYSDATE, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(++cnt, board.getTitle());
			pstmt.setString(++cnt, board.getContent());
			pstmt.setString(++cnt, board.getFilename());
			pstmt.setString(++cnt, board.getIp());
			pstmt.setString(++cnt, board.getId());
			
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(null, pstmt, conn);
		}
	}
	//글전체글 갯수, 검색글 갯수
	public int getBoardCount(String keyfield, String keyword) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int count = 0;
		
		try {
			//count 함수를 이용해서 전체 레코드 수를 구함
			conn = getConnection();
			
			sql = "SELECT COUNT(*) FROM board ";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
			
			
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(rs, pstmt, conn);
		}
		return count;
	}
	//목록, 검색글 목록
	public List<BoardDto> getListBoard(int start, int end, String keyfield, String keyword) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		List<BoardDto> list = null;
		
		
		try {
			conn = getConnection();
			
			sql ="SELECT * FROM (SELECT a.*, rownum rnum FROM (SELECT * FROM board ORDER BY num DESC) a) WHERE rnum >= ? AND rnum <= ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			
			list = new ArrayList<BoardDto>();
			while(rs.next()) {
				BoardDto board = new BoardDto();
				board.setNum(rs.getInt("num"));
				board.setTitle(StringUtil.useNoHtml(rs.getString("title")));
				board.setRegdate(rs.getDate("regdate"));
				board.setFilename(rs.getString("filename"));
				board.setIp(rs.getString("ip"));
				board.setId(rs.getString("id"));
				
				list.add(board);
			}
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(rs, pstmt, conn);
		}
		
		return list;
	}
	//글 상세
	public BoardDto getBoard(int num) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		BoardDto board = null;
		
		try {
			conn = getConnection();
			
			sql = "SELECT * FROM board WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				board = new BoardDto();
				board.setNum(rs.getInt("num"));
				board.setTitle(rs.getString("title"));
				board.setHit(rs.getInt("hit"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getDate("regdate"));
				board.setFilename(rs.getString("filename"));
				board.setId(rs.getString("id"));
			}
			
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(rs, pstmt, conn);
		}
		return board;
	}
	//글 조회수 증가
	public void updateReadcount(int num) throws Exception{
		
	}
	//글 수정
	public void updateBoard(BoardDto board) throws Exception{
		
	}
	//글 삭제
	public void deleteBoard(int num) throws Exception{
		
	}
}
