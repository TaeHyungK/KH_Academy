<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<%
	//클라이언트가 전송한 쿠키 정보 읽기
	Cookie[] cookies = request.getCookies();
	if(cookies!=null && cookies.length > 0 ){
		for(int i=0; i<cookies.length;i++){
			//쿠키명이 name인 쿠키만 검색
			if(cookies[i].getName().equals("name")){
				//쿠키명이 name과 동일한 이름의 쿠키를 생성
				Cookie cookie = new Cookie("name", URLEncoder.encode("JSP프로그래밍","UTF-8"));
				//쿠키의 유효기간을 지정  (여기선 30분)
				cookie.setMaxAge(30*60);
				
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
<title>쿠키 수정</title>
</head>
<body>
name 쿠키의 값을 변경합니다.
</body>
</html>