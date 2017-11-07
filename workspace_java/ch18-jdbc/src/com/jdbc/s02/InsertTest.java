package com.jdbc.s02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest {
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
			//JDBC ���� 2�ܰ� : Connection ��ü ����(id,�н����� ����)
			conn = DriverManager.getConnection(dbUrl, id, password);
			//sql�� �ۼ�									��> ' �� ����ȭ�Ǿ��ֱ� ������ ��������ǥ(')�� �ϳ� �� �ٿ������.
			sql = "INSERT INTO test1 (id,age) VALUES ('s''t', 33)";
			
			//JDBC ���� 3�ܰ� : Statement ��ü ����
			stmt = conn.createStatement();
			
			//JDBC ���� 4�ܰ� : sql�� ����
			int count = stmt.executeUpdate(sql);
			
			System.out.println(count + "���� ���� �߰��߽��ϴ�.");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(stmt != null) try {stmt.close();} catch(Exception e) {}
			if(conn != null) try {conn.close();} catch(Exception e) {}
		}
	}
}
