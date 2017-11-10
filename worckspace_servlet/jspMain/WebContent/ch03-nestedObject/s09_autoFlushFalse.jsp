<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page buffer="1kb" autoFlush="false" %>    
<%-- buffer : 출력버퍼의 크기를 지정, default= 8kb
	 autoFlush : autoFlush 사용 유무 지정, default= true
--%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>autoFlush 속성값이 False일 때</title>
</head>
<body>
<%-- JSP Buffer overflow 에러 발생 --%>
<%
	for(int i=0;i<1000;i++){
%>
		1234
<%
	}
%>
</body>
</html>