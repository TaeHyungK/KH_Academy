<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리</title>
<link rel="stylesheet" href="../css/style.css" type="text/css">
</head>
<body>
    <div class="page-main-style">
        <h2>회원 관리</h2>
        <div class="align-right">
            <c:if test="${empty user_id}">
               <a href="../member/registerUserForm.do">회원 가입</a>
               <a href="../member/loginForm.do">로그인</a>
            </c:if>
            <c:if test="${!empty user_id}">
               <a href="../member/modifyUserForm.do">회원정보 수정</a>
               <a href="../member/deleteUserForm.do">회원 정보 삭제</a>
               [${user_id}님 로그인 중]
               <a href="../member/logout.do">로그아웃</a>
            </c:if>
        </div>
    </div>
</body>
</html>