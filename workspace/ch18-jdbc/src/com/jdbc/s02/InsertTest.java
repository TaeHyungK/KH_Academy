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
			//JDBC 수행 1단계 : 드라이버 로드
			Class.forName(driverName);
			//JDBC 수행 2단계 : Connection 객체 생성(id,패스워드 인증)
			conn = DriverManager.getConnection(dbUrl, id, password);
			//sql문 작성									┌> ' 는 문자화되어있기 때문에 작은따옴표(')를 하나 더 붙여줘야함.
			sql = "INSERT INTO test1 (id,age) VALUES ('s''t', 33)";
			
			//JDBC 수행 3단계 : Statement 객체 생성
			stmt = conn.createStatement();
			
			//JDBC 수행 4단계 : sql문 실행
			int count = stmt.executeUpdate(sql);
			
			System.out.println(count + "개의 행을 추가했습니다.");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(stmt != null) try {stmt.close();} catch(Exception e) {}
			if(conn != null) try {conn.close();} catch(Exception e) {}
		}
	}
}
