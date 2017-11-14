<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//전송된 데이터에 대한 인코딩 처리
	request.setCharacterEncoding("UTF-8");
%>
<%--자바빈 객체 생성 --%>
<jsp:useBean id="member" class="com.member.MemberInfo"/>
<%--request에 저장된 데이터를 자바빈 프로퍼티에 저장 --%>
<jsp:setProperty name="member" property="*"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 완료!</title>
</head>
<body>
아이디 : <jsp:getProperty name="member" property="id"/><br>
비밀번호 : <jsp:getProperty name="member" property="password"/><br>
이름 : <jsp:getProperty name="member" property="name"/><br>
이메일 : <jsp:getProperty name="member" property="email"/><br>
URL : <jsp:getProperty name="member" property="url"/><br>
나이 : <jsp:getProperty name="member" property="age"/><br>
직업 : <jsp:getProperty name="member" property="job"/><br>
</body>
</html>