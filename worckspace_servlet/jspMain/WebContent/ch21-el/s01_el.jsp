<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>표현식</th>
			<th>값</th>
		</tr>
		<tr>
			<td>\${2 + 5}</td>
			<td>${2 + 5}</td>
		</tr>
		<tr>
			<td>\${"10" + 5}</td>
			<td>${"10" + 5}</td>
		</tr>
		<tr>
			<td>\${"10" + "5"}</td>
			<td>${"10" + "5"}</td>
		</tr>
		<tr>
			<td>\${"십" + 5}</td>
			<td>에러발생(EL에서의 +는 연산만)</td>
		</tr>
		<tr>
			<td>\${4 / 5}</td>
			<td>${4 / 5}(실수로 출력됨, 정수X!!)</td>
		</tr>
		<tr>
			<td>\${5 mod 7}</td>
			<td>${5 mod 7}(나머지 연산)</td>
		</tr>
		<tr>
			<td>\${(5>3) ? 5 : 3}</td>
			<td>${(5>3) ? 5 : 3}</td>
		</tr>
		<tr>
			<td>\${2 < 3}</td>
			<td>${2 < 3}</td>
		</tr>
	</table>
</body>
</html>