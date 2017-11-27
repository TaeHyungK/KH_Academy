<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.member.Member" %>
<%@ page import = "java.util.HashMap" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- jstl jar파일 필요! --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>set 태그</title>
</head>
<body>
<%-- var : 속석명, value : 속성값, scope : 저장 영역/scope 생략시 page영역에 저장됨 --%>
<c:set var="msg" value="봄" scope="page"/>
${msg} <br>
<%
	Member member = new Member();
%>
<c:set var="member" value="<%=member %>" />
<c:set target="${member}" property="name" value="홍길동"/>
회원 이름 : ${member.name }<br>

<%
	HashMap<String, String> pref = new HashMap<String, String>();
%>
<c:set var="pref" value="<%=pref %>"/>
<c:set target="${pref}" property="color" value="red"/>
좋아하는 색 : ${pref.color}
</body>
</html>