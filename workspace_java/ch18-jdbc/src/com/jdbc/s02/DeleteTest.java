package com.jdbc.s02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteTest {
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
			//JDBC 수행 2단계 : Connection 객체 생성(id,password 인증)
			conn = DriverManager.getConnection(dbUrl, id, password);
			
			//sql문 작성
			sql = "DELETE FROM test1 WHERE age = 100";
			
			//JDBC 수행 3단계 : Statement 객체 생성
			stmt = conn.createStatement();
			
			//JDBC 수행 4단계 : sql문을 실행하고 삭제한 행의 갯수 반환
			int count = stmt.executeUpdate(sql);
			
			System.out.println(count + "개 행이 삭제되었습니다.");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(stmt != null) try {stmt.close();} catch(Exception e) {}
			if(conn != null) try {conn.close();} catch(Exception e) {}
		}
	}
}
