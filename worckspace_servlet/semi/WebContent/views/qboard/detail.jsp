<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<title>문의글 자세히 보기</title>
    <!-- Bootstrap core CSS -->
    <link href="../css/bootstrap/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom fonts for this template -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">
    <!-- Custom styles for this template -->
    <link href="../css/bootstrap/css/business-casual.css" rel="stylesheet">
    <link href="../css/style.css" rel="stylesheet">
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
            <li class="nav-item active px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="index.html">Home
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="/semi/qboard/qlist.do">List</a>
            </li>
            <li class="nav-item px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="blog.html">MyPage</a>
            </li>
            <li class="nav-item px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="contact.html">Service</a>
            </li>
            <li class="nav-item px-lg-4">
            	
            </li>
          </ul>
        </div>
      </div>
    </nav>
       
       <div align="center">
            <h2 class="text-heading">문의글 자세히 보기</h2>
       </div>
    <div align="center">
      <ul>
        <li>글번호 : ${qboard.q_num}</li>
        <li>글 제목 : ${qboard.q_title}</li>
        <li>작성자 : ${qboard.q_id}</li>
        <li>해결여부 : ${qboard.q_solve}</li>
      </ul>
      <p>
         ${qboard.q_content}
      </p><br>
        <div align="center">등록날짜 : ${qboard.regdate}</div>
         
      <div>
          
       <input type="button" value="수정" onclick="location.href='qupdateForm.do?q_num=${qboard.q_num}'">
       <input type="button" value="삭제" onclick="location.href='qdeleteForm.do?q_num=${qboard.q_num}'">
      </div>  
     </div>  
     <div class="text-center mt-4">
         <input type="button" value="문의 하기" onclick="location.href='qwriteForm.do'">
         <input type="button" value="메인페이지 가기" onclick="location.href='../main/main.do'">
     </div>
    
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