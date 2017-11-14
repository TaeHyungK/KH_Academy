<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<%
	Cookie cookie1 = new Cookie("path1", URLEncoder.encode("경로:/jspMain/ch09-cookie/path1","UTF-8"));
	//쿠키 생성 경로 지정
	cookie1.setPath("/jspMain/ch09-cookie/path1");
	//생성한 쿠키를 클라이언트에 전송
	response.addCookie(cookie1);
	
	Cookie cookie2 = new Cookie("path2", URLEncoder.encode("경로:/jspMain/ch09-cookie/path2", "UTF-8"));
	//쿠키 생성 경로 지정
	cookie2.setPath("/jspMain/ch09-cookie/path2");
	//생성한 쿠키를 클라이언트에 전송
	response.addCookie(cookie2);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 경로 지정</title>
</head>
<body>
다음과 같이 쿠키를 생성했습니다<br>
<%= cookie1.getName() %> = <%= cookie1.getValue() %><br>
[<%= cookie1.getPath() %>]<br>

<%= cookie2.getName() %> = <%= cookie2.getValue() %><br>
[<%= cookie2.getPath() %>]<br>

</body>
</html>