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
			//OracleDriver를 메모리 로드
			Class.forName("oracle.jdbc.OracleDriver");
			//Connection 객체
			//오라클 주소, 계정ID, 패스워드를 제공하고 오라클에 접속
			Connection conn = DriverManager.getConnection(dbUrl, id, passwd);
			System.out.println("Connection 객체가 생성되었습니다.");
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
