<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 4개의 영역(데이터 공유할 수 있는 범위)</title>
</head>
<body>
------------s13_scopeA에서 저장함-----------<br>
page영역에 저장된 데이터 : <%= pageContext.getAttribute("msg1") %><br>
request영역에 저장된 데이터 : <%= request.getAttribute("msg2") %><br>
session영역에 저장된 데이터 : <%= session.getAttribute("msg3") %>
</body>
</html>