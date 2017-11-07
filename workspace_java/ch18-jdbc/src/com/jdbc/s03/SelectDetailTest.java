package com.jdbc.s03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectDetailTest {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			//JDBC ���� 1,2�ܰ�
			conn = ConnectionMgr.getConnection();
			
			sql ="SELECT * FROM test2 WHERE num=?";
			
			//JDBC ���� 3�ܰ�
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 2);
			
			//JDBC ���� 4�ܰ�
			rs = pstmt.executeQuery();
			
			//num�� primary key�̱� ������ ����ϰ� �ϳ��� �ุ�� ��ȯ
			//�׷��� ������ while���� ��������ʰ� if���� ��� ��
			if(rs.next()) {
				System.out.println("��ȣ :" + rs.getInt("num"));
				System.out.println("���� : " + rs.getString("title"));
				System.out.println("�ۼ��� : " + rs.getString("name"));
				System.out.println("���� : " + rs.getString("memo"));
				System.out.println("�̸��� : " + rs.getString("email"));
				System.out.println("�ۼ���¥ : " + rs.getDate("register"));
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionMgr.executeClose(rs, pstmt, conn);
		}
	}
}
