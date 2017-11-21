<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="my.member.dao.MemberDao" %>
<%
   request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="member" class="my.member.domain.MemberDto"/>
<jsp:setProperty property="*" name="member"/>
<%
   MemberDao dao = MemberDao.getInstance();
   dao.insertMember(member);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="../css/style.css" type="text/css">
</head>
<body>
<div class="page-main-style">
   <h1>회원가입 완료</h1>
   <div class="result-display">
      회원가입 성공<br>
      <button onclick="location.href='main.jsp'">홈으로</button>
   </div>
</div>
</body>
</html>