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
   //�ڿ�����
   private void executeClose(ResultSet rs,PreparedStatement pstmt,Connection conn) {
      if(rs!=null)try {rs.close();}catch(SQLException e) {}
      if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
      if(conn!=null)try {conn.close();}catch(SQLException e) {}
   }
   
   //ȸ������
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
         //�ڿ�����
         executeClose(null, pstmt, conn);
      }      
   }
   
   //ȸ��������
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
         //�ڿ�����
         executeClose(rs, pstmt, conn);
      }
      return member;
   }
   
   public void deleteMember(String id) throws Exception{
	   Connection conn = null;
	   PreparedStatement pstmt = null;
	   String sql = null;
	   
	   try {
			//Ŀ�ؼ�Ǯ�κ��� Ŀ�ؼ��� �Ҵ� ����
			conn = getConnection();
			//SQL��
			sql = "DELETE FROM xmember WHERE id=?";

			//PreparedStatement ��ü ����
			pstmt = conn.prepareStatement(sql);

			//SQL���� ?�� �����Ϳ� ���ε�
			pstmt.setString(1, id);

			//SQL�� �ݿ�
			pstmt.executeUpdate();

		}catch(Exception e) {
			throw new Exception(e);
		}finally {
			//�ڿ�����
			executeClose(null, pstmt, conn);
		}
	   
   }
   
   public void updateMember(MemberDto member) throws Exception{
	   Connection conn = null;
	   PreparedStatement pstmt = null;
	   String sql = null;
	   int cnt =0;
	   
	   try {
			//Ŀ�ؼ�Ǯ�κ��� Ŀ�ؼ��� �Ҵ� ����
			conn = getConnection();
			//SQL�� ���̺��:smember �÷�:name,passwd,email,phone �⺻Ű:id
			sql = "UPDATE xmember SET name=?,passwd=?,email=?,phone=?,zipcode=?,address=? WHERE id=?";
			//PreparedStatement ��ü ����
			pstmt = conn.prepareStatement(sql);

			//SQL���� ?�� �����Ϳ� ���ε�
			pstmt.setString(++cnt, member.getName());
			pstmt.setString(++cnt, member.getPasswd());
			pstmt.setString(++cnt, member.getEmail());
			pstmt.setString(++cnt, member.getPhone());
			pstmt.setString(++cnt, member.getZipcode());
			pstmt.setString(++cnt, member.getAddress());
			pstmt.setString(++cnt, member.getId());
			//SQL�� �ݿ�
			pstmt.executeUpdate();
		}catch(Exception e) {
			//�ڿ�����
			executeClose(null, pstmt, conn);
		}
   }
   
}