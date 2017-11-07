package com.jdbc.s02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateTest {
	public static void main(String[] args) {
		String driverName = "oracle.jdbc.OracleDriver";
		String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "scott";
		String password = "tiger";
		
		String sql = null;
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			//JDBC ���� 1�ܰ� : ����̹� �ε�
			Class.forName(driverName);
			//JDBC ���� 2�ܰ� : Connection ����(id,password ����)
			conn = DriverManager.getConnection(dbUrl,id,password);
			
			//sql�� �ۼ�
			sql = "UPDATE test1 SET age = 90 WHERE id='sky'";
			
			//JDBC ���� 3�ܰ� : Statement ��ü ����
			stmt = conn.createStatement();
			
			//JDBC ���� 4�ܰ� : sql�� ����
			int count = stmt.executeUpdate(sql);
			System.out.println(count + "�� ���� ������ �����߽��ϴ�.");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//�ڿ� ����
			if(stmt != null) try {stmt.close();} catch(Exception e) {}
			if(conn != null) try {conn.close();} catch(Exception e) {}
		}
	}
}
