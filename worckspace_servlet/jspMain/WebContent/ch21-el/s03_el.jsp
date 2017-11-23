<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	pageContext.setAttribute("msg", "봄");
	request.setAttribute("msg2", "여름");
	session.setAttribute("msg3", "가을");
	application.setAttribute("msg4", "겨울");
	
	String str = "부산여행";
%>
page scope(영역): ${pageScope.msg} <br>
request scope(영역) : ${requestScope.msg2} <br>
session scope(영역) : ${sessionScope.msg3} <br>
application scope(영역) : ${applicationScope.msg4} <br>
--------------------------------------------<br>
page scope(영역): ${msg} <br>
request scope(영역) : ${msg2} <br>
session scope(영역) : ${msg3} <br>
application scope(영역) : ${msg4} <br>
--------------------------------------------<br>
스크립트의 표현식 : <%=str %> <br>
EL : ${str} <br>
</body>
</html>