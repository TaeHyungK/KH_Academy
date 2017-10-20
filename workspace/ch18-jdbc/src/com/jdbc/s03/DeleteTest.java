package com.jdbc.s03;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteTest {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			//JDBC ���� 1,2�ܰ�
			conn = ConnectionMgr.getConnection();
			
			sql = "DELETE FROM test2 WHERE num = ?";
			
			System.out.println("test2 ���̺��� �����͸� �����մϴ�.");
			
			//JDBC ���� 3�ܰ� : preparedStatement ��ü ����
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 1);
			
			
			//JDBC ���� 4�ܰ� : sql�� ����
			int count = pstmt.executeUpdate();
			System.out.println(count + "���� ���� �����Ǿ����ϴ�.");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			//�ڿ� ����
			ConnectionMgr.executeClose(null, pstmt, conn);
		}
	}
}
