package com.jdbc.s04;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jdbc.s03.ConnectionMgr;

public class CallableStatementEx {
	public static void main(String[] args) {
		Connection conn = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		CallableStatement cstmt = null;
		
		String sql = null;
		
		try {
			//JDBC ���� 1,2�ܰ�
			conn = ConnectionMgr.getConnection();
			
			//sql�� �ۼ�
			sql = "SELECT name,pay FROM salary";
			
			//JDBC ���� 3�ܰ�
			pstmt = conn.prepareStatement(sql);
			//JDBC ���� 4�ܰ�
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String name = rs.getString(1);
				int pay = rs.getInt(2);
				
				System.out.print("name: " + name);
				System.out.println(", pay: " + pay);
			}
			
			System.out.println("----------------");
			System.out.println("�޿� �����ϱ�");
			
			//���ν��� ȣ�� ���� : ���ν����� �߰�ȣ({})�� �̿��ؼ� ȣ��
			sql = "{call adjust(?,?)}";
			
			//JDBC ���� 3�ܰ�
			cstmt = conn.prepareCall(sql);
			//?�� ������ ���ε�
			cstmt.setString(1, "Annie");
			cstmt.setFloat(2, 0.05f);
			
			//JDBC ���� 4�ܰ� : sql�� �ݿ�
			cstmt.executeUpdate();
			System.out.println("���ν��� �۾� �Ϸ�");
			
			System.out.println("----------------");
			System.out.println("����� �޿� ���� ����");
			
			sql = "SELECT name, pay FROM salary";
			
			//JDBC���� 3�ܰ�
			pstmt2 = conn.prepareStatement(sql);
			//JDBC���� 4�ܰ�
			rs2 = pstmt2.executeQuery();
			
			while(rs2.next()) {
				String name = rs2.getString(1);
				int pay = rs2.getInt(2);
				
				System.out.print("name: " + name);
				System.out.println(", pay: " + pay);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			//�ڿ� ����
			ConnectionMgr.executeClose(rs2, pstmt2, null);
			ConnectionMgr.executeClose(rs, cstmt, pstmt, conn);
			
		}
	}
}
