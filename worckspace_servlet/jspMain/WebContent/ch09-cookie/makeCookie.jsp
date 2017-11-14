<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<%
	//쿠키 생성(쿠키명, 쿠키값)				한글의 경우 깨지기때문에 URLEncoder를 통해 인코딩
	Cookie cookie = new Cookie("name", URLEncoder.encode("홍길동", "UTF-8"));
	//쿠키 유효시간 지정(단위:초)
	//쿠키 유효시간을 지정하면 클라이언트 영역에 파일을 생성해서 쿠키 정보 보관
	//쿠키 유효시간 미지정시 메모리에 쿠키 정보 보관
	cookie.setMaxAge(30*60);
	//cookie.setMaxAge(-1); //메모리에 쿠키 정보 보관, 브라우저가 닫힐때 쿠키가 함께 삭제됨
	
	//생성된 쿠키를 클라이언트에 전송
	response.addCookie(cookie);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 생성</title>
</head>
<body>
<%= cookie.getName() %> 쿠키의 값 = <%= cookie.getValue() %>
</body>
</html>