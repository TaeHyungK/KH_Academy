<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<title>문의글</title>
    <!-- Bootstrap core CSS -->
    <link href="../css/bootstrap/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom fonts for this template -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">
    <!-- Custom styles for this template -->
    <link href="../css/bootstrap/css/business-casual.css" rel="stylesheet">
    <link href="../css/bootstrap/vendor/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="../css/style.css" rel="stylesheet">
    <script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="../js/qboard.reply.js"></script>
</head>
<body>
          <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light bg-faded py-lg-4">
      <div class="container">
        <a class="navbar-brand text-uppercase text-expanded font-weight-bold d-lg-none" href="#">Start Bootstrap</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav mx-auto">
            <li class="nav-item px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="../index.jsp">Home
                <span class="sr-only">(current)</span> 
              </a>
            </li>
            <li class="nav-item px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="../main/about.do">List</a>
            </li>
            <li class="nav-item px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="../mypage_user/registerDetail.do">MyPage</a>
            </li>
            <c:if test="${user_id=='admin'}">
            	<li class="nav-item px-lg-4">
              		<a class="nav-link text-uppercase text-expanded" href="../register/registerList.do">RegisterPage</a>
            	</li>
            </c:if>
            <li class="nav-item active px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="/semi/qboard/qlist.do">Service</a>
            </li>
            <li class="nav-item px-lg-4">
            <c:if test="${user_id=='admin'}">
            	<li class="nav-item px-lg-4">
            		<a class="nav-link text-uppercase text-expanded" href="../main/admin.do">Admin</a>
            	</li>
            </c:if>
            	
            </li>
          </ul>
        </div>
      </div>
    </nav>
    
    <div align="center">
       <h1 class="text-heading">QnA</h1>
    </div><br>
       
   <div class="container">    
    <div class="bg-faded p-4 my-4 style">
      <div class="text-center mt-4">
       <div align="center">
            <h2 class="text-heading">문의글 자세히 보기</h2>
       </div>
       <table id="qboard_table" width="70%" align="center">
      <tr>
        <td>글번호 : ${qboard.q_num}</td>
        <td>글 제목 : ${qboard.q_title}</td>
      </tr>
      <tr>  
        <td>작성자 : ${qboard.q_id}</td>
        <td>해결여부 : ${qboard.q_solve}</td>
      </tr>
      <tr>
         <td colspan="2"> <p>${qboard.q_content} </p></td>
      </tr>
      <tr><td colspan="2"><div align="center">등록날짜 : ${qboard.regdate}</div></td></tr>
    </table>   
      
      <div>
       <input type="button" value="수정" onclick="location.href='qupdateForm.do?q_num=${qboard.q_num}'">
       <!-- 로그인 아이디와 작성자 아이디 체크 -->
       <input type="button" value="삭제" onclick="location.href='qdeleteForm.do?q_num=${qboard.q_num}'">
       <!-- 로그인 아이디와 작성자 아이디 체크 -->
      </div>  
     </div><br><br> 
      <!-- 댓글 처리 -->
      <!-- 관리자만 댓글 작성 가능 -->
     <div id="qreply_div" align="center">
        <h4 class="text-heading">답변</h4>
        <form id="re_qform">
            <input type="hidden" name="q_num" value="${qboard.q_num}" id="q_num">
            <input type="hidden" name="q_id" value="관리자" id="q_id">
      <c:if test="${user_id == 'admin' }">      
            <textarea rows="2" cols="60" name="re_content" id="re_content" width="70%" style="resize:none;"></textarea>
                 
                 <div class="qre-second" >
                 
     
                     <input type="submit" value="전송">
     
                 </div>
           </c:if>    
        </form>
     </div>
             <!-- 목록 출력 -->
          
        <div id="output" align="center"></div>
      
      
         <div class="text-center mt-4">
           <input type="button" value="문의 하기" onclick="location.href='qwriteForm.do'">
           <input type="button" value="QnA 목록" onclick="location.href='qlist.do'">
         </div>
      </div>
   </div>  
     <br><br>
    
     <!-- /.container -->

    <footer class="bg-faded text-center py-5">
      <div class="container">
        <p class="m-0">Copyright &copy; KH Academy 2017 A class SemiProject</p>
      </div>
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="../css/bootstrap/vendor/jquery/jquery.min.js"></script>
    <script src="../css/bootstrap/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    
</body>
</html>