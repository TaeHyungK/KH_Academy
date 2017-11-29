<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="kr.member.dao.MemberDao" %>    
<%
   String user_id = (String)session.getAttribute("user_id");
   if(user_id==null){
	   response.sendRedirect("loginForm.jsp");
   }else{//로그인 된 경우
      //전송된 데이터에 대한 인코딩 처리
      request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="member" class="kr.member.domain.MemberDto"/>
<jsp:setProperty name="member" property="*"/>
<%
   //아이디가 전송되지 않았기 때문에 session에 저장된 아이디를 사용
   member.setId(user_id);
   MemberDao dao = MemberDao.getInstance();
   dao.updateMember(member); 	   

%>
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정 완료</title>
<link rel="stylesheet" href="../css/style.css" type="text/css">
</head>
<body>

<div class="page-main-style">
    <h1>회원정보수정 완료</h1>
    <div class="result-display">
        <button onclick="location.href='main.jsp'">홈으로</button>
    </div>
</div>
</body>
</html>
<% 
     } 
%>
