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
			//JDBC 수행 1,2단계
			conn = ConnectionMgr.getConnection();
			
			sql ="SELECT * FROM test2 WHERE num=?";
			
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 2);
			
			//JDBC 수행 4단계
			rs = pstmt.executeQuery();
			
			//num이 primary key이기 때문에 명백하게 하나의 행만을 반환
			//그렇기 때문에 while문을 사용하지않고 if문을 사용 함
			if(rs.next()) {
				System.out.println("번호 :" + rs.getInt("num"));
				System.out.println("제목 : " + rs.getString("title"));
				System.out.println("작성자 : " + rs.getString("name"));
				System.out.println("내용 : " + rs.getString("memo"));
				System.out.println("이메일 : " + rs.getString("email"));
				System.out.println("작성날짜 : " + rs.getDate("register"));
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionMgr.executeClose(rs, pstmt, conn);
		}
	}
}
