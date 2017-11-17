<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int num= Integer.parseInt(request.getParameter("num"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 삭제</title>
<link rel="stylesheet" href="../css/style.css" type="text/css">
<script type="text/javascript">
	window.onload=function(){
		var myForm = document.getElementById('myForm');
		myForm.onsubmit=function(){
			var passwd = document.getElementById('passwd');
			
			if(passwd.value==''){
				alert('비밀번호를 입력하세요!');
				passwd.focus();
				return false;
			}
		};
	};
</script>
</head>
<body>
<div class="page-main-style">
	<h1>글삭제</h1>
	<form id="myForm" action="delete.jsp" method="post">
		<input type="hidden" name="num" value="<%=num %>">
		
		<ul>
			<li>
				<label for="passwd">비밀번호</label>
				<input type="password" name="passwd" id="passwd" size="10" maxlength="10">
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="글삭제">
			<input type="button" value="목록보기" onclick="location.href='list.jsp'">
		</div>
	</form>
</div>
</body>
</html>