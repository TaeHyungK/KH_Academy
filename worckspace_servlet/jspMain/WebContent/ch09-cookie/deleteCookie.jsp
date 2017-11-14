<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//클라이언트가 전송한 쿠키 정보를 반환
	Cookie[] cookies = request.getCookies();
	if(cookies!=null && cookies.length > 0){
		for(int i=0;i<cookies.length;i++){
			//쿠키명이 name인 쿠키를 검색
			if(cookies[i].getName().equals("name")){
				//쿠키명이 name인 쿠키를 생성
				Cookie cookie = new Cookie("name", "");
				//쿠키 정보 제거
				cookie.setMaxAge(0);
				
				//생성한 쿠키를 클라이언트에 전송
				response.addCookie(cookie);
			}
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 삭제</title>
</head>
<body>
name 쿠키를 삭제합니다.
</body>
</html>