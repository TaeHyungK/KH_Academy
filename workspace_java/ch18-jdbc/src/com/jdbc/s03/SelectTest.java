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
			//JDBC 수행 1,2단계
			conn = ConnectionMgr.getConnection();
			
			//sql문 작성
			sql = "SELECT * FROM test2 ORDER BY num DESC";
			
			//JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			//JDBC 수행 4단계 : 쿼리 결과를 ResultSet에 담음
			rs = pstmt.executeQuery();
			
			System.out.println("번호\t제목\t이름\t메모\t이메일\t저장시간");
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
			//자원 정리
			ConnectionMgr.executeClose(rs, pstmt, conn);
		}
		
		
	}
}
