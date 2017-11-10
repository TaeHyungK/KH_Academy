<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%-- 
데이터 공유 범위
pageContext 영역 < request 영역 < session 영역
 --%>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 4개의 영역(데이터 공유할 수 있는 범위)</title>
</head>
<body>
<%
						//	  속성명	 속성값
	pageContext.setAttribute("msg1", "봄");
	request.setAttribute("msg2", "여름");
	session.setAttribute("msg3", "가을");
%>

page 영역에 저장된 데이터 : <%=pageContext.getAttribute("msg1") %><br>
request 영역에 저장된 데이터 : <%=request.getAttribute("msg2") %><br>
session 영역에 저장된 데이터 : <%=session.getAttribute("msg3") %>
</body>
</html>