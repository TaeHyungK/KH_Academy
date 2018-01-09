<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta  content="UTF-8">
<title>리포트 등록 폼</title>
</head>
<body>
<form:form commandName="fileCommand" method="post" enctype="multipart/form-data">
제목 : <form:input path="subject"/>
	 <form:errors path="subject"/><br>
리포트 파일1 : <input type="file" name="filename1">
			<form:errors path="filename1"/><br>
리포트 파일2 : <input type="file" name="filename2">
			<form:errors path="filename2"/><br>
<input type="submit" value="리포트 전송">							 
</form:form>
</body>
</html>