<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 여부 검사</title>
</head>
<body>
<%
	String user_id=(String)session.getAttribute("user_id");
	if(user_id!=null){ //로그인된 경우
%>
		아이디 [<%=user_id %>]로 로그인 되어있는 상태!<br>
		<input type="button" value="로그아웃" onclick="location.href='sessionLogout.jsp'">
<%
	}else{ //로그인 안된 경우
%>
		로그인 하지 않은 상태<br>
		<input type="button" value="로그인" onclick="location.href='sessionLogin.jsp'">
<%
	}
%>
</body>
</html>