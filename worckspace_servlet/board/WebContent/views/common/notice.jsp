<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>안내</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
	<div class="page-main-style">
		<h2>안내</h2>
		<div class="result-display">
			${accessMsg}
			<br>
			<input type="button" value="홈으로" onclick="location.href='../main/main.do'">
		</div>
	</div>
</body>
</html>