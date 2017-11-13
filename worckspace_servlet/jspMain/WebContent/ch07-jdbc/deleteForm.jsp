<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 삭제</title>
<link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
<%
	String id= request.getParameter("id");
	
%>
	<div class="page-main-style">
		<h2>회원 정보 삭제</h2>
		<p class="align-center">
			<span>정말 삭제하시겠습니까?</span>
		</p>
		<form action="deleteTest.jsp" method="post">
			<input type="hidden" name="id" value="<%=id%>">
			<div class="align-center">
				<input type="submit" value="삭제">
				<input type="button" value="목록보기" onclick="location.href='selectTest.jsp'">
			</div>
		</form>
	</div>

</body>
</html>