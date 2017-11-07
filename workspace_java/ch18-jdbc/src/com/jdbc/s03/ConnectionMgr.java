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

	//Connection ��ü ��ȯ
	public static Connection getConnection() {
		Connection conn = null;
		try {
			//JDBC ���� 1�ܰ� : ����̹� �ε�
			Class.forName(DRIVERNAME);
			//JDBC ���� 2�ܰ� : Connection ��ü ����(ID,�������)
			conn = DriverManager.getConnection(DBURL,ID,PASSWORD);
			//SQL�� �ۼ�

		}catch(Exception e) {
			e.printStackTrace();
		}

		return conn;
	}

	//�ڿ� ����
	public static void executeClose(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if(rs != null) try {rs.close();} catch(Exception e) {}
		if(pstmt != null) try {pstmt.close();} catch(Exception e) {}
		if(conn != null) try {conn.close();} catch(Exception e) {}	
	}

	//�ڿ� ����
	public static void executeClose(ResultSet rs, CallableStatement cstmt ,PreparedStatement pstmt, Connection conn) {
		if(rs != null) try {rs.close();} catch(Exception e) {}
		if(cstmt != null) try {cstmt.close();} catch(Exception e) {}
		if(pstmt != null) try {pstmt.close();} catch(Exception e) {}
		if(conn != null) try {conn.close();} catch(Exception e) {}	
	}
}
