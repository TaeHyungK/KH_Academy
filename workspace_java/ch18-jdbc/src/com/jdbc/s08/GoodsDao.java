package com.jdbc.s08;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GoodsDao {
	//����̹� �ε�, Connection ���� �� ��ȯ
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

	//��ǰ ���
	public int insertInfo(Goods goods) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;

		int count = 0;

		try {
			//JDBC���� 1,2�ܰ�
			conn = getConnection();
			//SQL�� �ۼ�
			sql = "INSERT INTO goodsinfo "
					+ "VALUES (?,?,?,?)";
			//JDBC���� 3�ܰ�
			pstmt = conn.prepareStatement(sql);
			//?�� ������ ���ε�
			pstmt.setString(1, goods.getCode()); // code
			pstmt.setString(2, goods.getName()); //name
			pstmt.setInt(3, goods.getPrice()); //price
			pstmt.setString(4, goods.getMaker()); //maker
			//JDBC���� 4�ܰ�
			count = pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();

			return count;
		}finally {
			executeClose(null, pstmt, conn);
		}

		return count;

	}
	//��ǰ ���
	public ArrayList<Goods> listInfo(){
		ArrayList<Goods> list = null;
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;

		String sql = null;

		try {
			conn = getConnection();

			sql = "SELECT * FROM goodsinfo ORDER BY code DESC";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			list = new ArrayList<Goods>();

			while(rs.next()) {
				Goods goods = new Goods();

				goods.setCode(rs.getString("code"));
				goods.setName(rs.getString("name"));
				goods.setPrice(rs.getInt("price"));
				goods.setMaker(rs.getString("maker"));

				list.add(goods);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			executeClose(rs, pstmt, conn);
		}

		return list;
	}
	//��ǰ ����
	public int updateInfo(ArrayList<Goods> list) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;

		int count = 0;

		try {
			conn = getConnection();
			//���� Ŀ�� ����
			conn.setAutoCommit(false);

			sql = "UPDATE goodsinfo SET "
					+ "name =?, price =?, maker =? WHERE code =?";
			pstmt = conn.prepareStatement(sql);

			for(Goods goods : list) {
				//sql���� ?�� �����͸� ���ε�
				pstmt.setString(1, goods.getName());
				pstmt.setInt(2, goods.getPrice());
				pstmt.setString(3, goods.getMaker());
				pstmt.setString(4, goods.getCode());

				//����Ʈ ���·� ó���ϱ� ���� ���� �� ����ִ� �޼ҵ�
				pstmt.addBatch();
			}
			//�𿩳��� �����͸� �ѹ��� ó���ϴ� �޼ҵ�
			count = pstmt.executeBatch().length;

			conn.commit();

		}catch(Exception e) {
			try {
				conn.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			e.printStackTrace();

			return count;
		}finally {
			executeClose(null, pstmt, conn);
		}
		return count;
	}
	//��ǰ ����
	public int deleteInfo(String[] code) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int count = 0;

		try {
			conn = getConnection();
			conn.setAutoCommit(false);

			sql = "DELETE FROM goodsinfo WHERE code =?";

			pstmt = conn.prepareStatement(sql);
			for(int i = 0;i<code.length;i++) {
				pstmt.setString(1, code[i]);
				pstmt.addBatch();
			}

			count = pstmt.executeBatch().length;
			
			conn.commit();

		}catch(Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return count;
		}finally {
			executeClose(null, pstmt, conn);
		}


		return count;
	}


}
