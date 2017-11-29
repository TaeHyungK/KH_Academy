<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리 main</title>
<link rel="stylesheet" href="../css/style.css" type="text/css">
</head>
<body>

     <%
        String user_id = (String)session.getAttribute("user_id");
     %>
    <div class="page-main-style">
         <h1>회원 관리 폼</h1>
         <div class="align-right">
         <%
         if(user_id ==null){//로그인 되지않음
        	 %>
        	 <a href="registerUserForm.jsp">회원가입</a>
        	 <a href="loginForm.jsp">로그인</a>
        	 <%
         }else{//로그인 됨
         %>
           <a href="modifyUserForm.jsp">회원정보 수정</a>
           <a href="deleteUserForm.jsp">회원탈퇴</a>
           [<b><%= user_id %></b>님이 로그인 중]
           <a href="logout.jsp">로그아웃</a>
           <%
        } 
     %>    
         </div>
    </div>

</body>
</html>