<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="/ch05-errorPage/error/viewMessage.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파라미터 출력</title>
</head>
<body>
<!-- 에러문장 -->
파라미터 값 : <%=request.getParameter("name").toUpperCase() %>
</body>
</html>