package com.jdbc.s03;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionMgr {
	private static final String DRIVERNAME = "oracle.jdbc.OracleDriver";
	private static final String DBURL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String ID = "scott";
	private static final String PASSWORD = "tiger";

	//Connection 객체 반환
	public static Connection getConnection() {
		Connection conn = null;
		try {
			//JDBC 수행 1단계 : 드라이버 로드
			Class.forName(DRIVERNAME);
			//JDBC 수행 2단계 : Connection 객체 생성(ID,비번인증)
			conn = DriverManager.getConnection(DBURL,ID,PASSWORD);
			//SQL문 작성

		}catch(Exception e) {
			e.printStackTrace();
		}

		return conn;
	}

	//자원 정리
	public static void executeClose(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if(rs != null) try {rs.close();} catch(Exception e) {}
		if(pstmt != null) try {pstmt.close();} catch(Exception e) {}
		if(conn != null) try {conn.close();} catch(Exception e) {}	
	}

	//자원 정리
	public static void executeClose(ResultSet rs, CallableStatement cstmt ,PreparedStatement pstmt, Connection conn) {
		if(rs != null) try {rs.close();} catch(Exception e) {}
		if(cstmt != null) try {cstmt.close();} catch(Exception e) {}
		if(pstmt != null) try {pstmt.close();} catch(Exception e) {}
		if(conn != null) try {conn.close();} catch(Exception e) {}	
	}
}
