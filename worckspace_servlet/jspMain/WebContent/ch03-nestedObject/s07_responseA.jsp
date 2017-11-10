<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>response.sendRedircet() 테스트</title>
</head>
<body>
현재 페이지는 s07_responsA.jsp 입니다.
화면에 보여지지 않습니다.

</body>
</html>
<%
	//s08_responseB.jsp를 호출
	response.sendRedirect("s08_responseB.jsp");
%>