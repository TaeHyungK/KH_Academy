<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String id= request.getParameter("id");
	String password= request.getParameter("password");
	
	//테스트용으로 id와 비밀번호가 서로 일치하면 로그인 처리
	if(id.equals(password)){ //로그인 성공
		session.setAttribute("user_id", id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공</title>
</head>
<body>
로그인 성공!!
</body>
</html>
<%
	}else{ //로그인 실패
%>
	<script>
		alert('로그인에 실패했습니다.');
		history.go(-1); //전 페이지로 돌아가게 함
	</script>
<%
	}
%>
