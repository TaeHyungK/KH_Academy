<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<form:form commandName="loginCommand">
	<!-- path 지정을 하지 않은 글로벌 오류 표ㅣ -->
	<form:errors elemen="div"/><!-- element 속성을  기본적으로 span태그를 생성하는 div를 명시하면 div 태그를 생성하도록 처리-->
	<br>
	아이디 : <form:input path="userId"/>
	<form:errors path="userId"/>
	<br>
	비밀번호 : <form:password path="password"/>
	<form:errors path="password"/>
	<br>
	<input type="submit" value="전송">
</form:form>
</body>
</html>