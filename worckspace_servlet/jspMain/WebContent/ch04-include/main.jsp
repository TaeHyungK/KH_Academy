<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- include는 공용변수(여러 JSP에서 공통적으로 사용하는 변수) --%>
<%@ include file="include.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include 디렉티브</title>
</head>
<body>
이미지 경로 : <%= img_path %><br>
파일 경로 : <%= file_path %><br>


</body>
</html>