<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<link rel="stylesheet" href="../css/style.css" type="text/css">
<script type="text/javascript">
	window.onload=function(){
		var myForm = document.getElementById('myForm');
		//submit 이벤트 연결
		myForm.onsubmit=function(){
			var name = document.getElementById('name');
			if(name.value==''){
				alert('이름을 입력하세요');
				name.focus();
				return false;
			}
			var passwd = document.getElementById('passwd');
			if(passwd.value==''){
				alert('비밀번호를 입력하세요');
				passwd.focus();
				return false;
			}
			var email = document.getElementById('email');
			if(email.value==''){
				alert('이메일을 입력하세요');
				email.focus();
				return false;
			}
			var content = document.getElementById('content');
			if(content.value==''){
				alert('내용을 입력하세요');
				content.focus();
				return false;
			}
		};
	};
</script>
</head>
<body>
	<div class="page-main-style">
		<h1>방명록에 글쓰기</h1>
		<form id="myForm" action="write.jsp" method="post">
			<ul>
				<li>
					<label for="name">이름</label>
					<input type="text" name="name" id="name" size="10" maxlength="10">
				</li>
				<li>
					<label for="passwd">비밀번호</label>
					<input type="password" name="passwd" id="passwd" size="10" maxlength="10">
				</li>
				<li>
					<label for="email">이메일</label>
					<input type="email" name="email" id="email" size="20" maxlength="50">
				</li>
				<li>
					<label for="content">내용</label>
					<textarea rows="5" cols="40" name="content" id="content"></textarea>
				</li>
			</ul>
			<div class="align-center">
				<input type="submit" value="글쓰기">
				<input type="button" value="목록" onclick="location.href='list.jsp'">
			</div>
		</form>
	</div>
</body>
</html>