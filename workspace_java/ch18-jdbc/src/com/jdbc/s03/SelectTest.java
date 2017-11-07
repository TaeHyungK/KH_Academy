package com.jdbc.s03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectTest {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			//JDBC ���� 1,2�ܰ�
			conn = ConnectionMgr.getConnection();
			
			//sql�� �ۼ�
			sql = "SELECT * FROM test2 ORDER BY num DESC";
			
			//JDBC ���� 3�ܰ� : PreparedStatement ��ü ����
			pstmt = conn.prepareStatement(sql);
			
			//JDBC ���� 4�ܰ� : ���� ����� ResultSet�� ����
			rs = pstmt.executeQuery();
			
			System.out.println("��ȣ\t����\t�̸�\t�޸�\t�̸���\t����ð�");
			while(rs.next()) {
				System.out.print(rs.getInt("num") + "\t");
				System.out.print(rs.getString("title") + "\t");
				System.out.print(rs.getString("name") + "\t");
				System.out.print(rs.getString("memo") + "\t");
				System.out.print(rs.getString("email") + "\t");
				System.out.print(rs.getString("register") + "\n");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//�ڿ� ����
			ConnectionMgr.executeClose(rs, pstmt, conn);
		}
		
		
	}
}
