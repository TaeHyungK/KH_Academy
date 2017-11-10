<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[실습]회원가입</title>
</head>
<body>
<!-- 
이름, ID, 비밀번호, 취미(영화감상,음악감상, 운동 - checkbox형태),
거주지(서울, 부산, 대구, 광주 - select형태),
국적(한국,미국,일본,중국 - radio형태)
 -->
	<form action="s04_register.jsp" method="post">
		이름 : <input type="text" name="name" size="10"><br>
		ID : <input type="text" name="id" size="10"><br>
		비밀번호 : <input type="password" name="password" size="10"><br>
		취미<br> 
		<input type="checkbox" name="hobby" value="영화감상">영화감상
		<input type="checkbox" name="hobby" value="음악감상">음악감상
		<input type="checkbox" name="hobby" value="운동">운동
		<br>
		거주지 : 
		<select name="addr">
			<option value="서울" selected>서울</option>
			<option value="부산">부산</option>
			<option value="대구">대구</option>
			<option value="광주">광주</option>	
		</select>
		<br>
		국적 : 
		<input type="radio" name="country" value="한국">한국
		<input type="radio" name="country" value="미국">미국
		<input type="radio" name="country" value="미국">일본
		<input type="radio" name="country" value="중국">중국
		<br>
		
		<input type="submit" value="전송">
		 
		
	</form>
</body>
</html>