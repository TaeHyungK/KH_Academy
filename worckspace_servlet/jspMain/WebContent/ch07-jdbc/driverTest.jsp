<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>드라이버 연동 테스트</title>
</head>
<body>
<%

	String driverName = "oracle.jdbc.OracleDriver";

	try{
		Class.forName(driverName);
%>
정상적으로 드라이버 로드
<%
		System.out.println("정상적으로 로드");
	}catch(Exception e){
		e.printStackTrace();
	}
%>

</body>
</html>