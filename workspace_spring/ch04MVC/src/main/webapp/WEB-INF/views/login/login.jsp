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
<form:form>
	아이디 : <form:input/>
	<br>
	비밀번호 : <form:password/>
	<br>
	<input type="submit" value="전송">
</form:form>
</body>
</html>