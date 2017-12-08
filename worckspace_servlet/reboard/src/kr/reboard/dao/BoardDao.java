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
import kr.reboard.domain.BoardReply;
import kr.util.StringUtil;

public class BoardDao {
	//�̱��� ����
	private static BoardDao instance = 
			new BoardDao();
	public static BoardDao getInstance() {
		return instance;
	}
	private BoardDao() {}

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
	//�۵��
	public void insertReboard(BoardDto board)
			throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int cnt = 0;

		try {
			conn = getConnection();
			sql = "INSERT INTO rboard (num,title,"
					+ "content,regdate,ip,id) VALUES "
					+ "(rboard_seq.nextval,?,?,sysdate,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(++cnt, board.getTitle());
			pstmt.setString(++cnt, board.getContent());
			pstmt.setString(++cnt, board.getIp());
			pstmt.setString(++cnt, board.getId());

			pstmt.executeUpdate();

		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(null, pstmt, conn);
		}
	}
	//��ü�۰���,�˻��۰���
	public int getReboardCount(
			String keyfield,String keyword) 
					throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int count = 0;

		try {
			conn = getConnection();
			if(keyword == null || "".equals(keyword)) {
				//��ü�� ����
				sql = "SELECT COUNT(*) FROM rboard";
				pstmt = conn.prepareStatement(sql);
			}else {
				//�˻��� ����
				sql = "SELECT COUNT(*) FROM rboard WHERE " + keyfield + " like ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+keyword+"%");
			}
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
	//���,�˻��� ���
	public List<BoardDto> getListReboard(
			int start, int end,
			String keyfield,String keyword)
					throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardDto> list = null;
		String sql = null;

		try {
			conn = getConnection();
			if(keyword == null || "".equals(keyword)) {
				//��ü�� ����
				sql = "SELECT * FROM (select a.*, rownum rnum FROM "
						+ "(SELECT * FROM rboard b LEFT JOIN "
						+ "(SELECT num, count(*) re_cnt FROM rboard_reply group by num) r "
						+ "ON b.num = r.num ORDER BY b.num DESC) a) WHERE rnum >=? AND rnum <=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
			}else {   
				//�˻��� ����
				sql = "SELECT * FROM (select a.*, rownum rnum FROM "
						+ "(SELECT * FROM rboard b LEFT JOIN "
						+ "(SELECT num, count(*) re_cnt FROM rboard_reply group by num) r "
						+ "ON b.num = r.num WHERE "+keyfield+" LIKE ? ORDER BY b.num DESC) a) "
						+ "WHERE rnum >=? AND rnum <=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+keyword+"%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
			}
			rs = pstmt.executeQuery();

			list = new ArrayList<BoardDto>();
			while(rs.next()) {
				BoardDto board = new BoardDto();
				board.setNum(rs.getInt("num"));
				board.setTitle(StringUtil.useNoHtml(rs.getString("title")));
				board.setHit(rs.getInt("hit"));
				board.setRegdate(rs.getDate("regdate"));
				board.setId(rs.getString("id"));
				board.setReply_cnt(rs.getInt("re_cnt"));

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
	public BoardDto getReboard(int num)
			throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardDto board = null;
		String sql = null;

		try {
			conn = getConnection();
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
	public void updateReadcount(int num)
			throws Exception{
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
	public void updateReboard(BoardDto board)
			throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int cnt = 0;

		try {
			conn = getConnection();
			sql = "UPDATE rboard SET title=?,content=?,ip=? WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(++cnt, board.getTitle());
			pstmt.setString(++cnt, board.getContent());
			pstmt.setString(++cnt, board.getIp());
			pstmt.setInt(++cnt, board.getNum());

			pstmt.executeUpdate();

		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(null, pstmt, conn);
		}
	}
	//�� ����
	public void deleteReboard(int num) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		String sql = null;

		try {
			conn = getConnection();

			//����Ŀ�� ����
			conn.setAutoCommit(false);
			//��ۻ���
			sql = "DELETE FROM rboard_reply WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();

			//�θ�� ����
			sql = "DELETE FROM rboard WHERE num=?";
			pstmt2 = conn.prepareStatement(sql);
			pstmt2.setInt(1, num);
			pstmt2.executeUpdate();

			//���ܾ��� ������
			conn.commit();
		}catch(Exception e) {
			//���� �߻���
			conn.rollback();
			throw new Exception(e);
		}finally {
			executeClose(null, pstmt2, null);
			executeClose(null, pstmt, conn);
		}
	}

	//��� ���
	public void replyInsertBoard(BoardReply reply)
			throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int cnt = 0;

		try {
			conn = getConnection();

			sql = "INSERT INTO rboard_reply "
					+ "(re_num,re_content,re_date,"
					+ "re_ip,num,id) VALUES "
					+ "(reply_seq.nextval,?,sysdate,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(++cnt, reply.getRe_content());
			pstmt.setString(++cnt, reply.getRe_ip());
			pstmt.setInt(++cnt, reply.getNum());
			pstmt.setString(++cnt, reply.getId());

			pstmt.executeUpdate();

		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(null, pstmt, conn);
		}
	}
	//��� ����
	public int getReplyBoardCount(int num)
			throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int count = 0;

		try {
			conn = getConnection();
			sql = "SELECT COUNT(*) FROM rboard_reply WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
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
	//��� ���
	public List<BoardReply> getListReplyBoard(
			int start, int end,
			int num) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardReply> list = null;
		String sql = null;

		try {
			conn = getConnection();
			sql = "SELECT * FROM (SELECT a.*, rownum rnum "
					+ "FROM (SELECT * FROM rboard_reply WHERE "
					+ "num=? ORDER BY re_num DESC)a) "
					+ "WHERE rnum >= ? AND rnum <= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rs = pstmt.executeQuery();

			list = new ArrayList<BoardReply>();
			while(rs.next()) {
				BoardReply board = new BoardReply();
				board.setRe_num(rs.getInt("re_num"));
				board.setRe_date(rs.getDate("re_date"));
				board.setRe_content(StringUtil.useNoHtml(
						rs.getString("re_content")));
				board.setNum(rs.getInt("num"));
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
	//��� ����
	public void updateReplyBoard(BoardReply reply)
			throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int cnt = 0;

		try {
			conn = getConnection();
			sql = "UPDATE rboard_reply SET "
					+ "re_content=?,re_ip=? WHERE re_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(++cnt, reply.getRe_content());
			pstmt.setString(++cnt, reply.getRe_ip());
			pstmt.setInt(++cnt, reply.getRe_num());

			pstmt.executeUpdate();			
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(null, pstmt, conn);
		}
	}
	//��� ����
	public void deleteReplyBoard(int re_num)
			throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;

		try {
			conn = getConnection();

			sql = "DELETE FROM rboard_reply WHERE re_num=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, re_num);
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(null, pstmt, conn);
		}
	}
}













