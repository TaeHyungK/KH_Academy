<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>회원 탈퇴 폼</title>
<link rel="stylesheet" href="../css/style.css" type="text/css">
<script type="text/javascript">
    window.onload=function(){
    	
    	var form = document.getElementById('delete_form');
    	//summit 이벤트 연결
    	form.onsubmit=function(){
    		
    		var passwd= document.getElementById('passwd');
    		if(passwd.value==''){
    			alert('비밀번호를 입력하세요');
    			passwd.focus();
    			return false;
    	}
    		var cpasswd= document.getElementById('cpasswd');
    		if(cpasswd.value==''){
    			alert('비밀번호 확인을 입력하세요');
    			cpasswd.focus();
    			return false;
    		}
    		//비밀번호와 비밀번화 확인 일치여부 체크
    		if(passwd.value != cpasswd.value){
    			alert('비밀번호와 비밀번호 확인이 일치하지 않습니다.')
    			cpasswd.value='';
    			cpasswd.focus();
    			return false;
    		}
    };
 };
</script>
</head>
<body>

<div class="page-main-style">
       <h1>회원탈퇴</h1>
       <form action="deleteUser.jsp" method="post" id="delete_form">
           <ul>
               <li>
                    <label >아이디</label>
                    <%=user_id %>
               </li>
               <li>
                    <label for="passwd">비밀번호</label>
                    <input type="password" name="passwd"  id="passwd" maxlength="12" >
               </li>
                <li>
                    <label for="cpasswd">비밀번호</label>
                    <input type="password" name="cpasswd"  id="cpasswd" maxlength="12" >
               </li>
           </ul>
           <div class="align-center">
                <input type="submit" value="회원 탈퇴">
                <input type="button" value="홈으로" onclick="location.href='main.jsp'">
           </div>
       </form>
</div>
</body>
</html>

<%
 }
 %>