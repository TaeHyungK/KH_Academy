package com.jdbc.s03;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateTest {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			//JDBC ���� 1,2�ܰ�
			conn = ConnectionMgr.getConnection();
			
			sql = "UPDATE test2 SET title=?, name=?, memo=?, email=? WHERE num=?";
			
			//JDBC ���� 3�ܰ�  : PreparedStatement ��ü ����
			pstmt = conn.prepareStatement(sql);
			//SQL���� ����� "?" �����Ϳ� ���� ���ε� ó��
			pstmt.setString(1, "�ٴ�");
			pstmt.setString(2, "��ȣ��");
			pstmt.setString(3, "���ΰ� �ٴ�");
			pstmt.setString(4, "email@cahnged.com");
			pstmt.setInt(5, 1);
			
			//JDBC ���� 4�ܰ� : sql�� ����
			int count = pstmt.executeUpdate();
			System.out.println(count + "���� �� ������ �����߽��ϴ�.");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			ConnectionMgr.executeClose(null, pstmt, conn);
		}
	}
}
