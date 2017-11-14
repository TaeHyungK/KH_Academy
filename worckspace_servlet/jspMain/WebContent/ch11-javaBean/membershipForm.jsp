<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 입력 폼</title>
</head>
<body>
	<form action="processJoining.jsp" method="post">
		<fieldset>
			<legend>회원가입 폼</legend>
			<ul>
				<li><label for="id">아이디 : </label> 
					<input type="text" name="id" id="id" placeholder="아이디">
				</li>
				<li><label for="password">비밀번호 : </label> 
					<input type="password" name="password" id="password" placeholder="비밀번호">
				</li>
				<li><label for="name">이름 : </label> 
					<input type="text" name="name" id="name" placeholder="이름">
				</li>
				<li><label for="email">이메일 : </label> 
					<input type="email" name="email" id="email" placeholder="test@example.com">
				</li>
				<li><label for="url">URL : </label> 
					<input type="url" name="url" id="url" placeholder="http://www.example.com">
				</li>
				<li><label for="age">나이 : </label> 
					<input type="number" name="age" id="age" min="0" max="100">
				</li>
				<li><label for="job">직업 : </label> 
					<input type="text" name="job" list="job">
					<datalist id="job">
						<option value="학생">student</option>
						<option value="의사">doctor</option>
						<option value="변호사">lawyer</option>
						<option value="프로그래머">programmer</option>
					</datalist>
				</li>
			</ul>
		</fieldset>
		<input type="submit" value="회원가입">
	</form>
</body>
</html>