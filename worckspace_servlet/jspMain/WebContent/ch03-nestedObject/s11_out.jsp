<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>버퍼 정보</title>
</head>
<body>
버퍼의 크기 : <%= out.getBufferSize() %><br>
남은 크기 : <%= out.getRemaining() %><br>
autoFlush 여부 : <%= out.isAutoFlush() %>
</body>
</html>