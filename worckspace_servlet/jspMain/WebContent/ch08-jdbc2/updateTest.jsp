<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException" %>
<%@ include file="dbInfo.jspf" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보 수정</title>
<link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");

	String id= request.getParameter("id");
	String name = request.getParameter("name");
	System.out.println(name);
	int price = Integer.parseInt(request.getParameter("price"));
	System.out.println(price);
	int stock = Integer.parseInt(request.getParameter("stock"));
	String place = request.getParameter("place");
	
	System.out.println(id);
	System.out.println(name);
	System.out.println(price);
	System.out.println(stock);
	System.out.println(place);
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	String sql = null;
	
	try{
		Class.forName(driverName);
		
		conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
		
		sql = "UPDATE product SET name=?, price=?, stock=?, place=? WHERE id=?";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setInt(2, price);
		pstmt.setInt(3, stock);
		pstmt.setString(4, place);
		pstmt.setString(5, id);
		
		pstmt.executeUpdate();
%>
		<div class="result-display">
			상품 정보 수정 완료!<br>
			<input type="button" value="목록" onclick="location.href='listTest.jsp'">
		</div>
<%
	}catch(Exception e){
%>
		<div class="result=display">
			오류 발생! 상품 정보 수정 실패!<br>
			<input type="button" value="상품 정보 수정 폼" onclick="location.href='updateForm.jsp?id=<%=id %>'">
		</div>
<%
		e.printStackTrace();
	}finally{
		if(pstmt!=null) try{pstmt.close();} catch(Exception e){}
		if(conn!=null) try{conn.close();} catch(Exception e){}
	}
	
%>
</body>
</html>