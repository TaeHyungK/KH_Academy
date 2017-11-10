<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 확인</title>
</head>
<body>
	이름 : <%=request.getParameter("name") %> <br>
	ID : <%=request.getParameter("id") %> <br>
	비밀번호 : <%=request.getParameter("password") %> <br>
	취미 : 
	<%
		String[] hobby = request.getParameterValues("hobby");
		if(hobby!=null){
			for(int i=0;i<hobby.length;i++){
	%>
				<%=hobby[i] %>
	<%		
			}
		}
	%>
	<br>
	거주지 : <%=request.getParameter("addr") %> <br>
	국적 : <%=request.getParameter("country") %>

</body>
</html>