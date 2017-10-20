package com.jdbc.s05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jdbc.s03.ConnectionMgr;

public class TransactionMain {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		
		String sql = null;
		
		try {
			//JDBC 수행 1,2단계
			conn = ConnectionMgr.getConnection();
			conn.setAutoCommit(false);
			
			sql = "INSERT INTO test1 VALUES('A100', 10)";
			pstmt1 = conn.prepareStatement(sql);
			pstmt1.executeUpdate();
			
			sql = "INSERT INTO test1 VALUES('A200', 20)";
			pstmt2 = conn.prepareStatement(sql);
			pstmt2.executeUpdate();
			
			//테스트 용으로 오류가 있는 SQL문 작성
			sql = "INSERT INTO test1 VALUES('A300', 30";
			pstmt3 = conn.prepareStatement(sql);
			pstmt3.executeUpdate();
			
			//정상적으로 SQL문이 실행되면 COMMIT 수행
			conn.commit();
			
		}catch(Exception e) {
			//예외가 발생하면 ROLLBACK 수행
			try {
				conn.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			
			e.printStackTrace();
		}finally {
			ConnectionMgr.executeClose(null, pstmt3, null);
			ConnectionMgr.executeClose(null, pstmt2, null);
			ConnectionMgr.executeClose(null, pstmt1, conn);
			
		}
	}
}
