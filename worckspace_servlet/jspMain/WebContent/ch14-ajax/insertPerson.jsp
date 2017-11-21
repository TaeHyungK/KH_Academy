<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.SQLException" %>
<%@ include file="dbInfo.jspf" %>
<%
	//전송된 데이터에 대한 인코딩
	request.setCharacterEncoding("UTF-8");
	
	//전송된 데이터를 반환
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String job = request.getParameter("job");
	String address = request.getParameter("address");
	String bloodtype = request.getParameter("bloodtype");
	
	Connection conn = null;
	PreparedStatement pstmt =null;
	String sql = null;
	int cnt = 0;
	
	try{
		Class.forName(driverName);
		conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
		
		sql = "INSERT INTO people VALUES(?,?,?,?,?)";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(++cnt, id);
		pstmt.setString(++cnt, name);
		pstmt.setString(++cnt, job);
		pstmt.setString(++cnt, address);
		pstmt.setString(++cnt, bloodtype);
		
		pstmt.executeUpdate();
		
%>
		{"result":"success"}
<%
	}catch(Exception e){
%>
		{"result":"failure"}
<%
		e.printStackTrace();
	}finally{
		//자원 정리
		if(pstmt!=null) try{pstmt.close();} catch(SQLException e){}
		if(conn!=null) try{conn.close();} catch(SQLException e){}
		
	}
%>