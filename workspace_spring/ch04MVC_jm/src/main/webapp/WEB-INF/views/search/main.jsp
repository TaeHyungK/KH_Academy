<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta  content="UTF-8">
<title>게임 검색 메인</title>
</head>
<body>
<form action="game.do" method="get">
	<select name="type">
		<c:forEach var="searchType" items="${searchTypeList}">
			<option value="${searchType.code}">${searchType.text}</option>
		</c:forEach>
	</select>
	<input type="text" name="query">
	<input type="submit" value="검색">
</form>
</body>
</html>