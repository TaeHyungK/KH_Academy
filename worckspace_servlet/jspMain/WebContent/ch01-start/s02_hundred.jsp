<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1부터 100까지의 합</title>
</head>
<body>
1부터 100까지의 합<br>
<%
	int total = 0;
	for(int i=1;i<=100;i++){
		total += i;
	}
	//내장 객체를 이용한 출력
	out.println(total);
%>
</body>
</html>