<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.ResultSet"%>
<%@ include file="dbInfo.jspf"%>
[<%
	String pageNum = request.getParameter("pageNum");
	String rowCount = request.getParameter("rowCount");
	
	if(pageNum == null) pageNum = "1";
	if(rowCount == null) rowCount = "12";
	
	int currentPage = Integer.parseInt(pageNum);
	int pageSize = Integer.parseInt(rowCount);
	
	int startRow = (currentPage-1)*pageSize +1;
	int endRow = currentPage*pageSize;
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	
	try{
		Class.forName(driverName);
		conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
		
		sql = "SELECT * FROM (SELECT a.*, rownum rnum FROM (SELECT * FROM item ORDER BY code DESC) a) WHERE rnum>=? and rnum<=?";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, startRow);
		pstmt.setInt(2, endRow);
		
		rs = pstmt.executeQuery();
		while(rs.next()){
			int code = rs.getInt("code");
			String name = rs.getString("name");
			int quantity = rs.getInt("quantity");
			int price = rs.getInt("price");
			
			if(rs.getRow()>1){
				out.print(",");
			}
%>
			{
				"code":<%=code%>,
				"name":"<%=name %>",
				"quantity":<%=quantity %>,
				"price":<%=price %>
			}
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
%>]
