<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html>
<html>
<head>
<meta  content="UTF-8">
<title>회원상세 정보</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" type="text/css">
</head>
<body>
<div class="page-main-style">
   <h2>회원상세 정보</h2>
   <p>
      아이디 : ${member.id}<br>
      비밀번호 : ${member.passwd}<br>
      이름 : ${member.name}<br>
      날짜 : ${member.reg_date}
   </p>
   <div class="align-center">
      <input type="button" value="수정" onclick="location.href='update.do?id=${member.id}'">
      <input type="button" value="삭제" onclick="location.href='delete.do?id=${member.id}'">
      <input type="button" value="목록" onclick="location.href='list.do'">
   </div>
</div>
</body>
</html>