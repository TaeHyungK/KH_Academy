package com.jdbc.s01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
	public static void main(String[] args) {
		String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "scott";
		String passwd = "tiger";
		try {
			//OracleDriver�� �޸� �ε�
			Class.forName("oracle.jdbc.OracleDriver");
			//Connection ��ü
			//����Ŭ �ּ�, ����ID, �н����带 �����ϰ� ����Ŭ�� ����
			Connection conn = DriverManager.getConnection(dbUrl, id, passwd);
			System.out.println("Connection ��ü�� �����Ǿ����ϴ�.");
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
