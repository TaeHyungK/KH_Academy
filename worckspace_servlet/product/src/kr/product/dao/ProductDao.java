package kr.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.product.domain.ProductDto;

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
		
	}
	
	//상품의 총 갯수
	public int getCount() throws Exception{
		int count =0;
		
		return count;
	}
	
	//상품 목록
	public List<ProductDto> getList(int startRow, int endRow) throws Exception {
		List<ProductDto> list = null;
		
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
