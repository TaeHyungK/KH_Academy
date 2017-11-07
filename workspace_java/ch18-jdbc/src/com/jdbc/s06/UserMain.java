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
				System.out.println("1.회원가입 2.정보보기 3.수정 4.삭제 5.종료");
				System.out.print("선택> ");

				String num = u.input();

				if(num.equals("1")) {
					//회원가입
					u.register();
				}else if(num.equals("2")) {
					//정보보기
					u.getMemberInfo();
				}else if(num.equals("3")) {
					//수정
					u.modifyMemberInfo();
				}else if(num.equals("4")) {
					//삭제
					u.deleteMembeInfo();
				}else if(num.equals("5")) {
					//종료
					System.out.println("회원관리 종료!!");
					break;
				}else {
					System.out.println("잘못 입력했습니다.");
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	//데이터 입력
	public String input() throws IOException{
		return br.readLine();
	}

	//회원 가입
	public void register() throws IOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;

		System.out.print("아이디: ");
		String mId = input();

		System.out.print("이름: ");
		String name = input();

		System.out.print("비밀번호: ");
		String mPasswd = input();

		System.out.print("전화번호: ");
		String mPhone = input();

		try {
			//JDBC 수행 1,2단계
			conn = ConnectionMgr.getConnection();
			//sql문 작성
			sql = "INSERT INTO muser(mid, name, mpasswd, mphone, register) "
					+ "VALUES(?, ?, ?, ?, SYSDATE)";
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			pstmt.setString(2, name);
			pstmt.setString(3, mPasswd);
			pstmt.setString(4, mPhone);
			//JDBC 수행 4단계
			int count = pstmt.executeUpdate();
			if(count > 0) {
				System.out.println(name + "님 회원가입이 완료 되었습니다.");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionMgr.executeClose(null, pstmt, conn);
		}
	}
	//정보보기
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
			System.out.println("아이디\t이름\t비밀번호\t전화번호\t가입날짜");
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
	//수정
	public void modifyMemberInfo(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = null;
		
		try {
			System.out.print("수정할 아이디 입력> ");
			String modifyId = input();
			
			System.out.print("이름 입력> ");
			String modifyName = input();
			
			System.out.print("비밀번호 입력> ");
			String modifyPasswd = input();
			
			System.out.print("전화번호 입력> ");
			String modifyPhone = input();			
			
			conn = ConnectionMgr.getConnection();
			
			sql = "UPDATE muser SET name=?, mpasswd=?, mphone=? WHERE mid=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, modifyName);
			pstmt.setString(2, modifyPasswd);
			pstmt.setString(3, modifyPhone);
			pstmt.setString(4, modifyId);
			
			int count = pstmt.executeUpdate();
			System.out.println(modifyId + "의 정보를 수정하였습니다.");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
	}
	//삭제
	public void deleteMembeInfo() throws IOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = null;

		System.out.print("삭제할 아이디 입력> ");
		String deleteId = input();		
		
		try {		
			conn = ConnectionMgr.getConnection();
			
			sql = "DELETE FROM muser WHERE mid = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, deleteId);
			
			int count = pstmt.executeUpdate();
			if(count > 0) {
				System.out.println(deleteId + "가 삭제되었습니다.");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionMgr.executeClose(null, pstmt, conn);
		}
	}
}
