<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 폼</title>
<link rel="stylesheet" href="./css/style.css" type="text/css">
<script type="text/javascript">
	window.onload=function(){
		var myForm = document.getElementById('myForm');
		myForm.onsubmit=function(){
			var id = document.getElementById('id');
			if(id.value==''){
				alert('아이디를 입력해주세요.');
				id.focus();
				return false;
			}
			
			var passwd = document.getElementById('passwd');
			if(passwd.value==''){
				alert('비밀번호를 입력해주세요.');
				passwd.focus();
				return false;
			}
			
			var name = document.getElementById('name');
			if(name.value==''){
				alert('이름을 입력해주세요.');
				name.focus();
				return false;
			}
		};
	}
</script>
</head>
<body>
<div class="page-main-style">
	<h2>회원 등록</h2>
	<form id="myForm" action="insert.do" method="post">
		<ul>
			<li>
				<label for="id">아이디</label>
				<input type="text" name="id" id="id" size="20" maxlength="10">
			</li>
			<li>
				<label for="passwd">비밀번호</label>
				<input type="password" name="passwd" id="passwd" size="20">
			</li>
			<li>
				<label for="name">이름</label>
				<input type="text" name="name" id="name" size="20" maxlength="10">
			</li>
		</ul>
		<div class="align-center">
				<input type="submit" value="보내기">
				<input type="button" value="목록" onclick="location.href='select.do'">
		</div>
	</form>
</div>
</body>
</html>