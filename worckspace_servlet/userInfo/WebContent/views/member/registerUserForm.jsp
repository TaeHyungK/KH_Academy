<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<link rel="stylesheet" href="../css/style.css" type="text/css">
<script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="../js/member.js"></script>
</head>
<body>

   <div class="page-main-style">
      <h2>회원 가입</h2>
       <form action="registerUser.do" method="post" id="register_form">
           <ul>
              <li>
                  <label for="id">아이디</label>
                  <input type="text" name="id" id="id" size="5" maxLength="12">
                  <input type="button" value="ID 중복 체크" id="id_check">
                  <span id="message_id"></span>
                  <img src="../images/ajax-loader.gif" width="16" height="16" id="loading" style="display:none;">
              </li>
              <li>
                 <label for="name">이름</label>
                 <input type="text" name="name" id="name" maxlength="10">
              </li>
               <li>
                 <label for="passwd">비밀번호</label>
                 <input type="password" name="passwd" id="passwd" maxlength="12">
              </li>
               <li>
                 <label for="phone">전화번호</label>
                 <input type="text" name="phone" id="phone" maxlength="15">
              </li>
              <li>
                 <label for="email">이메일</label>
                 <input type="email" name="email" id="email" maxlength="50">
              </li>
              <li>
                 <label for="zipcode">우편번호</label>
                 <input type="text" name="zipcode" id="zipcode" maxlength="5">
              </li>
              <li>
                 <label for="address1">주소</label>
                 <input type="text" name="address1" id="address1" maxlength="30">
              </li>
              <li>
                 <label for="address2">나머지 주소</label>
                 <input type="text" name="address2" id="address2" maxlength="30">
              </li>
           </ul>
           <div class="align-center">
               <input type="submit" value="둥록">
               <input type="button" value="홈으로" onclick="location.href='../main/main.do'">
           </div>
       </form>
   </div>
</body>
</html>