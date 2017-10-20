package com.jdbc.s08;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GoodsDao {
	//드라이버 로드, Connection 생성 및 반환
	public static Connection getConnection() {
		String drivername = "oracle.jdbc.OracleDriver";
		String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "scott";
		String password = "tiger";

		Connection conn = null;
		try {
			//JDBC 수행 1단계 : 드라이버 로드
			Class.forName(drivername);
			//JDBC 수행 2단계 : Connection 객체 생성(ID,비번인증)
			conn = DriverManager.getConnection(dburl,id,password);
			//SQL문 작성

		}catch(Exception e) {
			e.printStackTrace();
		}

		return conn;
	}

	//자원 정리
	public static void executeClose(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if(rs != null) try {rs.close();} catch(Exception e) {}
		if(pstmt != null) try {pstmt.close();} catch(Exception e) {}
		if(conn != null) try {conn.close();} catch(Exception e) {}	
	}
	//자원 정리
	public static void executeClose(ResultSet rs, CallableStatement cstmt ,PreparedStatement pstmt, Connection conn) {
		if(rs != null) try {rs.close();} catch(Exception e) {}
		if(cstmt != null) try {cstmt.close();} catch(Exception e) {}
		if(pstmt != null) try {pstmt.close();} catch(Exception e) {}
		if(conn != null) try {conn.close();} catch(Exception e) {}	
	}

	//상품 등록
	public int insertInfo(Goods goods) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;

		int count = 0;

		try {
			//JDBC수행 1,2단계
			conn = getConnection();
			//SQL문 작성
			sql = "INSERT INTO goodsinfo "
					+ "VALUES (?,?,?,?)";
			//JDBC수행 3단계
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setString(1, goods.getCode()); // code
			pstmt.setString(2, goods.getName()); //name
			pstmt.setInt(3, goods.getPrice()); //price
			pstmt.setString(4, goods.getMaker()); //maker
			//JDBC수행 4단계
			count = pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();

			return count;
		}finally {
			executeClose(null, pstmt, conn);
		}

		return count;

	}
	//상품 목록
	public ArrayList<Goods> listInfo(){
		ArrayList<Goods> list = null;
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;

		String sql = null;

		try {
			conn = getConnection();

			sql = "SELECT * FROM goodsinfo ORDER BY code DESC";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			list = new ArrayList<Goods>();

			while(rs.next()) {
				Goods goods = new Goods();

				goods.setCode(rs.getString("code"));
				goods.setName(rs.getString("name"));
				goods.setPrice(rs.getInt("price"));
				goods.setMaker(rs.getString("maker"));

				list.add(goods);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			executeClose(rs, pstmt, conn);
		}

		return list;
	}
	//상품 수정
	public int updateInfo(ArrayList<Goods> list) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;

		int count = 0;

		try {
			conn = getConnection();
			//오토 커밋 해제
			conn.setAutoCommit(false);

			sql = "UPDATE goodsinfo SET "
					+ "name =?, price =?, maker =? WHERE code =?";
			pstmt = conn.prepareStatement(sql);

			for(Goods goods : list) {
				//sql문의 ?에 데이터를 바인딩
				pstmt.setString(1, goods.getName());
				pstmt.setInt(2, goods.getPrice());
				pstmt.setString(3, goods.getMaker());
				pstmt.setString(4, goods.getCode());

				//리스트 형태로 처리하기 위해 값을 다 모아주는 메소드
				pstmt.addBatch();
			}
			//모여놓은 데이터를 한번에 처리하는 메소드
			count = pstmt.executeBatch().length;

			conn.commit();

		}catch(Exception e) {
			try {
				conn.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			e.printStackTrace();

			return count;
		}finally {
			executeClose(null, pstmt, conn);
		}
		return count;
	}
	//상품 삭제
	public int deleteInfo(String[] code) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int count = 0;

		try {
			conn = getConnection();
			conn.setAutoCommit(false);

			sql = "DELETE FROM goodsinfo WHERE code =?";

			pstmt = conn.prepareStatement(sql);
			for(int i = 0;i<code.length;i++) {
				pstmt.setString(1, code[i]);
				pstmt.addBatch();
			}

			count = pstmt.executeBatch().length;
			
			conn.commit();

		}catch(Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return count;
		}finally {
			executeClose(null, pstmt, conn);
		}


		return count;
	}


}
