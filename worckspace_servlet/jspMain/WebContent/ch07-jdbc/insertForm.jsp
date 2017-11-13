<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원등록</title>
<link rel="stylesheet" href=style.css type="text/css">
<script type="text/javascript">
	window.onload=function(){
		var myForm = document.getElementById('myForm');
		//submit 이벤트 연결
		myForm.onsubmit=function(){
			var id = document.getElementById('id');
			var passwd = document.getElementById('passwd');
			var name = document.getElementById('name');
			
			if(id.value==''){
				alert('아이디를 입력하세요.');
				id.focus();
				return false;
			}else if(passwd.value==''){
				alert('패스워드를 입력하세요.');
				passwd.focus();
				return false;
			}else if(name.value==''){
				alert('이름을 입력하세요.');
				name.focus();
				return false;
			}
			
		};
	};
</script>
</head>
<body>
	<div class="page-main-style">
		<h2>회원 등록</h2>
		<form id="myForm" action="insertTest.jsp" method="post">
			<ul>
				<li>
					<label for="id">아이디</label>
					<input type="text" name="id" id="id" size="20" maxlength="10">
				</li>
				<li>
					<label for="passwd">비밀번호</label>
					<input type="password" name="passwd" id="passwd" size="20" maxlength="10">
				</li>
				<li>
					<label for="name">이름</label>
					<input type="text" name="name" id="name" size="20" maxlength="10">
				</li>
			</ul>
			<div class="align-center">
				<input type="submit" value="보내기">
				<input type="button" value="목록" onclick="location.href='selectTest.jsp'">
			</div>
		</form>
	</div>
</body>
</html>	