package com.jdbc.s02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
	public static void main(String[] args) {
		String driverName = "oracle.jdbc.OracleDriver";
		String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "scott";
		String password = "tiger";
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			//JDBC ���� 1�ܰ� : ����̹� �ε�
			Class.forName(driverName);
			//JDBC ���� 2�ܰ� : Connection ��ü ����(ID,��� ����)
			conn = DriverManager.getConnection(dbUrl, id, password);
			
			System.out.println("test1 ���̺��� �����մϴ�.");
			
			//JDBC ���� 3�ܰ� : Statement ��ü ���� -> SQL������ �Ǿ� ������ ����
			stmt = conn.createStatement();
			
			//���̺��� �����ϴ� SQL��
			//������ ������ ���̺���� �ߺ��Ǹ� ������ �߻��ϱ� ������
			//���� ���������� �� ���� ������.
			String sql = "CREATE TABLE test1 (id varchar2(10), age number)";
			
			//JDBC ���� 4�ܰ� : SQL���� ������ DB�� ���̺��� �ݿ�
			stmt.executeUpdate(sql);
			
			System.out.println("���̺��� ���������� �����Ǿ����ϴ�.");
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}finally {
			//�ڿ� ����
			if(stmt != null) try {stmt.close();} catch(Exception e) {}
			if(conn != null) try {conn.close();} catch(Exception e) {}
		}
	}
}
