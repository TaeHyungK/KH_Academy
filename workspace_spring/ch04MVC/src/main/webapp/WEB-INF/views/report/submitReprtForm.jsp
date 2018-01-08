<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form commandName="report">
	<form:errors element="div"/>
	<p>
		<label for="subject">제목</label>
		<form:input path="subject"/>
		<form:errors path="subject"/>
	</p>
	<p>
		<label for="reportFile">리포트 파일</label>
		<input type="file" id="reportFile" name="reportFile">
		<form:errors path="reportFile"/>
	</p>
	<p>
		<input type="submit" value="리포트 전송">
	</p>
	
</form:form>
</body>
</html>