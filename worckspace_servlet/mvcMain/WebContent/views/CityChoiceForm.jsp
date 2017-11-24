<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/mvcMain/basicServlet2" method="post">
	이름 <input type="text" name="name"><br>
	나이 <input type="number" name="age"><br>
	여행지<input type="checkbox" name="city" value="미국">미국
	<input type="checkbox" name="city" value="일본">일본
	<input type="checkbox" name="city" value="중국">중국<br>
	<input type="submit" value="전송">
</form>
</body>
</html>