<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String color= request.getParameter("color");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forwardB.jsp</title>
</head>
<body>
forwardB.jsp 페이지 입니다.<br>
request에 파라미터로 전송된 데이터 = <%=color %>
</body>
</html>