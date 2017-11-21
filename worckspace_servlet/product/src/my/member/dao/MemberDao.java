package my.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import my.member.domain.MemberDto;

public class MemberDao {
   private static MemberDao instance = new MemberDao();

   public static MemberDao getInstance() {
      return instance;
   }

   private MemberDao() {}

   private Connection getConnection()throws Exception{
      Context initCtx = new InitialContext();
      DataSource ds = (DataSource)initCtx.lookup("java:comp/env/jdbc/xe");
      return ds.getConnection();
   }
   //자원정리
   private void executeClose(ResultSet rs,PreparedStatement pstmt,Connection conn) {
      if(rs!=null)try {rs.close();}catch(SQLException e) {}
      if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
      if(conn!=null)try {conn.close();}catch(SQLException e) {}
   }
   
   //회원가입
   public void insertMember(MemberDto member)throws Exception{
      Connection conn = null;
      PreparedStatement pstmt = null;
      String sql = null;
      
      try {
    	  conn = getConnection();
          
          sql = "INSERT INTO xmember values(?,?,?,?,?,?,?,sysdate)";
       
          pstmt = conn.prepareStatement(sql);
          pstmt.setString(1, member.getId());
          pstmt.setString(2, member.getName());
          pstmt.setString(3, member.getPasswd());
          pstmt.setString(4, member.getEmail());
          pstmt.setString(5, member.getPhone());
          pstmt.setString(6, member.getZipcode());
          pstmt.setString(7, member.getAddress());
          
          pstmt.executeUpdate();
      }catch(Exception e) {
         throw new Exception(e);
      }finally {
         //자원정리
         executeClose(null, pstmt, conn);
      }      
   }
   
   //회원상세정보
   public MemberDto getMember(String id)throws Exception{
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      String sql = null;
      MemberDto member = null;
      
      try {
    	  conn = getConnection();
    	  
    	  sql = "SELECT * FROM xmember WHERE id=?";
    	  
    	  pstmt = conn.prepareStatement(sql);
    	  pstmt.setString(1, id);
    	  
    	  rs = pstmt.executeQuery();
    	  
    	  if(rs.next()) {
    		  member = new MemberDto();
    		  member.setId(rs.getString("id"));
    		  member.setName(rs.getString("name"));
    		  member.setPasswd(rs.getString("passwd"));
    		  member.setEmail(rs.getString("email"));
    		  member.setPhone(rs.getString("phone"));
    		  member.setZipcode(rs.getString("zipcode"));
    		  member.setAddress(rs.getString("address"));
    		  member.setReg_date(rs.getDate("reg_date"));
    	  }
    	  
    	  
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         //자원정리
         executeClose(rs, pstmt, conn);
      }
      return member;
   }
   
   public void deleteMember(String id) throws Exception{
	   Connection conn = null;
	   PreparedStatement pstmt = null;
	   String sql = null;
	   
	   try {
			//커넥션풀로부터 커넥션을 할당 받음
			conn = getConnection();
			//SQL문
			sql = "DELETE FROM xmember WHERE id=?";

			//PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			//SQL문의 ?에 데이터에 바인딩
			pstmt.setString(1, id);

			//SQL문 반영
			pstmt.executeUpdate();

		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			//자원정리
			executeClose(null, pstmt, conn);
		}
	   
   }
   
   public void updateMember(MemberDto member) throws Exception{
	   Connection conn = null;
	   PreparedStatement pstmt = null;
	   String sql = null;
	   int cnt =0;
	   
	   try {
			//커넥션풀로부터 커넥션을 할당 받음
			conn = getConnection();
			//SQL문 테이블명:smember 컬럼:name,passwd,email,phone 기본키:id
			sql = "UPDATE xmember SET name=?,passwd=?,email=?,phone=?,zipcode=?,address=? WHERE id=?";
			//PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			//SQL문의 ?에 데이터에 바인딩
			pstmt.setString(++cnt, member.getName());
			pstmt.setString(++cnt, member.getPasswd());
			pstmt.setString(++cnt, member.getEmail());
			pstmt.setString(++cnt, member.getPhone());
			pstmt.setString(++cnt, member.getZipcode());
			pstmt.setString(++cnt, member.getAddress());
			pstmt.setString(++cnt, member.getId());
			//SQL문 반영
			pstmt.executeUpdate();
		}catch(Exception e) {
			//자원정리
			executeClose(null, pstmt, conn);
		}
   }
   
}