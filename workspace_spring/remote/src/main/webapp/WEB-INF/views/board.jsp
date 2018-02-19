<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>부트스트랩을 이용한 웹사이트 - 게시판</title>
<link rel="stylesheet" href="../resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="../resources/css/bootstrap-theme.min.css" />
<link rel="stylesheet" href="../resources/css/style.css" />
<script src="../resources/js/jquery-3.2.0.min.js"></script>
<script src="../resources/js/bootstrap.min.js"></script>
</head>

<body>
	<!-- 상단 네비게이션 시작 -->

	<nav class="navbar" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle custom-navbar" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar custom-icon-bar"></span> <span
						class="icon-bar custom-icon-bar"></span> <span
						class="icon-bar custom-icon-bar"></span>
				</button>
				<a href="index.do" class="navbar-brand">Bootstrap</a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav nav-ex">
					<li><a href="#">Getting started</a></li>
					<li><a href="#">CSS</a></li>
					<li><a href="#">Components</a></li>
					<li><a href="#">JavaScript</a></li>
					<li class="active"><a href="board.do">게시판</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right nav-ex">
					<li><a href="login.do">로그인</a></li>
					<li><a href="register.do">회원가입</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- 전체 화면 컨텐츠 시작 -->
	<div class="content-ex">
		<div class="container">
			<div class="row">
				<div class="col-md-3 col-lg-3">
					<h2>게시판</h2>
					<p>회원 또는 비회원 게시물을 확인할 수 있고 질문과 답변 코너를 이용한 다양한 질문에 대한 관리자의 상세
						답변을 확인할 수 있습니다.</p>
				</div>
				<div class="col-md-9 col-lg-9">
					<div class="custom-image-space">
						<img src="../resources/images/Penguins.jpg" class="img-responsive"
							alt="board 이미지">
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 중앙 컨텐츠 시작 -->
	<div class="container">
		<div class="row">
			<div class="col-sm-3 col-lg-3">

				<ul class="nav">
					<li><a href="#">가장 많이 본 게시물</a></li>
					<li><a href="#">댓글 많은 게시물</a></li>
					<li><a href="#">최신 게시물</a></li>
				</ul>
				<hr>
				<ul class="nav">
					<li><a href="#">여행관련자료</a></li>
					<li><a href="#">여가생활</a></li>
					<li><a href="#">중고장터</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-lg-9">
				<!-- 중앙 컨텐츠 시작 -->
				<ul class="nav nav-tabs">
					<li class="active"><a href="#">회원전용</a></li>
					<li><a href="#">비회원전용</a></li>
					<li><a href="#">질문과 답변</a></li>
				</ul>
				<div class="table-responsive">
					<table class="table table-striped">
						<tr>
							<th>#</th>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Username</th>
						</tr>
						<tr>
							<td>1</td>
							<td>Mark</td>
							<td>Otto</td>
							<td>@mdo</td>
						</tr>
						<tr>
							<td>2</td>
							<td>Park</td>
							<td>Soon</td>
							<td>@sns</td>
						</tr>
						<tr>
							<td>2</td>
							<td>Park</td>
							<td>Soon</td>
							<td>@sns</td>
						</tr>
						<tr>
							<td>2</td>
							<td>Park</td>
							<td>Soon</td>
							<td>@sns</td>
						</tr>
						<tr>
							<td>2</td>
							<td>Park</td>
							<td>Soon</td>
							<td>@sns</td>
						</tr>
						<tr>
							<td>2</td>
							<td>Park</td>
							<td>Soon</td>
							<td>@sns</td>
						</tr>
						<tr>
							<td>2</td>
							<td>Park</td>
							<td>Soon</td>
							<td>@sns</td>
						</tr>
						<tr>
							<td>2</td>
							<td>Park</td>
							<td>Soon</td>
							<td>@sns</td>
						</tr>
						<tr>
							<td>2</td>
							<td>Park</td>
							<td>Soon</td>
							<td>@sns</td>
						</tr>
					</table>
				</div>
				<!-- 페이지 네이션 -->
				<div class="pagination-align">
					<ul class="pagination">
						<li class="disabled"><span>«</span></li>
						<li class="active"><span>1 <span class="sr-only">(current)</span></span></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#">»</a></li>
					</ul>
				</div>
			</div>
			<!--row-->
		</div>

		<hr>

		<!-- 푸터 시작 -->
		<div id="footer">
			<p>&copy; Company 2014</p>
		</div>

	</div>
	<!-- /container -->
</body>
</html>