<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
<div class="page-main-style">
	<h2>회원관리</h2>
	<div class="align-right">
		<a href="../board/list.do">게시판</a>
		<c:if test="${empty user_id}">
		<a href="../member/registerUserForm.do">회원가입</a>
		<a href="../member/loginForm.do">로그인</a>
		</c:if>
		<c:if test="${!empty user_id}">
		<a href="../member/modifyUserForm.do">회원정보수정</a>
		<a href="../member/deleteUserForm.do">회원탈퇴</a>
		[${user_id}님 로그인 중]
		<a href="../member/logout.do">로그아웃</a>
		</c:if>
	</div>
</div>
</body>
</html>








