package my.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import my.product.domain.ProductDto;

public class ProductDao {
	private static ProductDao instance = new ProductDao();

	public static ProductDao getInstance() {
		return instance;
	}

	private ProductDao() {}

	private Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		DataSource ds = (DataSource)initCtx.lookup("java:comp/env/jdbc/xe");
		return ds.getConnection();
	}

	private void executeClose(ResultSet rs,PreparedStatement pstmt,Connection conn) {
		if(rs!=null)try {rs.close();} catch(SQLException e) {}
		if(pstmt!=null)try {pstmt.close();} catch(SQLException e) {}
		if(conn!=null)try {conn.close();} catch(SQLException e) {}
	}

	//상품 등록
	public void productInsert(ProductDto product) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int cnt = 0;

		try {
			conn = getConnection();
			sql = "INSERT INTO xproduct VALUES(product_seq.nextval,?,?,?,?,SYSDATE)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(++cnt, product.getName());
			pstmt.setInt(++cnt, product.getPrice());
			pstmt.setInt(++cnt, product.getStock());
			pstmt.setString(++cnt, product.getContent());
			

			pstmt.executeUpdate();

		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(null,pstmt,conn);
		}
	}

	//상품의 총 갯수
	public int getCount() throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int count = 0;

		try {
			conn = getConnection();

			sql = "SELECT count(*) FROM xproduct";

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				count = rs.getInt(1);
			}

		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(rs, pstmt, conn);
		}

		return count;
	}

	//상품 목록
	public List<ProductDto> getList(int startRow, int endRow) throws Exception {
		List<ProductDto> list = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		try {
			//커넥션 풀로부터 커넥션을 할당
			conn =getConnection();
			//sql문 작성
			sql = "SELECT * FROM (SELECT a.*, rownum rnum FROM (SELECT * FROM xproduct ORDER BY num DESC) a) WHERE rnum>=? and rnum<=?";
			//PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			//sql문을 실행하고 결과행을 ResultSet에 담음
			rs = pstmt.executeQuery();
			//ArrayList 객체 생성
			list = new ArrayList<ProductDto>();
			while(rs.next()) {
				//자바빈 생성
				ProductDto product = new ProductDto();
				product.setNum(rs.getInt("num"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getInt("price"));
				product.setStock(rs.getInt("stock"));
				product.setContent(rs.getString("content"));
				product.setReg_date(rs.getDate("reg_date"));

				//자바빈을 ArrayList에 등록
				list.add(product);
			}
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(rs,pstmt,conn);
		}
		return list;
	}

	//상품 상세
	public ProductDto getProduct(int num) throws Exception{
		ProductDto product = null;

		return product;
	}

	//상품 수정
	public void productUpdate(ProductDto product) throws Exception{

	}

	//상품 삭제
	public void productDelete(int num) throws Exception{

	}
}