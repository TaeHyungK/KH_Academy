package com.jdbc.s03;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateTest {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			//JDBC 수행 1,2단계
			conn = ConnectionMgr.getConnection();
			
			sql = "UPDATE test2 SET title=?, name=?, memo=?, email=? WHERE num=?";
			
			//JDBC 수행 3단계  : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			//SQL문에 명시한 "?" 데이터에 대한 바인딩 처리
			pstmt.setString(1, "바다");
			pstmt.setString(2, "강호동");
			pstmt.setString(3, "노인과 바다");
			pstmt.setString(4, "email@cahnged.com");
			pstmt.setInt(5, 1);
			
			//JDBC 수행 4단계 : sql문 실행
			int count = pstmt.executeUpdate();
			System.out.println(count + "개의 행 정보를 수정했습니다.");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			ConnectionMgr.executeClose(null, pstmt, conn);
		}
	}
}
