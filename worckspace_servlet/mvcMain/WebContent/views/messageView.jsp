<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>view</title>
</head>
<body>
결과(표현식) : <%=request.getAttribute("result") %> <br>
결과(EL) : ${result} 
</body>
</html>