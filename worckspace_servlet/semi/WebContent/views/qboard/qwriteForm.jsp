<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<title>질문 작성하기</title>
<!-- Bootstrap core CSS -->
    <link href="../css/bootstrap/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom fonts for this template -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">
    <!-- Custom styles for this template -->
    <link href="../css/bootstrap/css/business-casual.css" rel="stylesheet">
    <link href="../css/bootstrap/vendor/bootstrap/css/bootstrap.css" rel="stylesheet">
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
            <li class="nav-item px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="../index.jsp">Home
                <span class="sr-only">(current)</span> 
              </a>
            </li>
            <li class="nav-item px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="../main/about.do">List</a>
            </li>
            <li class="nav-item px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="../mypage_user/detail.do">MyPage</a>
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
    </div> 
    <div align="center" class="one">
        <h2 id="text-h2">문의글 작성</h2>
        <form id="qboard_form" action="qwrite.do" method="post">
          <input type="hidden" name="q_num" id="q_num">
          <ul>
             <li>
                <label for="title">제목</label>
                <input type="text" name="title" id="title" maxlength="50">
             </li>
             <li>
                <label for="name">작성자</label>
                <input type="text" name="name" id="name" maxlength="20">
             </li>
             <li>
                <label for="content">내용</label><br>
                <textarea rows="6" cols="40" style="resize:none;" name="content" id="content"></textarea>
             </li>
          </ul>
          <input type="hidden" name="solve" id="solve" value="0">
          <div class="">
             <input type="submit" value="등록">
             <input type="button" value="목록" onclick="location.href='../qboard/qlist.do'">
          </div>
        </form>
    
    
    
    </div>
    <br><br><br>
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