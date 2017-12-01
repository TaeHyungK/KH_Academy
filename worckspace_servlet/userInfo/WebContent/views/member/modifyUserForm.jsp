<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<link rel="stylesheet" href="../css/style.css" type="text/css">
<script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="../js/member.js"></script>
</head>
<body>

   <div class="page-main-style">
      <h2>회원 정보 수정</h2>
       <form action="modifyUser.do" method="post" id="modify_form">
           <ul>
              <li>
                  <label for="id">아이디</label>
                  <input type="hidden" name="id" id="id" size="5" maxLength="12" value="${member.id}">${member.id}
              </li>
              <li>
                 <label for="name">이름</label>
                 <input type="text" name="name" id="name" maxlength="10" value="${member.name}">
              </li>
               <li>
                 <label for="passwd">비밀번호</label>
                 <input type="password" name="passwd" id="passwd" maxlength="12">
              </li>
               <li>
                 <label for="phone">전화번호</label>
                 <input type="text" name="phone" id="phone" maxlength="15" value="${member.phone}">
              </li>
              <li>
                 <label for="email">이메일</label>
                 <input type="email" name="email" id="email" maxlength="50" value="${member.email}">
              </li>
              <li>
                 <label for="zipcode">우편번호</label>
                 <input type="text" name="zipcode" id="zipcode" maxlength="5" value="${member.zipcode}">
              </li>
              <li>
                 <label for="address1">주소</label>
                 <input type="text" name="address1" id="address1" maxlength="30" value="${member.address1}">
              </li>
              <li>
                 <label for="address2">나머지 주소</label>
                 <input type="text" name="address2" id="address2" maxlength="30" value="${member.address2}">
              </li>
           </ul>
           <div class="align-center">
               <input type="submit" value="수정">
               <input type="button" value="홈으로" onclick="location.href='../main/main.do'">
           </div>
       </form>
   </div>
</body>
</html>