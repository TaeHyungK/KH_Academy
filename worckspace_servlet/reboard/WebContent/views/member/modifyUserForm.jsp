<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="../js/member.js"></script>
</head>
<body>
<div class="page-main-style">
	<h2>회원정보수정</h2>
	<form action="modifyUser.do" method="post"
	      id="modify_form">
		<ul>
			<li>
				<label for="name">이름</label>
				<input type="text" name="name"
				   value="${member.name}"	
				   id="name" maxlength="10">
			</li>
			<li>
				<label for="phone">전화번호</label>
				<input type="text" name="phone"
				   value="${member.phone}"
				   id="phone" maxlength="15">
			</li>
			<li>
				<label for="email">이메일</label>
				<input type="email" name="email"
				   value="${member.email}"
				   id="email" maxlength="50">
			</li>
			<li>
				<label for="zipcode">우편번호</label>
				<input type="text" name="zipcode"
				   value="${member.zipcode}"
				   id="zipcode" maxlength="5">
			</li>
			<li>
				<label for="address1">주소</label>
				<input type="text" name="address1"
				   value="${member.address1}"
				   id="address1" maxlength="30">
			</li>
			<li>
				<label for="address2">나머지 주소</label>
				<input type="text" name="address2"
				   value="${member.address2}"
				   id="address2" maxlength="30">
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="수정">
			<input type="button" value="홈으로"
			       onclick="location.href='../main/main.do'">
		</div>
	</form>
</div>
</body>
</html>















