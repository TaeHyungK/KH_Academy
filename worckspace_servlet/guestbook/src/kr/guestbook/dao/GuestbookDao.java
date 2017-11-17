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
	//�̱��� ����
	private static GuestbookDao instance = new GuestbookDao();
	public static GuestbookDao getInstance() {
		return instance;
	}
	private GuestbookDao() {}

	//context.xml���� ���������� �о�鿩 Ŀ�ؼ�Ǯ�κ��� Ŀ�ؼ��� �Ҵ� ����
	private Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		DataSource ds = (DataSource)initCtx.lookup("java:comp/env/jdbc/xe");
		return ds.getConnection();
	}

	//�ڿ�����
	private void executeClose(ResultSet rs,PreparedStatement pstmt,Connection conn) {
		if(rs!=null)try {rs.close();} catch(SQLException e) {}
		if(pstmt!=null)try {pstmt.close();} catch(SQLException e) {}
		if(conn!=null)try {conn.close();} catch(SQLException e) {}
	}
	
	//�� ����
	public void insert(GuestbookDto book) throws Exception{
		Connection conn=null;
		PreparedStatement pstmt =null;
		String sql=null;
		int cnt=0;
		
		try {
			//Ŀ�ؼ�Ǯ�κ��� Ŀ�ؼ��� �Ҵ�
			conn = getConnection();
			//SQL��
			//���̺�� : guestbook
			//�÷��� : num, name, passwd, email, content, register
			sql = "INSERT INTO guestbook VALUES(guestbook_seq.nextval,?,?,?,?,SYSDATE)";
			//PreparedStatement ��ü ����
			pstmt = conn.prepareStatement(sql);
			//SQL���� ?�� �����͸� ���ε�
			pstmt.setString(++cnt, book.getName());
			pstmt.setString(++cnt, book.getPasswd());
			pstmt.setString(++cnt, book.getEmail());
			pstmt.setString(++cnt, book.getContent());
			//SQL�� ����
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			//�ڿ� ����
			executeClose(null, pstmt, conn);
		}
	}
	//���� �� ����
	public int getCount() throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int count = 0;
		
		try {
			conn = getConnection();
			
			sql = "SELECT count(*) FROM guestbook";
			
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
	//�� ���
	public List<GuestbookDto> getList(int startRow, int endRow) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		List<GuestbookDto> list = null;
		
		try {
			//Ŀ�ؼ� Ǯ�κ��� Ŀ�ؼ��� �Ҵ�
			conn = getConnection();
			//����¡ ó���� ���� rownum�� �̿��� ������ ����
			sql = "SELECT * FROM (SELECT a.*, rownum rnum FROM (SELECT * FROM guestbook ORDER BY num DESC) a) WHERE rnum>=? and rnum<=?";
			
			pstmt = conn.prepareStatement(sql);
			//sql���� �����ϰ� ������� ResultSet�� ��ȯ
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			list = new ArrayList<GuestbookDto>(); 
			while(rs.next()) {
				//�ڹٺ� ����
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
			//�ڿ�����
			executeClose(rs, pstmt, conn);
		}
		
		return list;
	}
	//�� ��
	public GuestbookDto getGuestbook(int num) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		String sql= null;
		GuestbookDto book = null;
		
		try {
			//Ŀ�ؼ� Ǯ�κ��� Ŀ�ؼ��� �Ҵ�
			conn = getConnection();
			
			//SQL�� �ۼ�
			sql = "SELECT * FROM guestbook WHERE num=?";
			//PreparedStatement��ü ����
			pstmt= conn.prepareStatement(sql);
			//SQL���� ?�� ������ ���ε�
			pstmt.setInt(1, num);
			//SQL���� �ݿ��ϰ� ������� ResultSet�� ����
			rs = pstmt.executeQuery();
			//if���� ����Ͽ� �ڹٺ� �Ѱ��� ���ڵ� ������ ����
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
			//�ڿ� ����
			executeClose(rs, pstmt, conn);
		}
		
		return book;
	}
	//�� ����
	public void update(GuestbookDto book) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		String sql = null;
		
		try{
			//Ŀ�ؼ� Ǯ�κ��� Ŀ�ؼ��� �Ҵ�
			conn = getConnection();
			//sql�� �ۼ�
			//name, email, content ���� ����
			//�⺻Ű : num
			sql = "UPDATE guestbook SET name=?, email=?, content=? WHERE num =?";
			//PreParedStatement ��ü ����
			pstmt = conn.prepareStatement(sql);			
			//SQL���� ?�� ������ ���ε�
			pstmt.setString(++cnt, book.getName());
			pstmt.setString(++cnt, book.getEmail());
			pstmt.setString(++cnt, book.getContent());
			pstmt.setInt(++cnt, book.getNum());
			//SQL�� ����
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(null, pstmt, conn);
		}
	}
	//�� ����
	public void delete(int num) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			conn = getConnection();
			
			sql = "DELETE FROM guestbook WHERE num=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(null, pstmt, conn);
		}
	}
	

}
