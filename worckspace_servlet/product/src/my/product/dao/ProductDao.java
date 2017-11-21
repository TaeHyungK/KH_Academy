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

	//��ǰ ���
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

	//��ǰ�� �� ����
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

	//��ǰ ���
	public List<ProductDto> getList(int startRow, int endRow) throws Exception {
		List<ProductDto> list = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		try {
			//Ŀ�ؼ� Ǯ�κ��� Ŀ�ؼ��� �Ҵ�
			conn =getConnection();
			//sql�� �ۼ�
			sql = "SELECT * FROM (SELECT a.*, rownum rnum FROM (SELECT * FROM xproduct ORDER BY num DESC) a) WHERE rnum>=? and rnum<=?";
			//PreparedStatement ��ü ����
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			//sql���� �����ϰ� ������� ResultSet�� ����
			rs = pstmt.executeQuery();
			//ArrayList ��ü ����
			list = new ArrayList<ProductDto>();
			while(rs.next()) {
				//�ڹٺ� ����
				ProductDto product = new ProductDto();
				product.setNum(rs.getInt("num"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getInt("price"));
				product.setStock(rs.getInt("stock"));
				product.setContent(rs.getString("content"));
				product.setReg_date(rs.getDate("reg_date"));

				//�ڹٺ��� ArrayList�� ���
				list.add(product);
			}
		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			executeClose(rs,pstmt,conn);
		}
		return list;
	}

	//��ǰ ��
	public ProductDto getProduct(int num) throws Exception{
		ProductDto product = null;

		return product;
	}

	//��ǰ ����
	public void productUpdate(ProductDto product) throws Exception{

	}

	//��ǰ ����
	public void productDelete(int num) throws Exception{

	}
}