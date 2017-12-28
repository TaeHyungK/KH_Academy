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
    <title>예매 티켓 입력</title>
    <script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="../js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="../js/reservation.js"></script>
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
            <li class="nav-item active px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="about.do">List</a>
            </li>
            <li class="nav-item px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="../reservation/detail.do">MyPage</a>
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
            	<li class="nav-item px-lg-4">
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
<br>
<h2 style="text-align:center">검색하신 비행이 현황</h2>
		<table>
			<tr>
				<td>출발지</td>
				<td>도착지</td>
				<td>예상시간</td>
				<td>출발날짜</td>
				<td>도착날짜</td>
				<td>출발시간</td>
				<td>도착시간</td>
				<td>예매 가능 좌석수</td>
			</tr>
		</table>

		<form action="reservation.do" method="post" class="resForm">
			<input type="hidden" id="snum" name="snum" value="${ad.snum}">
		<table>		
				<tr>
					<td>${ad.start_lo}</td>
					<td>${ad.end_lo}</td>
					<td>${ad.take_time}시간</td>
					<td>${ad.go_date}</td>
					<td>${ad.return_date}</td>
					<td>${ad.go_time}</td>
					<td>${ad.return_time}</td>
					<td>${ad.seats}석</td>
				</tr>
				<tr>
					<td colspan="2">
						<label for="a_ticket">성인</label>
						<input class="a_ticket" type="number" min="0" max="1000" name="a_ticket" class="a_ticket" value="0">
					</td>
					<td colspan="2">
						<label for="as_ticket">청소년</label>
						<input class="as_ticket" type="number" min="0" max="1000" name="as_ticket" class="as_ticket" value="0">
					</td>
					<td colspan="2">	
						<label for="c_ticket">어린이</label>
						<input class="c_ticket" type="number" min="0" max="1000" name="c_ticket" class="c_ticket" value="0">
					</td>
					<td colspan="2">
					<div style="text-align:center">
						<input type="submit" value="예약">
					</div>
					</td>
				</tr>
			</table>
			</form>
			
	<div class="buttons">
			<input type="button" value="홈으로" onclick="location.href='../main/main.do'">
	</div>
	<br>
</div>
<br>
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