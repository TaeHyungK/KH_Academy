<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ include file="dbInfo.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보 등록</title>
<link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	
	String id= request.getParameter("id");
	String name = request.getParameter("name");
	int price = Integer.parseInt(request.getParameter("price"));
	int stock = Integer.parseInt(request.getParameter("stock"));
	String place = request.getParameter("place");
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	String sql = null;
	
	try{
		Class.forName(driverName);
		
		conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
		
		sql = "INSERT INTO product(id,name,price,stock,place,reg_date) VALUES(?,?,?,?,?,sysdate)";
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, id);
		pstmt.setString(2, name);
		pstmt.setInt(3, price);
		pstmt.setInt(4, stock);
		pstmt.setString(5, place);
		
		pstmt.executeUpdate();
%>
	<div class="result-display">
		상품 등록 성공!<br>
		<input type="button" value="목록보기" onclick="location.href='listTest.jsp'">
	</div>
<%
	}catch(Exception e){
%>
		<div class="result-display">
			오류 발생! 상품 등록 실패!<br>
			<input type="button" value="상품 등록으로.." onclick="location.href='insertForm.jsp'">
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