<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.ResultSet"%>
<%@ include file="dbInfo.jspf"%>
<%--XML선언 : 생략 가능함! --%>
<?xml version="1.0" encoding="UTF-8"?>
<items>
<%
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	
	try{
		Class.forName(driverName);
		conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
		
		sql = "SELECT * FROM item ORDER BY code DESC";
		
		pstmt = conn.prepareStatement(sql);
		
		rs = pstmt.executeQuery();
		while(rs.next()){
%>
			<item>
				<code><%=rs.getInt("code") %></code>
				<name><%=rs.getString("name") %></name>
				<quantity><%=rs.getInt("quantity") %></quantity>
				<price><%=rs.getInt("price") %></price>
			</item>
<%
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		//자원 정리
		if(rs!=null) try{rs.close();} catch(Exception e){}
		if(pstmt!=null) try{pstmt.close();} catch(Exception e){}
		if(conn!=null) try{conn.close();} catch(Exception e){}
		
	}
%>
</items>
