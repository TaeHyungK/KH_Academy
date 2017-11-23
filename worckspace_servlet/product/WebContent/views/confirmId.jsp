<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="my.member.dao.MemberDao" %>
<%@ page import="my.member.domain.MemberDto" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ID중복체크</title>
<link rel="stylesheet" href="../css/style.css" type="text/css">
</head>
<body>
<%
   request.setCharacterEncoding("utf-8");
   
   String id = request.getParameter("id");
   
   MemberDao dao = MemberDao.getInstance();
   MemberDto member = dao.getMember(id);
   
   if(member!=null){
%>
   <script>
      window.onload=function(){
         var myForm = document.getElementById('myForm');
         myForm.onsubmit=function(){
            var id = document.getElementById('id');
            if(id.value==''){
               alert('아이디를 입력하세요');
               id.focus();
               return false;
            }
         };
      };
   </script>
   <div class="page-popup-style">
      <%= id %>은(는) 이미 사용중인 아이디입니다.
      <br>
      다른 아이디를 선택하세요.<br>
      <form id="myForm" action="confirmId.jsp" method="post">
         <label id="id">아이디</label>
         <input type="text" name="id" id="id" size="10" maxlength="12">
         <input type="submit" value="ID중복확인">
      </form>
   </div>
<%      
   }else{
%>
   <script>
      window.onload=function(){
         var confirm_id = document.getElementById('confirm_id');
         confirm_id.onclick=function(){
            //중복되지 않은 ID 입력창에 값으로 설정
            opener.document.getElementById('id').value='<%= id %>';
            //팝업창을 닫음
            self.close();
         };
      };
   </script>
   <div class="page-popup-style">
      입력하신 <%= id %>은(는) 사용할 수 있는 ID입니다.<br>
      <div class="align-center">
         <input type="button" value="ID사용" id="confirm_id">
      </div>
   </div>
<%      
   }
%>
</body>
</html>

