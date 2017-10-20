package com.jdbc.s07;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ScoreDao {
	public static Connection getConnection() {
		String drivername = "oracle.jdbc.OracleDriver";
		String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "scott";
		String password = "tiger";

		Connection conn = null;
		try {
			//JDBC ���� 1�ܰ� : ����̹� �ε�
			Class.forName(drivername);
			//JDBC ���� 2�ܰ� : Connection ��ü ����(ID,�������)
			conn = DriverManager.getConnection(dburl,id,password);
			//SQL�� �ۼ�

		}catch(Exception e) {
			e.printStackTrace();
		}

		return conn;
	}

	//�ڿ� ����
	public static void executeClose(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if(rs != null) try {rs.close();} catch(Exception e) {}
		if(pstmt != null) try {pstmt.close();} catch(Exception e) {}
		if(conn != null) try {conn.close();} catch(Exception e) {}	
	}
	//�ڿ� ����
	public static void executeClose(ResultSet rs, CallableStatement cstmt ,PreparedStatement pstmt, Connection conn) {
		if(rs != null) try {rs.close();} catch(Exception e) {}
		if(cstmt != null) try {cstmt.close();} catch(Exception e) {}
		if(pstmt != null) try {pstmt.close();} catch(Exception e) {}
		if(conn != null) try {conn.close();} catch(Exception e) {}	
	}


	//�����Է�
	public boolean insertInfo(Score sc) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = null;
		boolean f = true;
		try {
			//JDBC ���� 1,2�ܰ�
			conn = getConnection();
			//sql�� �ۼ�(num -> score_seq.nextval, reg_date - >SYSDATE)
			sql = "INSERT INTO score "
					+ "VALUES (score_seq.nextval, ?,?,?,?,?,?,?,SYSDATE)";
			
			//JDBC ���� 3�ܰ� : pstmt��ü ����
			pstmt = conn.prepareStatement(sql);
			//?�� ������ ���ε�
			pstmt.setString(1, sc.getName());
			pstmt.setInt(2, sc.getKor());
			pstmt.setInt(3, sc.getEng());
			pstmt.setInt(4, sc.getMath());
			pstmt.setInt(5, sc.makeSum());
			pstmt.setInt(6, sc.makeAvg());
			pstmt.setString(7, sc.makeGrade());
			//JDBC���� 4�ܰ� : sql�� ����
			int count = pstmt.executeUpdate();
			if(count <= 0) {
				f = false;
			}else {
				f = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			executeClose(null, pstmt, conn);
		}
		
		return f;
	}
	//���� ���
	public ArrayList<Score> selectInfo(){
		ArrayList<Score> list = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = null;
		try {
			//JDBC ���� 1,2�ܰ�
			conn = getConnection();
			
			//sql�� �ۼ�
			sql = "SELECT * FROM score ORDER BY num DESC";
			
			//JDBC ���� 3�ܰ� : pstmt ��ü ����
			pstmt = conn.prepareStatement(sql);
			
			//JDBC ���� 4�ܰ� : sql�� ����
			rs = pstmt.executeQuery();
			
			list = new ArrayList<Score>();
			while(rs.next()) {
				//��ȯ���� ���ڵ��� �����͸� Score��ü�� �����ؼ� ������
				Score sc = new Score();
				sc.setNum(rs.getInt("num"));
				sc.setName(rs.getString("name"));
				sc.setKor(rs.getInt("kor"));
				sc.setEng(rs.getInt("eng"));
				sc.setMath(rs.getInt("math"));
				sc.setSum(rs.getInt("sum"));
				sc.setAvg(rs.getInt("avg"));
				sc.setGrade(rs.getString("grade"));
				sc.setReg_date(rs.getDate("reg_date"));
				
				//Score ��ü�� ArrayList�� ����
				list.add(sc);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			executeClose(rs, pstmt, conn);
		}
		
		return list;
	}
	//��������
	public boolean updateInfo(Score sc) {
		boolean result = true;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = null;
		
		try {
			//JDBC ���� 1,2�ܰ�
			conn = getConnection();
			
			//sql�� �ۼ�
			sql = "UPDATE score "
					+ "SET name=?, kor=?, eng=?, math=?, sum=?, avg=?, grade=?"
					+ "WHERE num = ?";
			
			//JDBC ���� 3�ܰ� : pstmt ��ü ����
			pstmt = conn.prepareStatement(sql);
			//?�� ������ ���ε�
			
			pstmt.setString(1, sc.getName());
			pstmt.setInt(2, sc.getKor());
			pstmt.setInt(3, sc.getEng());
			pstmt.setInt(4, sc.getMath());
			pstmt.setInt(5, sc.makeSum());
			pstmt.setInt(6, sc.makeAvg());
			pstmt.setString(7, sc.makeGrade());
			pstmt.setInt(8, sc.getNum());
						
			//JDBC ���� 4�ܰ� : sql�� ����
			int count = pstmt.executeUpdate();
			
			System.out.println(count);
			if(count <= 0 ) {
				result = false;
			}else {
				result = true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			result = false;
		}finally {
			executeClose(null, pstmt, conn);
		}
		
		return result;
	}
	
	//���� ����
	public boolean deleteInfo(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = null;
		
		boolean result = true;
		
		try {
			//JDBC ���� 1,2�ܰ�
			conn = getConnection();
			//sql�� �ۼ�
			sql = "DELETE FROM score WHERE num =?";
			//JDBC ���� 3�ܰ�
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			//JDBC ���� 4�ܰ�
			int count = pstmt.executeUpdate();
			if(count <= 0) {
				result = false;
			}else{
				result = true;
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
			result = false;
		}finally {
			executeClose(null, pstmt, conn);
		}
		
		return result;
	}

}
