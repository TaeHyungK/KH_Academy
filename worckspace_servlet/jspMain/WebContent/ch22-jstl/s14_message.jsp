<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:bundle basename="resource.message">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><fmt:message key="title"/></title>
</head>
<body>
<fmt:message key="greeting"/><br>
<c:if test="${! empty param.id}">
<fmt:message key="visitor">
	<fmt:param value="${param.id}"/>
</fmt:message>
</c:if>
</body>
</html>
</fmt:bundle>

<%--
${empty param.id} : param.id가 비어있거나 null이면 true 값이 있으면 false
 empty 연산자 
1) 값이 null이면 true 반환
2) 값이 빈 문자열(“”)이면 true 반환
3) 값이 길이가 0인 배열이면 true 반환
3) 값이 빈 Map이면 true를 반환
4) 값이 빈 Collection이면 true를 반환
5) 이외의 경우에는 false를 반환
--%>