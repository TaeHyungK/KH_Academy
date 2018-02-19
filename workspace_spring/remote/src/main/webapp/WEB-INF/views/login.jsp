<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>부트스트랩을 이용한 웹사이트 - 로그인</title>
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
					<li><a href="../getting-started">Getting
							started</a></li>
					<li><a href="#">CSS</a></li>
					<li><a href="#">Components</a></li>
					<li><a href="#">JavaScript</a></li>
					<li><a href="board.do" >게시판</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right nav-ex">
					<li class="active"><a href="login.do">로그인</a></li>
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
					<h2>로그인</h2>
					<p>회원 로그인 화면입니다. 회원 아이디와 비밀번호를 입력하고 로그인하세요.</p>
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
					<li><a href="#">회원가입</a></li>
					<li><a href="#">아이디 찾기</a></li>
					<li><a href="#">비밀번호찾기</a></li>
				</ul>
				<hr>
				<ul class="nav">
					<li><a href="#">고객센터</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-lg-9">
				<!-- 경고 메시지 시작 -->
				<div class="alert alert-danger fade in">
					<button type="button" class="close" data-dismiss="alert"
						aria-hidden="true">&times;</button>
					공용으로 사용하는 PC에서는 &quot;비밀번호 기억하기&quot;를 체크하면 개인정보 유출의 위험이있습니다.
				</div>
				
				<!-- 중앙 컨텐츠 시작 -->
				<form action="a.jsp" method="post">
					<fieldset>
						<legend>회원 로그인</legend>
						<div class="col-sm-9 col-lg-9">
							<div class="form-group custom-input">
								<div class="col-sm-3 col-lg-3">
									<label for="email">아이디</label>
								</div>
								<div class="col-sm-9 col-lg-9">
									<input class="form-control" type="email" id="email" name="email"
										placeholder="아이디" required />
								</div>
							</div>
							<div class="form-group custom-input">
								<div class="col-sm-3 col-lg-3">
									<label for="pwd">비밀번호</label>
								</div>
								<div class="col-sm-9 col-lg-9">
									<input class="form-control" type="password" id="pwd" name="pwd"
										placeholder="비밀번호" required autocomplete="off"/>
								</div>
							</div>
							<div class="form-group">
								<label class="string optional" for="user_remember_me"> <input
									id="user_remember_me" type="checkbox" name="remember" value="1">
									비밀번호 기억하기
								</label>
							</div>
						</div>
						<div class="col-sm-3 col-lg-3 custom-login-submit">
							<input class="btn btn-primary custom-submit" type="submit"
								value="로그인">
						</div>
					</fieldset>
				</form>
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
