<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="false"%>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.SQLException" %>
<%@page import="java.sql.ResultSet"%>
<%@ include file="dbInfo.jspf" %>
<%
	//전송된 데이터에 대한 인코딩
	request.setCharacterEncoding("UTF-8");
	//전송된 데이터 반환
	String id = request.getParameter("id");
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	
	try{
		Class.forName(driverName);
		conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
		sql = "SELECT id FROM zmember WHERE id=?";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		
		rs = pstmt.executeQuery();
		
		if(rs.next()){ //id 중복
%>
			{
				"result":"success",
				"id":"idDuplicated"
			}
<%
		}else{ //id 미중복
%>
			{
				"result":"success",
				"id":"idNotFound"
			}
<%

		}
		
	}catch(Exception e){
%>
			{
				"result":"failure"
			}
<%
		e.printStackTrace();
	}finally{
		//자원 정리
		if(rs!=null) try{rs.close();} catch(SQLException e){}
		if(pstmt!=null) try{pstmt.close();} catch(SQLException e){}
		if(conn!=null) try{conn.close();} catch(SQLException e){}
	}
%>