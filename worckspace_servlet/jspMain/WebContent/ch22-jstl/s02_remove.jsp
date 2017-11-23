<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>remove 태그</title>
</head>
<body>
<%
	String str = "종로";
%>
<c:set var="str" value="<%=str %>"/>
${str } <br>
---------------------------<br>
page 영역에 저장된 속성 제거<br>
<c:remove var="str"/>
${str }<br>
</body>
</html>