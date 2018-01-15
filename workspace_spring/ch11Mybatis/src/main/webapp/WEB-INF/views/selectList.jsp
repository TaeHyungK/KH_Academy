<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" type="text/css">
</head>
<body>
<div class="page-main-style">
	<h2>회원목록</h2>
	<div class="align-right">
		<input type="button" value="등록"
		       onclick="location.href='insert.do'">
	</div>
	<c:if test="${count == 0}">
	<div class="align-center">출력할 리스트가 없습니다.</div>
	</c:if>
	<c:if test="${count > 0}">
	<table>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>가입일자</th>
		</tr>
		<c:forEach var="member" items="${list}">
		<tr>
			<td><a href="detail.do?id=${member.id}">${member.id}</a></td>
			<td>${member.passwd}</td>
			<td>${member.name}</td>
			<td>${member.reg_date}</td>
		</tr>
		</c:forEach>
	</table>
	<div class="align-center">${pagingHtml}</div>
	</c:if>
</div>
</body>
</html>





