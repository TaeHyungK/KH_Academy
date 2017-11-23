<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//전송된 데이터에 대한 인코딩 처리	
	request.setCharacterEncoding("UTF-8");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="s02_el.jsp" method="post">
		이름 <input type="text" name="name"><br>
		<input type="submit" value="확인">
	</form>
	이름은 <%= request.getParameter("name") %><br>
	이름은 ${param.name}
</body>
</html>