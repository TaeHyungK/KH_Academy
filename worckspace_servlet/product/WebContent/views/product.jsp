<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="my.product.dao.ProductDao" %>  
<%
   request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="product" class="my.product.domain.ProductDto"/>
<jsp:setProperty name="product" property="*"/>
<%

	ProductDao dao = ProductDao.getInstance();
	dao.productInsert(product);
%>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품등록</title>
<link rel="stylesheet" href="../css/style.css" type="text/css">
</head>
<body>
   <div class="page-main-style">
      <h1>상품 등록 완료</h1>
      <div class="result-display">
         상품 등록 성공<br>
      <button onclick="location.href='list.jsp'">목록으로</button>
      </div>
   </div>
</body>
</html>