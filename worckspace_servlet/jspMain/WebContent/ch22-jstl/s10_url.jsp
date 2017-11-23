<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>url 태그</title>
</head>
<body>
<c:url value="s01_set.jsp"/><br>
<c:url value="/ch22-jstl/s01_set.jsp"/><br>
<c:url value="./ch22-jstl/s01_set.jsp"/><br>
</body>
</html>