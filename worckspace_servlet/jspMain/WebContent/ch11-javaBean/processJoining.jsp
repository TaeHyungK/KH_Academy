<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.member.MemberInfo" %>
<%
	//전송된 데이터에 대한 인코딩 처리
	request.setCharacterEncoding("UTF-8");

	//자바빈 생성
	MemberInfo member = new MemberInfo();
	
	//전송된 데이터를 반환받아 자바빈에 저장
	member.setId(request.getParameter("id"));
	member.setPassword(request.getParameter("password"));
	member.setName(request.getParameter("name"));
	member.setEmail(request.getParameter("email"));
	member.setUrl(request.getParameter("url"));
	member.setAge(Integer.parseInt(request.getParameter("age")));
	member.setJob(request.getParameter("job"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 완료!</title>
</head>
<body>
아이디 : <%=member.getId() %><br>
비밀번호 : <%=member.getPassword() %><br>
이름 : <%=member.getName() %><br>
이메일 : <%=member.getEmail() %><br>
URL : <%=member.getUrl() %><br>
나이 : <%=member.getAge() %><br>
직업 : <%=member.getJob() %><br>
</body>
</html>