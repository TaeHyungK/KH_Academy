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
			//JDBC 수행 1,2단계
			conn = ConnectionMgr.getConnection();
			
			//sql문 작성
			sql = "SELECT name,pay FROM salary";
			
			//JDBC 수행 3단계
			pstmt = conn.prepareStatement(sql);
			//JDBC 수행 4단계
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String name = rs.getString(1);
				int pay = rs.getInt(2);
				
				System.out.print("name: " + name);
				System.out.println(", pay: " + pay);
			}
			
			System.out.println("----------------");
			System.out.println("급여 변경하기");
			
			//프로시저 호출 문장 : 프로시저는 중괄호({})를 이용해서 호출
			sql = "{call adjust(?,?)}";
			
			//JDBC 수행 3단계
			cstmt = conn.prepareCall(sql);
			//?에 데이터 바인딩
			cstmt.setString(1, "Annie");
			cstmt.setFloat(2, 0.05f);
			
			//JDBC 수행 4단계 : sql문 반영
			cstmt.executeUpdate();
			System.out.println("프로시저 작업 완료");
			
			System.out.println("----------------");
			System.out.println("변경된 급여 정보 보기");
			
			sql = "SELECT name, pay FROM salary";
			
			//JDBC수행 3단계
			pstmt2 = conn.prepareStatement(sql);
			//JDBC수행 4단계
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
			//자원 정리
			ConnectionMgr.executeClose(rs2, pstmt2, null);
			ConnectionMgr.executeClose(rs, cstmt, pstmt, conn);
			
		}
	}
}
