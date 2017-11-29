<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<link rel="stylesheet" href="../css/style.css" type="text/css">
<script type="text/javascript">
    window.onload=function(){
    	
    	var form = document.getElementById('register_form');
    	//summit 이벤트 연결
    	form.onsubmit=function(){
    		
    		var id= document.getElementById('id');
    		if(id.value==''){
    			alert('아이디를 입력하세요');
    			id.focus();
    			return false;
    		}
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
    
    //아이디 중복 확인에 대한 이벤트 연결
    var confirm_id = document.getElementById('confirm_id');
    //클릭 이벤트 연결
    confirm_id.onclick=function(){
    	var id = document.getElementById('id');
    	if(id.value==''){
    		alert('아이디를 입력하세요');
    		id.focus();
        	return;
    	}
    	//url과 사용자 입력 id 조합
    	var url = 'confirmId.jsp?id='+id.value;
    	//새로운 윈도우 열기
    	open(url,'confirm','toolbar=no,location=no,status=no,scrollbars=no,resizable=no,width=400,height=200');
    	
    	
    };
    
 };
</script>
</head>
<body>
<div class="page-main-style">
       <h1>회원 가입</h1>
       <form action="registerUser.jsp" method="post" id="register_form">
           <ul>
               <li>
                    <label for="id">아이디</label>
                    <input type="text" name="id" id="id" size="7" maxlength="12" autocomplete="off">
                    <input type="button" id="confirm_id" value="ID중복 확인">
               </li>
               <li>
                    <label for="name">이름</label>
                    <input type="text" name="name" id="name" maxlength="10" >
               </li>
               <li>
                    <label for="passwd">비밀번호</label>
                    <input type="password" name="passwd" id="passwd" maxlength="12" >
               </li>
               <li>
                    <label for="email">이메일</label>
                    <input type="email" name="email" id="email" maxlength="50" >
               </li>
               <li>
                    <label for="phone">전화번호</label>
                    <input type="text" name="phone" id="phone" maxlength="15" >
               </li>
           </ul>
           <div class="align-center">
                <input type="submit" value="등록">
                <input type="button" value="홈으로" onclick="location.href='main.jsp'">
           </div>
       </form>
</div>
</body>
</html>