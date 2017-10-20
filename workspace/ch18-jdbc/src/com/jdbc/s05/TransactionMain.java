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
			//JDBC ���� 1,2�ܰ�
			conn = ConnectionMgr.getConnection();
			conn.setAutoCommit(false);
			
			sql = "INSERT INTO test1 VALUES('A100', 10)";
			pstmt1 = conn.prepareStatement(sql);
			pstmt1.executeUpdate();
			
			sql = "INSERT INTO test1 VALUES('A200', 20)";
			pstmt2 = conn.prepareStatement(sql);
			pstmt2.executeUpdate();
			
			//�׽�Ʈ ������ ������ �ִ� SQL�� �ۼ�
			sql = "INSERT INTO test1 VALUES('A300', 30";
			pstmt3 = conn.prepareStatement(sql);
			pstmt3.executeUpdate();
			
			//���������� SQL���� ����Ǹ� COMMIT ����
			conn.commit();
			
		}catch(Exception e) {
			//���ܰ� �߻��ϸ� ROLLBACK ����
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
