<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록</title>
<link rel="stylesheet" href="./css/style.css" type="text/css">
</head>
<body>
<div class="page-main-style">
	<h2>회원 목록 보기</h2>
	<div class="align-right">
		<input type="button" value="등록" onclick="location.href='insertForm.do'">
	</div>
	<table>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>비밀번호</th>
			<th>가입일</th>
		</tr>
		<c:forEach var="member" items="${memberList}">
			<tr>
				<td><a href="selectDetail.do?id=${member.id}">${member.id}</a></td>
				<td>${member.name}</td>
				<td>${member.passwd}</td>
				<td>${member.reg_date}</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>