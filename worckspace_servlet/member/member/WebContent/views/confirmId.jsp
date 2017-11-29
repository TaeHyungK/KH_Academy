<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "kr.member.dao.MemberDao" %>
<%@ page import = "kr.member.domain.MemberDto" %>
    
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<title>Id 중복 체크</title>
<link rel="stylesheet" href="../css/style.css" type="text/css">
</head>
<body>
<%
    //전송된 데이터에 대한 인코딩 처리
    request.setCharacterEncoding("utf-8");
    //전송된 데이터 반환
    String id = request.getParameter("id");
    
    MemberDao dao = MemberDao.getInstance();
    MemberDto member = dao.getMember(id);
    
    if(member!=null){//사용중인 아이디가 존재
    	%>
    	<script>
    	   window.onload=function(){
    		   var myForm = document.getElementById("myForm");
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
    	     <%=id %>는 이미 사용중인 아이디 입니다.<br>
    	     다른 아이디를 선택하세요<br>
    	     <form id="myForm" action="confirmId.jsp" method="post">
    	        <label for="id">아이디</label>
    	        <input type="text" name="id" id="id" size="10" maxlength="12">
    	        <input type="submit" value="아이디 중복확인">
    	     </form>
    	</div>
    	<%
    }else{//사용중인 아이디가 존재하지 않는 경우
           %>
           <script>
               window.onload=function(){
            	   var confirm_id = document.getElementById('confirm_id');
            	   confirm_id.onclick=function(){
            		   //중복되지 않은 아이디를 부모창 id 입력창에 값으로 설정
            		   opener.document.getElementById('id').value='<%=id%>';
            		   //popup창을 닫음
            		   self.close();
            	   };
               };
           
           </script>
           <div class="page-popup-style">
               입력하신 <%=id %>는 사용할수 있는 ID입니다.<br>
               <div class="align-center">
                   <input type="button" value="ID사용" id="confirm_id">
               </div>
           </div>
           <%
    }
%>
</body>
</html>