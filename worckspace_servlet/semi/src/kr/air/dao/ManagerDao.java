package kr.air.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.air.domain.ManagerDto;


public class ManagerDao {
	//싱글턴 패턴
	private static ManagerDao instance = new ManagerDao();
	public static ManagerDao getInstance() {
		return instance;
	}
	private ManagerDao() {}
	
	private Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		DataSource ds = 
				(DataSource)initCtx.lookup("java:comp/env/jdbc/xe");
		return ds.getConnection();
		
	}
	//자원정리
	private void executeClose(ResultSet rs,PreparedStatement pstmt,Connection conn) {
		if(rs!=null)try {rs.close();}catch(SQLException e) {}
		if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
		if(conn!=null)try {conn.close();}catch(SQLException e) {}
	
	}
	//전체 회원수,검색 회원수
		public int getReboardCount(String keyfield,String keyword)throws Exception{
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;
			int count = 0;
			
			try {
				conn = getConnection();
				if(keyword == null || "".equals(keyword)) {
					//전체글의 갯수
					sql = "SELECT COUNT(*) FROM register_1";
					pstmt = conn.prepareStatement(sql);
				}else {
					//검색글의 갯수
					sql = "SELECT COUNT(*) FROM register_1 WHERE " + keyfield + " like ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, "%"+keyword+"%");
				}
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					count = rs.getInt(1);
				}
			}catch(Exception e) {
				throw new Exception(e);
			}finally {
				executeClose(rs,pstmt,conn);
			}
			
			return count;
		}
		//회원 목록,검색 회원 목록
		public List<ManagerDto> getListReboard(int start,int end,String keyfield,String keyword)throws Exception{
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<ManagerDto> list = null;
			String sql = null;
			  
			try {
				conn = getConnection();
				if(keyword==null||"".equals(keyword)) {
					//전체 글 보기
					sql = "SELECT * FROM(SELECT a.*,rownum rnum FROM (SELECT * FROM register_1 ORDER BY name DESC)a) WHERE rnum >= ? AND rnum <= ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, start);
					pstmt.setInt(2, end);
				}else {  
					//검색글 보기
		            sql = "SELECT * FROM(SELECT a.*,rownum rnum FROM (SELECT * FROM register_1 WHERE "+keyfield+" like ? ORDER BY name DESC)a) WHERE rnum >= ? AND rnum <= ?";
		              pstmt = conn.prepareStatement(sql);
		              pstmt.setString(1, "%"+keyword+"%");
		              pstmt.setInt(2, start);
		              pstmt.setInt(3, end);
		        }
				rs = pstmt.executeQuery();
				
				list = new ArrayList<ManagerDto>();
				while(rs.next()) {
					ManagerDto manager = new ManagerDto();
					manager.setId(rs.getString("id"));
					manager.setName(rs.getString("name"));
					manager.setPhone(rs.getString("phone"));
					manager.setSex(rs.getString("sex"));
					manager.setCard_num(rs.getString("card_num"));
					
					list.add(manager);
				}
			}catch(Exception e) {
				throw new Exception(e);
			}finally {
				executeClose(rs,pstmt,conn);
			}
			
			return list;
		}
		//상세
		public ManagerDto getManager(String id)throws Exception{
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ManagerDto manager = null;
			String sql = null;
			
			try {
				conn = getConnection();
				sql = "select * FROM register_1 WHERE id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					manager = new ManagerDto();
					manager.setName(rs.getString("name"));
					manager.setId(rs.getString("id"));
					manager.setPasswd(rs.getString("passwd"));
					manager.setPhone(rs.getString("phone"));
					manager.setSex(rs.getString("sex"));
					manager.setCard_num(rs.getString("card_num"));
				}
				
			}catch(Exception e) {
				throw new Exception(e);
			}finally {
				executeClose(rs,pstmt,conn);
			}
			
			return manager;
			
		}
		//회원정보 수정
		public void updateRegister_1(ManagerDto manager)throws Exception{
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = null;
			int cnt = 0;
			try {
				conn = getConnection();
				sql = "UPDATE register_1 SET name=?,phone=?,sex=?,card_num=? WHERE id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(++cnt,manager.getName());
				pstmt.setString(++cnt,manager.getPhone());
				pstmt.setString(++cnt,manager.getSex());
				pstmt.setString(++cnt,manager.getCard_num());
				pstmt.setString(++cnt,manager.getId());
				
				pstmt.executeUpdate();
				
			}catch(Exception e) {
				throw new Exception(e);
			}finally {
				executeClose(null,pstmt,conn);
			}
		}
		//회원 삭제
		public void deleteRegister_1(String id) throws Exception{
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = null;
			
			try {
				conn = getConnection();
				sql = "DELETE FROM register_1 WHERE id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				
				pstmt.executeUpdate();
				
			}catch(Exception e) {
				throw new Exception(e);
			}finally {
				executeClose(null,pstmt,conn);
			}
		}
}






























