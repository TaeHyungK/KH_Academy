<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>SemiProject Main</title>
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
    <div class="tagline-upper text-center text-heading text-shadow text-white mt-5 d-none d-lg-block">Team Seis Air</div>
    <div class="tagline-lower text-center text-expanded text-shadow text-white mb-5 d-none d-lg-block">Jae Hoon/Seung Hun/Woo Jin/Jung Min/Tae Hyung/Jae Geun</div>
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
              <a class="nav-link text-uppercase text-expanded" href="about.do">List</a>
            </li>
            <li class="nav-item px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="../mypage_user/registerDetail.do">MyPage</a>
            </li>
            <c:if test="${user_id=='admin'}">
            	<li class="nav-item px-lg-4">
              		<a class="nav-link text-uppercase text-expanded" href="../register/registerList.do">RegisterPage</a>
            	</li>
            </c:if>
            <li class="nav-item px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="/semi/qboard/qlist.do">Service</a>
            </li>
            <li class="nav-item px-lg-4">
            <c:if test="${user_id=='admin'}">
            	<li class="nav-item active px-lg-4">
            		<a class="nav-link text-uppercase text-expanded" href="admin.do">Admin</a>
            	</li>
            </c:if>
            	
            </li>
          </ul>
        </div>
      </div>
    </nav>
      
    	<div class="container">
		<div class="bg-faded p-4 my-4 style">
		<form action="modifyAir.do" method="post" class="miForm">
			<input type="hidden" name="snum" value="${ad.snum}">
			<table>
			<tr>
				<td>출발지</td>
				<td><input class="size300" type="text" id="start_lo" name="start_lo" value="${ad.start_lo}"></td>
			</tr>
			<tr>
				<td>도착지</td>
				<td><input class="size300" type="text" id="end_lo" name="end_lo" value="${ad.end_lo}"></td>
				</tr>
			<tr>
				<td>출발날짜</td>
				<td><input class="size300" type="date" id="go_date" name="go_date" value="${ad.go_date}"></td>
				</tr>
			<tr>
				<td>돌아오는 날짜</td>
				<td><input class="size300" type="date" id="return_date" name="return_date" value="${ad.return_date}"></td>
				</tr>
			<tr>
				<td>출발 비행기 시간</td>
				<td><input class="size300" type="time" id="go_time" name="go_time" value="${ad.go_time}"></td>
				</tr>
			<tr>
				<td>왕복 비행기 시간</td>
				<td><input class="size300" type="time" id="return_time" name="return_time" value="${ad.return_time}"></td>
				</tr>
			<tr>
				<td>비행시간</td>
				<td><input class="size300" type="text" id="take_time" name="take_time" value="${ad.take_time}"></td>
				</tr>
			<tr>
				<td>비행기 번호</td>
				<td>
				<select name="ap_num">
					<c:forEach var="ad" items="${list}">
						<option value="${ad.ap_num}">${ad.ap_num}</option>
					</c:forEach>
				</select>
				</td>
				</tr>
			</table>
			<br>
			<div class="buttons">
				<input type="submit" value="변경">
				<input type="button" value="관리자 페이지" onclick="location.href='admin.do'">
			</div>
		<br>
		</form>
	</div>
	</div>
    
    <!-- /.container -->
	<br>
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
