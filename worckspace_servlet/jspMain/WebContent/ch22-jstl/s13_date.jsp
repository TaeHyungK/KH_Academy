<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>formatData 태그</title>
</head>
<body>
<c:set var="now" value="<%=new java.util.Date() %>"/>
<fmt:formatDate value="${now}" type="date" dateStyle="full"/><br>
<fmt:formatDate value="${now}" type="date" dateStyle="short"/><br>
<fmt:formatDate value="${now}" type="time" timeStyle="full"/><br>
<fmt:formatDate value="${now}" type="time" timeStyle="short"/><br>
<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/><br>
<%--원하는 패턴으로 날짜를 출력 --%>
<fmt:formatDate value="${now}" pattern="yyyy년MM월dd일 E요일 a hh:mm:ss"/>
</body>
</html>