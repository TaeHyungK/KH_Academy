<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
<link rel="stylesheet" href="../css/style.css" type="text/css">
<script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="../js/member.js"></script>
</head>
<body>
<div class="page-main-style">
	<h2>회원 탈퇴</h2>
	<form action="deleteUser.do" method="post" id="delete_form">
		<ul>
			<li>
				<label>아이디</label>
				${user_id}
			</li>
			<li>
				<label for="passwd">비밀번호</label>
				<input type="password" name="passwd" id="passwd" maxlength="12">
			</li>
			<li>
				<label for="cpasswd">비밀번호확인</label>
				<input type="password" name="cpasswd" id="cpasswd" maxlength="12">
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="회원탈퇴">
			<input type="button" value="홈으로" onclick="location.href='../main/main.do'">
		</div>
	</form>
</div>
</body>
</html>