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
			//JDBC 수행 1단계 : 드라이버 로드
			Class.forName(driverName);
			//JDBC 수행 2단계 : Connection 생성(id,password 인증)
			conn = DriverManager.getConnection(dbUrl,id,password);
			
			//sql문 작성
			sql = "SELECT * FROM test1";
			
			//JDBC 수행 3단계 : Statement 객체 생성
			stmt = conn.createStatement();
			
			//JDBC 수행 4단계 : sql문 실행
			//				 레코드(행)을 전달받아 결과 집합을 만들고 ResultSet에 담음.
			rs = stmt.executeQuery(sql);
			System.out.println("ID\t나이");
			//ResultSet에 보관된 결과집합에 접근해서 행단위로 데이터를 추출
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
