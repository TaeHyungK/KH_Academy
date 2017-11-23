<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//전송된 데이터에 대한 인코딩 처리
request.setCharacterEncoding("UTF-8");
//전송된 데이터 반환
int num = Integer.parseInt(request.getParameter("num"));
String user_id = (String)session.getAttribute("user_id");
if(user_id==null){//로그인이 되지 않은 경우
   response.sendRedirect("productLoginForm.jsp");
}else{
%>    
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<title>상품 삭제</title>
<link rel="stylesheet" href="../css/style.css" type="text/css">
<script type="text/javascript">

window.onload=function(){
   var form=document.getElementById('delete_product');
   form.onsubmit=function(){
      var passwd = document.getElementById('passwd');
      
      if(passwd.value==''){
         alert('비밀번호를 입력하세요');
         passwd.focus();
         return false;
      }   
      var cpasswd = document.getElementById('cpasswd');
      if(cpasswd.value==''){
         alert('비밀번호 확인을 입력하세요');
         cpasswd.focus();
         return false;
      }   
      //비빌번호와 비밀번호 확인 일치여부 체크
      if(passwd.value != cpasswd.value){
         alert('비밀번호와 비밀번호 확인이 불일치합니다.');
         cpasswd.value='';
         cpasswd.focus();//데이터 초기화
         return false;
      }
   };
};
</script>
</head>
<body>

<div class="page-main-style">
   <h2>상품 정보 삭제</h2>
   <p class="align-center">
      <span>정말 삭제하시겠습니까?</span>
   </p>
   <form action="productDelete.jsp" method="post" id="delete_product">
        <input type="hidden" name="num" value="<%=num %>">
      <div class="align-center">
      <ul>
         <li>
            <label for="passwd">비밀번호</label>
            <input type="password" name="passwd" id="passwd" maxlength="12">
         </li>
         <li>
            <label for="cpasswd">비밀번호 확인</label>
            <input type="password" name="cpasswd" id="cpasswd" maxlength="12">
         </li>
      </ul>
         <input type="submit" value="삭제" >
         <input type="button" value="목록보기"
                onclick="location.href='list.jsp'">
      </div>
   </form>
</div>
</body>
</html>
<%
   }
%>