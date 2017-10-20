package com.jdbc.s06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jdbc.s03.ConnectionMgr;

public class UserMain {
	BufferedReader br;

	public UserMain() {
		br = new BufferedReader(new InputStreamReader(System.in));

	}

	public static void main(String[] args) {
		UserMain u = new UserMain();
		try {
			while(true) {
				System.out.println("1.ȸ������ 2.�������� 3.���� 4.���� 5.����");
				System.out.print("����> ");

				String num = u.input();

				if(num.equals("1")) {
					//ȸ������
					u.register();
				}else if(num.equals("2")) {
					//��������
					u.getMemberInfo();
				}else if(num.equals("3")) {
					//����
					u.modifyMemberInfo();
				}else if(num.equals("4")) {
					//����
					u.deleteMembeInfo();
				}else if(num.equals("5")) {
					//����
					System.out.println("ȸ������ ����!!");
					break;
				}else {
					System.out.println("�߸� �Է��߽��ϴ�.");
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	//������ �Է�
	public String input() throws IOException{
		return br.readLine();
	}

	//ȸ�� ����
	public void register() throws IOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;

		System.out.print("���̵�: ");
		String mId = input();

		System.out.print("�̸�: ");
		String name = input();

		System.out.print("��й�ȣ: ");
		String mPasswd = input();

		System.out.print("��ȭ��ȣ: ");
		String mPhone = input();

		try {
			//JDBC ���� 1,2�ܰ�
			conn = ConnectionMgr.getConnection();
			//sql�� �ۼ�
			sql = "INSERT INTO muser(mid, name, mpasswd, mphone, register) "
					+ "VALUES(?, ?, ?, ?, SYSDATE)";
			//JDBC ���� 3�ܰ�
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			pstmt.setString(2, name);
			pstmt.setString(3, mPasswd);
			pstmt.setString(4, mPhone);
			//JDBC ���� 4�ܰ�
			int count = pstmt.executeUpdate();
			if(count > 0) {
				System.out.println(name + "�� ȸ�������� �Ϸ� �Ǿ����ϴ�.");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionMgr.executeClose(null, pstmt, conn);
		}
	}
	//��������
	public void getMemberInfo() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = null;
		try {
			conn = ConnectionMgr.getConnection();
			
			sql ="SELECT * FROM muser";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("���̵�\t�̸�\t��й�ȣ\t��ȭ��ȣ\t���Գ�¥");
			while(rs.next()) {
				System.out.print(rs.getString(1)+ "\t");
				System.out.print(rs.getString(2)+ "\t");
				System.out.print(rs.getString(3)+ "\t");
				System.out.print(rs.getString(4)+ "\t");
				System.out.print(rs.getString(5)+ "\n");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionMgr.executeClose(rs, pstmt, conn);
		}
	}
	//����
	public void modifyMemberInfo(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = null;
		
		try {
			System.out.print("������ ���̵� �Է�> ");
			String modifyId = input();
			
			System.out.print("�̸� �Է�> ");
			String modifyName = input();
			
			System.out.print("��й�ȣ �Է�> ");
			String modifyPasswd = input();
			
			System.out.print("��ȭ��ȣ �Է�> ");
			String modifyPhone = input();			
			
			conn = ConnectionMgr.getConnection();
			
			sql = "UPDATE muser SET name=?, mpasswd=?, mphone=? WHERE mid=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, modifyName);
			pstmt.setString(2, modifyPasswd);
			pstmt.setString(3, modifyPhone);
			pstmt.setString(4, modifyId);
			
			int count = pstmt.executeUpdate();
			System.out.println(modifyId + "�� ������ �����Ͽ����ϴ�.");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
	}
	//����
	public void deleteMembeInfo() throws IOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = null;

		System.out.print("������ ���̵� �Է�> ");
		String deleteId = input();		
		
		try {		
			conn = ConnectionMgr.getConnection();
			
			sql = "DELETE FROM muser WHERE mid = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, deleteId);
			
			int count = pstmt.executeUpdate();
			if(count > 0) {
				System.out.println(deleteId + "�� �����Ǿ����ϴ�.");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionMgr.executeClose(null, pstmt, conn);
		}
	}
}
