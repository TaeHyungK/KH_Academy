package com.jdbc.s03;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertTest {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = null;
		
		try {
			//JDBC ���� 1,2�ܰ�
			conn = ConnectionMgr.getConnection();
			
			System.out.println("test2 ���̺� �����͸� �߰��մϴ�.");
			
			//sql�� �ۼ�
			sql = "INSERT INTO test2(num, title, name, memo, email, register) "
					+ "VALUES (num_seq.nextval, ?, ?, ?, ?, SYSDATE)";
			
			//JDBC ���� 3�ܰ� : PreparedStatement ��ü ����
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "�й�");
			pstmt.setString(2, "�����");
			pstmt.setString(3, "����!!");
			pstmt.setString(4, "test@email.com");
			
			//JDBC ���� 4�ܰ� : sql�� ����
			int count = pstmt.executeUpdate();
			System.out.println(count + "�� ���� �߰��Ǿ����ϴ�.");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//�ڿ� ����
			ConnectionMgr.executeClose(null, pstmt, conn);
		}
	}
}
