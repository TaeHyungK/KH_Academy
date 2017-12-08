<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="../js/member.js"></script>
</head>
<body>
<div class="page-main-style">
	<h2>비밀번호 변경</h2>
	<form action="modifyPassword.do" method="post"
	      id="password_form">
		<ul>
			<li>
				<label for="passwd">비밀번호</label>
				<input type="password" 
				   name="passwd"
				   id="passwd" maxlength="12">
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="전송">
			<input type="button" value="홈으로"
			       onclick="location.href='../main/main.do'">
		</div>
	</form>
</div>
</body>
</html>