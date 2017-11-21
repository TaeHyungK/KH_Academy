<%@ page language="java" contentType="text/plain; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.sql.ResultSet"%>
<%@ include file="dbInfo.jspf"%>
<%
	Connection conn = null;
	PreparedStatement pstmt =null;
	ResultSet rs = null;
	String sql = null;
	int count = 0;
	
	try{
		Class.forName(driverName);
		conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
		
		sql = "SELECT COUNT(*) FROM item";
		
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		if(rs.next()){
			count = rs.getInt(1);
		}
%>
		{
			"result":"success",
			"count":<%=count %>
		}
<%
		
	}catch(Exception e){
%>
		{
			"result":"failure"
		}
<%
		e.printStackTrace();
	}finally{
		//자원 정리
		if(rs!=null) try{rs.close();} catch(Exception e){}
		if(pstmt!=null) try{pstmt.close();} catch(Exception e){}
		if(conn!=null) try{conn.close();} catch(Exception e){}
	}
%>