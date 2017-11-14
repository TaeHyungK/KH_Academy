<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="#.jsp" method="post">
		<fieldset>
			<legend>납품자정보</legend>
			<ol>
				<li><label>납품자명 : </label>
					<input type="text" placeholder="name">
				</li>
				<li><label>email: </label>
					<input type="email" placeholder="test@naver.com">
				</li>
				<li><label>홈페이지: </label>
					<input type="url" placeholder="http://">
				</li>
			</ol>
		</fieldset>
		<fieldset>
			<legend>납품정보</legend>
			<ul>
				<li><label>삼품명: </label>
					<input type="text" list="name">
					<datalist id="name">
						<option value="dog1004">도그1004</option>
						<option value="catchicken">고양이치킨</option>
						<option value="milk">우유</option>
					</datalist>
				</li>
				<li><label>납품수량: </label>
					<input type="number" step="10" min="10" max="100">
				</li>
				<li><label>납품등급: </label>
					<input type="range" step="2" min="0" max="10">
				</li>
				<li><label>기타사항: </label>
					<textarea rows="2" cols="10"></textarea>
				</li>
			</ul>
		</fieldset>
		<input type="submit" value="send message">
	</form>
</body>
</html>