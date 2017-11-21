<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.ResultSet"%>
<%@ include file="dbInfo.jspf"%>
[<%
 	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	
	try{
		Class.forName(driverName);
		conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
		
		sql = "SELECT * FROM people ORDER BY id ASC";
		
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		while(rs.next()){
			String id =rs.getString("id");
			String name =rs.getString("name");
			String job =rs.getString("job");
			String address =rs.getString("address");
			String bloodtype =rs.getString("bloodtype");
			
			if(rs.getRow() > 1){
				out.print(',');
			}
%>
			{
				"id":"<%=id %>",
				"name":"<%=name %>",
				"job":"<%=job %>",
				"address":"<%=address %>",
				"bloodtype":"<%=bloodtype %>"
			}
<%
		}
		
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		//자원 정리
		if(rs!=null) try{rs.close();} catch(SQLException e){}
		if(pstmt!=null) try{pstmt.close();} catch(SQLException e){}
		if(conn!=null) try{conn.close();} catch(SQLException e){}
	}
 %>]
