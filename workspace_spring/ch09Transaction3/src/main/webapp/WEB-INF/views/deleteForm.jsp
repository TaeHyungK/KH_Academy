<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" type="text/css">
</head>
<body>
<div class="page-main-style">
	<h1>회원탈퇴</h1>
	<form action="deletePro.do" method="post">
		<input type="hidden" name="id" value="${param.id}">
		<input type="submit" value="삭제할까요?">
		<input type="button" value="취소" 
		       onclick="location.href='list.do'">
	</form>
</div>
</body>
</html>






