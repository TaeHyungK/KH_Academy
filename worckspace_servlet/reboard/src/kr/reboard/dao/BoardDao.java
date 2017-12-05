package kr.reboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.reboard.domain.BoardDto;
import kr.util.StringUtil;

public class BoardDao {
	//�̱��� ����
	private static BoardDao instance = new BoardDao();
	public static BoardDao getInstance() {
		return instance;
	}
	private BoardDao() {}

	//context.xml���� ���������� �о�鿩
	//Ŀ�ؼ�Ǯ�κ��� Ŀ�ؼ��� �Ҵ� ����
	private Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		DataSource ds = (DataSource)initCtx.lookup("java:comp/env/jdbc/xe");
		return ds.getConnection();
	}

	//�ڿ�����
	private void executeClose(ResultSet rs,PreparedStatement pstmt,Connection conn) {
		if(rs!=null)try {rs.close();}catch(SQLException e) {}
		if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
		if(conn!=null)try {conn.close();}catch(SQLException e) {}
	}
	
	//�� ���
	public void insertReboard(BoardDto board) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		int cnt = 0;
		
		try {
			conn = getConnection();
			//���̺�� : reboard
			//�÷� : num(reboard_seq.nextval), title, content,
			//     regdate(SYSDATE), ip, id
			sql = "INSERT INTO rboard(num,title,content,regdate,ip,id) VALUES(rboard_seq.nextval, ?, ?, SYSDATE, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(++cnt, board.getTitle());
			pstmt.setString(++cnt, board.getContent());
			pstmt.setString(++cnt, board.getIp());
			pstmt.setString(++cnt, board.getId());
			
			pstmt.executeQuery();
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(null, pstmt, conn);
		}
	}
	//��ü�� ����, �˻��� ����
	public int getReboardCount(String keyfield, String keyword) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int count = 0;
		
		try {
			conn = getConnection();
			
			sql="SELECT COUNT(*) FROM rboard";
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
	//���, �˻��� ���
	public List<BoardDto> getListReboard(int start, int end, String keyfield, String keyword) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		List<BoardDto> list = null;
		
		try {
			conn = getConnection();
			//���̺�� : rboard
			//���� : num ��������
			sql = "SELECT * FROM (SELECT a.*, rownum rnum FROM (SELECT * FROM rboard ORDER BY num DESC) a) WHERE rnum>=? AND rnum<=?";
						
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			//�ڹٺ� ������ ������
			//num,title,hit,regdate,id
			list = new ArrayList<BoardDto>();
			while(rs.next()) {
				BoardDto board = new BoardDto();
				board.setNum(rs.getInt("num"));
				board.setTitle(StringUtil.useNoHtml(rs.getString("title")));
				board.setHit(rs.getInt("hit"));
				board.setRegdate(rs.getDate("regdate"));
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
	//�� ��
	public BoardDto getReboard(int num) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		String sql = null;
		BoardDto board = null;
		
		try {
			conn = getConnection();
			//num, title, content, hit, regdate, id
			sql = "SELECT * FROM rboard WHERE num=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				board = new BoardDto();
				board.setNum(rs.getInt("num"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setHit(rs.getInt("hit"));
				board.setRegdate(rs.getDate("regdate"));
				board.setId(rs.getString("id"));
			}
			
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(rs, pstmt, conn);
		}
		
		return board;
	}
	//�� ��ȸ�� ����
	public void updateReadCount(int num) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			conn = getConnection();
			
			sql = "UPDATE rboard SET hit=hit+1 WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(null, pstmt, conn);
		}
	}
	//�� ����
	public void updateReboard(BoardDto board) throws Exception{
		
	}
	//�� ����
	public void deleteReboard(BoardDto board) throws Exception{
		
	}
	
	//��� ���
	
	//��� ����
	
	//��� ���
	
	//��� ����
	
	//��� ����
	
}
