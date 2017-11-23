<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>out 태그</title>
</head>
<body>
<%
	String str = "<h1>목요일 오후</h1>";
%>

<%-- escapXml 속성이 true이면 html 불인정 false이면 html 인정 default값은 true--%>
<c:out value="<%= str %>" escapeXml="true"/>
<br>
<c:out value="<%= str %>" escapeXml="fasle"/>
</body>
</html>