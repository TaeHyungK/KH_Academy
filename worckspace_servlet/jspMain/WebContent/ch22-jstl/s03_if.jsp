<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>if 태그</title>
</head>
<body>
<%--test속성 : 조건문 --%>
<c:if test="true">
무조건 실행<br>
</c:if>
	<%-- tomcat 7버전 이상은 ==대신 equals도 사용 가능, el에선 자바와 다르게 문자열을 ''로 써도 허용해줌 --%>
<c:if test="${param.name == 'kim' }">
	name 파라미터의 값이 ${param.name }입니다.<br>
</c:if>

<c:if test="${param.age >= 20 }">
	당신의 나이는 20살입니다.<br>
</c:if>
</body>
</html>