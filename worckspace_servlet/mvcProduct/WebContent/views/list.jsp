<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
<link rel="stylesheet" href="./css/style.css" type="text/css">
</head>
<body>
<div class="page-main-style">
	<h2>상품 목록 보기</h2>
	<div class="align-right">
		<input type="button" value="등록" onclick="location.href='registerForm.do'">
	</div>
	<table>
		<tr>
			<th>ID</th>
			<th>상품명</th>
			<th>가격</th>
			<th>재고수량</th>
			<th>원산지</th>
			<th>등록일</th>
		</tr>
		<c:forEach var="member" items="${productList}">
			<tr>
				<td><a href="detail.do?id=${member.id}">${member.id}</a></td>
				<td>${member.name}</td>
				<td>${member.price}</td>
				<td>${member.stock}</td>
				<td>${member.place}</td>
				<td>${member.reg_date}</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>