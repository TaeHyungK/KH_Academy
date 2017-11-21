<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="../css/style.css" type="text/css">
<script type="text/javascript">
   window.onload=function(){
      var form = document.getElementById('register_form');
      form.onsubmit=function(){
         var id = document.getElementById('id');
         if(id.value==''){
            alert('id를 입력하세요');
            id.focus();
            return false;
         }
         var name = document.getElementById('name');
         if(name.value==''){
            alert('이름를 입력하세요');
            name.focus();
            return false;
         }
         var passwd = document.getElementById('passwd');
         if(passwd.value==''){
            alert('비밀번호를 입력하세요');
            passwd.focus();
            return false;
         }
         var email = document.getElementById('email');
         if(email.value==''){
            alert('이메일을 입력하세요');
            email.focus();
            return false;
         }
         var phone = document.getElementById('phone');
         if(phone.value==''){
            alert('전화번호를 입력하세요');
            phone.focus();
            return false;
         }   
         var zipcode = document.getElementById('zipcode');
         if(zipcode.value==''){
            alert('우편번호를 입력하세요');
            zipcode.focus();
            return false;
         }
         var address = document.getElementById('address');
         if(address.value==''){
            alert('주소를 입력하세요');
            address.focus();
            return false;
         }
      };
      
      //아이디 중복 확인에 대한 이벤트 연결
      var confirm_id = document.getElementById('confirm_id');
      //click 이벤트 연결
      confirm_id.onclick=function(){
         var id = document.getElementById('id');
         if(id.value==''){
            alert('아이디를 입력하세요!');
            id.focus();
            return;
         }
         //URL과 사용자 입력 id를 조합
         var url = 'confirmId.jsp?id=' + id.value;
         
         //새로운 윈도우 열기
         open(url,'confirm','toolbar=no,location=no,status=no,scrollbars=no,resizable=no,width=400,height=200');
         
      };
      
   };
</script>
</head>
<body>
   <div class="page-main-style">
      <h1>회원가입</h1>
         <form action="registerUser.jsp" method="post" id="register_form">
            <ul>
               <li>
               		<label for="id">아이디</label> 
               		<input type="text" name="id" id="id" size="20" maxlength="12" autocomplete="off">
               </li>
               <li>
               		<label for="id">이름</label> 
               		<input type="text" name="name" id="name" size="20" maxlength="12">
               </li>
               <li>
               		<label for="id">비밀번호</label> 
               		<input type="password" name="passwd" id="passwd" size="20" maxlength="12">
               </li>
               <li>
               		<label for="email">이메일</label>
               		<input type="email" name="email" id="email" size="20" >
               </li>
               <li>
               		<label for="phone">전화번호</label> 
               		<input type="text" name="phone" id="phone" size="20" maxlength="12">
               </li>
               <li>
               		<label for="zipcode">우편번호</label>
               		<input type="text" name="zipcode" id="zipcode" size="20" maxlength="5">
               </li>
               <li>
               		<label for="address">주소</label>
               		<input type="text" name="address" id="address" size="20" >
               </li>
            </ul>
            <div class="align-center">
               <input type="submit" value="등록"> <input type="button"
                  value="홈으로" onclick="location.href='main.jsp'">
            </div>
         </form>
   </div>
</body>
</html>