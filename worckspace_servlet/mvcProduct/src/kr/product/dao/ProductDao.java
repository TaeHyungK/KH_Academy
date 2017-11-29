package kr.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.product.domain.ProductDto;

public class ProductDao {
	//�̱��� ����
	private static ProductDao instance = new ProductDao();
	public static ProductDao getInstance() {
		return instance;
	}

	private ProductDao() {

	}

	//context.xml���� ���������� �о�鿩 Ŀ�ؼ�Ǯ�κ��� Ŀ�ؼ��� �Ҵ� ����
	private Connection getConnection()throws Exception{
		Context initCtx = new InitialContext();
		DataSource ds = (DataSource)initCtx.lookup("java:comp/env/jdbc/xe");
		return ds.getConnection();
	}

	//�ڿ�����
	private void executeClose(ResultSet rs,PreparedStatement pstmt,Connection conn) {
		if(rs!=null)try {rs.close();}catch(SQLException e) {}
		if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
		if(conn!=null)try {conn.close();}catch(SQLException e) {}
	}
	
	//��ǰ���
	public void registerProduct(ProductDto product) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int cnt = 0;
		
		try {
			conn = getConnection();
			
			sql = "INSERT INTO product VALUES(?,?,?,?,?,SYSDATE)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(++cnt, product.getId());
			pstmt.setString(++cnt, product.getName());
			pstmt.setInt(++cnt, product.getPrice());
			pstmt.setInt(++cnt, product.getStock());
			pstmt.setString(++cnt, product.getPlace());
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(null, pstmt, conn);
		}
	}
	//���
	public List<ProductDto> getList() throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		List<ProductDto> list = null;
		ProductDto product = null;
		
		try {
			conn = getConnection();
			
			sql = "SELECT * FROM product ORDER BY reg_date DESC";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			list = new ArrayList<ProductDto>();
			while(rs.next()) {
				product = new ProductDto();
				product.setId(rs.getString("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getInt("price"));
				product.setStock(rs.getInt("stock"));
				product.setPlace(rs.getString("place"));
				product.setReg_date(rs.getDate("reg_date"));
				
				list.add(product);
			}
			
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(rs, pstmt, conn);
		}
		
		return list;
	}
	//��ǰ������
	public ProductDto getProduct(String id) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		ProductDto product = null;
		
		try {
			conn = getConnection();
			
			sql = "SELECT * FROM product WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				product = new ProductDto();
				product.setId(rs.getString("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getInt("price"));
				product.setStock(rs.getInt("stock"));
				product.setPlace(rs.getString("place"));
				product.setReg_date(rs.getDate("reg_date"));
			}
			
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(rs, pstmt, conn);
		}
		
		return product;
	}
	//��ǰ����
	public void updateProduct(ProductDto product) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int cnt = 0;
		
		try {
			conn = getConnection();
			
			sql = "UPDATE product SET name=?, price=?, stock=?, place=? WHERE id=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(++cnt, product.getName());
			pstmt.setInt(++cnt, product.getPrice());
			pstmt.setInt(++cnt, product.getStock());
			pstmt.setString(++cnt, product.getPlace());
			pstmt.setString(++cnt, product.getId());
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(null, pstmt, conn);
		}
	}
	//��ǰ����
	public void deleteProduct(String id) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			conn = getConnection();
			
			sql = "DELETE FROM product WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(null, pstmt, conn);
		}
	}
}
