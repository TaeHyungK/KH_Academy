<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${check}">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
<link rel="stylesheet" href="../css/style.css" type="text/css">
</head>
<body>
<div class="page-main-style">
	<h2>회원 탈퇴 완료</h2>
	<div class="result-display">
		회원 탈퇴가 완료되었습니다.
		<a href="../main/main.do">홈으로</a>
	</div>
</div>
</body>
</html>
</c:if>
<c:if test="${!check}">
	<script>
		alert('비밀번호 불일치!');
		history.go(-1);
	</script>
</c:if>