<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="kr.member.dao.MemberDao" %>
    <%@ page import="kr.member.domain.MemberDto" %>
    <%
       String user_id = (String)session.getAttribute("user_id");
       if(user_id==null){//로그인이 되지 않은 경우
    	   response.sendRedirect("loginForm.jsp");
       }else{//로그인 된 경우
    
    %>
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<link rel="stylesheet" href="../css/style.css" type="text/css">
<script type="text/javascript">
    window.onload=function(){
    	
    	var form = document.getElementById('register_form');
    	//summit 이벤트 연결
    	form.onsubmit=function(){
    		
    		var name= document.getElementById('name');
    		if(name.value==''){
    			alert('이름를 입력하세요');
    			name.focus();
    			return false;
    		}
    		
    		var passwd= document.getElementById('passwd');
    		if(passwd.value==''){
    			alert('비밀번호를 입력하세요');
    			passwd.focus();
    			return false;
    	}
    		var email= document.getElementById('email');
    		if(email.value==''){
    			alert('이메일를 입력하세요');
    			email.focus();
    			return false;
    		}
    };
 };
</script>
</head>
<body>
<%
   MemberDao dao = MemberDao.getInstance();
   MemberDto member = dao.getMember(user_id);
   
   if(member.getPhone()==null){
	   member.setPhone("");
   }
%>
<div class="page-main-style">
       <h1>회원 정보 수정</h1>
       <form action="modifyUser.jsp" method="post" id="register_form">
           <ul>
               <li>
                    <label >아이디</label>
                    <%=user_id %>
               </li>
               <li>
                    <label for="id">이름</label>
                    <input type="text" name="name" value= "<%=member.getName()%>" id="name" maxlength="10" >
               </li>
               <li>
                    <label for="passwd">비밀번호</label>
                    <input type="password" name="passwd" value="<%=member.getPasswd() %>" id="passwd" maxlength="12" >
               </li>
               <li>
                    <label for="email">이메일</label>
                    <input type="email" name="email" value="<%=member.getEmail() %>" id="email" maxlength="50" >
               </li>
               <li>
                    <label for="phone">전화번호</label>
                    <input type="text" name="phone" value="<%=member.getPhone()%>" id="phone" maxlength="15" >
               </li>
           </ul>
           <div class="align-center">
                <input type="submit" value="수정">
                <input type="button" value="홈으로" onclick="location.href='main.jsp'">
           </div>
       </form>
</div>
</body>
</html>

<%
 }
 %>