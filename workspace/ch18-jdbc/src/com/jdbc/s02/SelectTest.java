package com.jdbc.s02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectTest {
	public static void main(String[] args) {
		String driverName = "oracle.jdbc.OracleDriver";
		String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "scott";
		String password = "tiger";
		
		String sql = null;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			//JDBC ���� 1�ܰ� : ����̹� �ε�
			Class.forName(driverName);
			//JDBC ���� 2�ܰ� : Connection ����(id,password ����)
			conn = DriverManager.getConnection(dbUrl,id,password);
			
			//sql�� �ۼ�
			sql = "SELECT * FROM test1";
			
			//JDBC ���� 3�ܰ� : Statement ��ü ����
			stmt = conn.createStatement();
			
			//JDBC ���� 4�ܰ� : sql�� ����
			//				 ���ڵ�(��)�� ���޹޾� ��� ������ ����� ResultSet�� ����.
			rs = stmt.executeQuery(sql);
			System.out.println("ID\t����");
			//ResultSet�� ������ ������տ� �����ؼ� ������� �����͸� ����
			while(rs.next()) {
				System.out.print(rs.getString(1) + "\t" + rs.getInt(2) + "\n");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {rs.close();} catch(Exception e) {}
			if(stmt != null) try {stmt.close();} catch(Exception e) {}
			if(conn != null) try {conn.close();} catch(Exception e) {}
			
		}
	}
}
