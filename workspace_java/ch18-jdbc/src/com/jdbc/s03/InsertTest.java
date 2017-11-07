package com.jdbc.s03;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertTest {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = null;
		
		try {
			//JDBC 수행 1,2단계
			conn = ConnectionMgr.getConnection();
			
			System.out.println("test2 테이블에 데이터를 추가합니다.");
			
			//sql문 작성
			sql = "INSERT INTO test2(num, title, name, memo, email, register) "
					+ "VALUES (num_seq.nextval, ?, ?, ?, ?, SYSDATE)";
			
			//JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "패배");
			pstmt.setString(2, "감사용");
			pstmt.setString(3, "좌절!!");
			pstmt.setString(4, "test@email.com");
			
			//JDBC 수행 4단계 : sql문 실행
			int count = pstmt.executeUpdate();
			System.out.println(count + "개 행이 추가되었습니다.");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//자원 정리
			ConnectionMgr.executeClose(null, pstmt, conn);
		}
	}
}
