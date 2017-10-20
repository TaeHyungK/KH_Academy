package com.jdbc.s03;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteTest {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			//JDBC 수행 1,2단계
			conn = ConnectionMgr.getConnection();
			
			sql = "DELETE FROM test2 WHERE num = ?";
			
			System.out.println("test2 테이블의 데이터를 삭제합니다.");
			
			//JDBC 수행 3단계 : preparedStatement 객체 생성
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 1);
			
			
			//JDBC 수행 4단계 : sql문 실행
			int count = pstmt.executeUpdate();
			System.out.println(count + "개의 행이 삭제되었습니다.");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			//자원 정리
			ConnectionMgr.executeClose(null, pstmt, conn);
		}
	}
}
