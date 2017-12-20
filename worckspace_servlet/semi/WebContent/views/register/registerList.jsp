<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
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
              <a class="nav-link text-uppercase text-expanded" href="../main/about.do">List</a>
            </li>
            <li class="nav-item px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="../mypage_user/detail.do">MyPage</a>
            </li>
            <c:if test="${user_id=='admin'}">
            	<li class="nav-item active px-lg-4">
              		<a class="nav-link text-uppercase text-expanded" href="../register/registerList.do">RegisterPage</a>
            	</li>
            </c:if>
            <li class="nav-item px-lg-4">
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
	<div class="container">
		<div class="bg-faded p-4 my-4 style">
			<div class="text-center mt-4">
				<h2>RegisterUserList</h2>
				<form  id="search_form" method="get">
					<ul class="search">
						<li>
							<select name="keyfield">
								<option value="id">ID</option>
								<option value="name">이름</option>
							</select> 
								<input type="search" size="16" name="keyword" id="keyword">
								<input type="submit" value="Search">
						</li>
							<br>
						<c:if test="${count == 0}">
							<div class="result-display">가입한 회원이 없습니다.</div>
						</c:if>
						<c:if test="${count > 0}">
							<table border="1" width="70%" align="center">
								<tr bgcolor="#bac9e2">
									<th>NAME</th>
									<th>ID</th>
									<th>PHONE</th>
									<th>SEX</th>
									<th>CARD_NUM</th>
									<!-- 예매 내역,삭제 -->
									<th>RESEVATION</th>
									<!-- 회원정보 수정,삭제-->
									<th>UPDATE</th>
									<th>DELETE</th> 
									
								</tr>
								<c:forEach var="i" begin="0" end="${list.size()-1}" step="1">
									<tr>
										<td>${list.get(i).name}</td>
										<td>${list.get(i).id}</td>
										<td>${list.get(i).phone}</td>
										<td>${list.get(i).sex}</td>
										<td>${list.get(i).card_num}</td>
										<!-- 회원정보 수정,삭제-->
										<td><a href="reservationDetail.do?id=${list.get(i).id}">RSV_DETAIL</a></td>
										<!-- 예매 내역,삭제 -->
										<td><a href="registerModifyLoginForm.do?id=${list.get(i).id}">UPDATE</a></td>
										<c:if test="${!empty rs_list.get(i)}">	
											<td>예약중</td>	
										</c:if>
										<c:if test="${empty rs_list.get(i)}">
											<td><a href="registerDeleteForm.do?id=${list.get(i).id}">DELETE</a></td>
										</c:if>
									
									</tr>
								</c:forEach>
							</table>
							<div class="align-center">${paginHtml}</div>
						</c:if>
					</ul>
				</form>
			</div>
		</div>
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