<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//세션에 저장되어 있는 모든 속성을 제거
	//로그아웃 용도로 사용함
	//session.invalidate();
	
	//세션에 저장되어 있는 user_id라는 이름의 속성 값을 null로 바꿔줌
	session.setAttribute("user_id", null);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃</title>
</head>
<body>
로그아웃 했습니다.
</body>
</html>