<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="my.product.dao.ProductDao" %>
<%@ page import="my.product.domain.ProductDto" %>
<%@ page import="java.util.List" %>
<%
   int startRow = 1;
   int endRow = 10;
   List<ProductDto> productList = null;
   ProductDao dao = ProductDao.getInstance();
   productList = dao.getList(startRow,endRow);
 %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product 메인</title>
<style type="text/css">
	body{
		background:url(../img/main_bo0.jpg) no-repeat fixed;
		background-size:cover;
	}
	h1{
		color:YELLOW;
	}
	a:link{
		color:RED;
	}
	a:visited{
		color:HOTPINK;
	}
	
</style>
<link rel="stylesheet" href="../css/style.css" type="text/css">
</head>
<body>
<%
	String user_id = (String)session.getAttribute("user_id");
%>
<div class="page-main-style">
	<h1>홈</h1>
	<div class="align-right">
<%
	if(user_id == null){//로그인 되지 않음
%>
		<a href="registerUserForm.jsp">회원가입</a>
		<a href="productLoginForm.jsp">로그인</a>
<%		
	}else{//로그인 됨
%>
		<a href="modifyUserForm.jsp">회원정보수정</a>
		<a href="deleteUserForm.jsp">회원탈퇴</a>
		<a href="productForm.jsp">상품 작성</a>
		[<b><%= user_id %></b>님 로그인 중]
		<a href="logout.jsp">로그아웃</a>
<%		
	}
%> 	
	</div>
	<h1><a href="list.jsp">상품 목록보기</a></h1>
	
</div>
</body>
</html>