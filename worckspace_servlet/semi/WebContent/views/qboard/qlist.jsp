<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>QnA</title>
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
    </div>
    <div class="container">
      <div class="bg-faded p-4 my-4 style">
       <form id="search_form" action="qlist.do" method="get" align="center">
          <ul class="ul_form">
             <li class="li_form">  문의글 찾기  </li>
             <li class="li_form">
                 <select name="keyfield">
                    <option value="title">제목</option>
                    <option value="id">아이디</option>
                    <option value="content">내용</option>
                 </select>
             </li>
             <li class="li_form">
                <input type="search" size="16"name="keyword" id="keyword">
             </li>
             <li class="li_form">
                <input type="submit" value="찾기">
             </li>
          </ul>
      </form> 
     </div>
        <div class="text-center mt-4" >
         <c:if test="${count==0}">
           <div>
               등록된 문의 글이 없습니다.
           </div>
         </c:if>
        </div>
       <c:if test="${count>0}">
       <div class="bg-faded p-4 my-4 style">
        <div class="text-center mt-4" >
         <table id="qboard_table" width="70%" align="center" >
              <tr bgcolor="#bac9e2">
                <th>글번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>답변여부</th>
              </tr>
           <c:forEach var="qboard" items="${list }">
            <tr> 
             <td>${qboard.q_num}</td>
             <td><a href="qdetail.do?q_num=${qboard.q_num}">${qboard.q_title}</a></td>
             <td>${qboard.q_id}</td>
             <td>${qboard.q_solve}</td>
            </tr>
           </c:forEach>
         </table>
        </div>
       </div>    
         <div class="text-center mt-4">
          ${pagingHtml}
         </div>
       </c:if>
     <div class="text-center mt-4">
         <input type="button" value="문의 하기" onclick="location.href='qwriteForm.do'">
         <input type="button" value="메인페이지 가기" onclick="location.href='../main/main.do'">
     </div>
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