<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>부트스트랩을 이용한 웹사이트 - 메인</title>
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
					<li class="active"><a href="../getting-started">Getting
							started</a></li>
					<li><a href="#">CSS</a></li>
					<li><a href="#">Components</a></li>
					<li><a href="#">Javascript</a></li>
					<li><a href="board.do">게시판</a></li>
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
					<h2>Getting started</h2>
					<p>An overview of Bootstrap, how to download and use, basic
						templates and examples, and more.</p>
					<p>
						<a class="btn btn-primary btn-lg">Learn more</a>
					</p>
				</div>
				<div class="col-md-9 col-lg-9">
					<div id="carousel-example-generic" class="carousel slide"
						data-ride="carousel">
						<!-- Indicators -->
						<ol class="carousel-indicators">
							<li data-target="#carousel-example-generic" data-slide-to="0"
								class="active"></li>
							<li data-target="#carousel-example-generic" data-slide-to="1"></li>
							<li data-target="#carousel-example-generic" data-slide-to="2"></li>
							<li data-target="#carousel-example-generic" data-slide-to="3"></li>
						</ol>

						<!-- Wrapper for slides -->
						<div class="carousel-inner custom-image-space">
							<div class="item active">
								<img src="../resources/images/Koala.jpg" alt="First slide">
								<!-- <div class="carousel-caption">
									<h3>Koala</h3>
									<p>Animal World!!</p>
								</div> -->
							</div>
							<div class="item">
								<img src="../resources/images/Lighthouse.jpg" alt="Second slide">
								<!-- <div class="carousel-caption">
									<h3>Lighthouse</h3>
									<p>Animal World!!</p>
								</div> -->
							</div>
							<div class="item">
								<img src="../resources/images/Penguins.jpg" alt="Third slide">
								<!-- <div class="carousel-caption">
									<h3>Penguins</h3>
									<p>Animal World!!</p>
								</div> -->
							</div>
							<div class="item">
								<img src="../resources/images/Tulips.jpg" alt="Third slide">
								<!-- <div class="carousel-caption">
									<h3>Tulips</h3>
									<p>Animal World!!</p>
								</div> -->
							</div>
						</div>

						<!-- Controls -->
						<a class="left carousel-control" href="#carousel-example-generic"
							role="button" data-slide="prev"> <span
							class="glyphicon glyphicon-chevron-left"></span>
						</a> <a class="right carousel-control"
							href="#carousel-example-generic" role="button" data-slide="next">
							<span class="glyphicon glyphicon-chevron-right"></span>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 중앙 컨텐츠 시작 -->
	<div class="container">

		<div class="row">
			<div class="col-lg-8">
				<div class="row row-ex">
					<div class="col-sm-6 col-lg-6">
						<h2>Heading</h2>
						<p>Donec id elit non mi porta gravida at eget metus. Fusce
							dapibus, tellus ac cursus commodo, tortor mauris condimentum
							nibh, ut fermentum massa justo sit amet risus. Etiam porta sem
							malesuada magna mollis euismod. Donec sed odio dui.
							malesuada magna mollis euismod. Donec sed odio dui.
							malesuada magna mollis euismod. Donec sed odio dui.
							malesuada magna mollis euismod. Donec sed odio dui.</p>
						<p>
							<a class="btn btn-default" href="#" role="button">View
								details &raquo;</a>
						</p>
					</div>

					<div class="col-sm-6 col-lg-6">
						<h2>Heading</h2>
						<p>Donec id elit non mi porta gravida at eget metus. Fusce
							dapibus, tellus ac cursus commodo, tortor mauris condimentum
							nibh, ut fermentum massa justo sit amet risus. Etiam porta sem
							malesuada magna mollis euismod. Donec sed odio dui.
							malesuada magna mollis euismod. Donec sed odio dui.
							malesuada magna mollis euismod. Donec sed odio dui.
							malesuada magna mollis euismod. Donec sed odio dui.</p>
						<p>
							<a class="btn btn-default" href="#" role="button">View
								details &raquo;</a>
						</p>
					</div>
				</div>
			</div>
			<div class="col-lg-4">
				<!-- 패널 리스트 시작 -->
				<div class="panel panel-primary">
					<!-- 패널 해드 시작 -->
					<div class="panel-heading">Panel heading</div>
					<!-- 리스트 시작 -->
					<div class="list-group">
						<a href="#" class="list-group-item">
							<h4 class="list-group-item-heading">
								List group item heading <span class="badge">14</span>
							</h4>
							<p class="list-group-item-text">Donec id elit non mi porta
								gravida at eget metus. Maecenas sed diam eget risus varius
								blandit.</p>
						</a> <a href="#" class="list-group-item">
							<h4 class="list-group-item-heading">List group item heading</h4>
							<p class="list-group-item-text">Donec id elit non mi porta
								gravida at eget metus. Maecenas sed diam eget risus varius
								blandit.</p>
						</a> <a href="#" class="list-group-item">
							<h4 class="list-group-item-heading">List group item heading</h4>
							<p class="list-group-item-text">Donec id elit non mi porta
								gravida at eget metus. Maecenas sed diam eget risus varius
								blandit.</p>
						</a>
					</div>
				</div>
			</div>
		</div>

		<!-- 썸네일 시작 -->
		<div class="row">
			<div class="col-sm-6 col-lg-3">
				<div class="thumbnail">
					<img src="../resources/images/Hydrangeas.jpg"
						alt="Generic placeholder thumbnail" src="data:image/png;base64,">
					<div class="caption">
						<h3>Thumbnail label</h3>
						<p>Cras justo odio, dapibus ac facilisis in, egestas eget
							quam. Donec id elit non mi porta gravida at eget metus. Nullam id
							dolor id nibh ultricies vehicula ut id elit.</p>
					</div>
				</div>
			</div>

			<div class="col-sm-6 col-lg-3">
				<div class="thumbnail">
					<img src="../resources/images/Hydrangeas.jpg"
						alt="Generic placeholder thumbnail" src="data:image/png;base64,">
					<div class="caption">
						<h3>Thumbnail label</h3>
						<p>Cras justo odio, dapibus ac facilisis in, egestas eget
							quam. Donec id elit non mi porta gravida at eget metus. Nullam id
							dolor id nibh ultricies vehicula ut id elit.</p>
					</div>
				</div>
			</div>

			<div class="col-sm-6 col-lg-3">
				<div class="thumbnail">
					<img src="../resources/images/Hydrangeas.jpg"
						alt="Generic placeholder thumbnail" src="data:image/png;base64,">
					<div class="caption">
						<h3>Thumbnail label</h3>
						<p>Cras justo odio, dapibus ac facilisis in, egestas eget
							quam. Donec id elit non mi porta gravida at eget metus. Nullam id
							dolor id nibh ultricies vehicula ut id elit.</p>
					</div>
				</div>
			</div>

			<div class="col-sm-6 col-lg-3">
				<div class="thumbnail">
					<img src="../resources/images/Hydrangeas.jpg"
						alt="Generic placeholder thumbnail" src="data:image/png;base64,">
					<div class="caption">
						<h3>Thumbnail label</h3>
						<p>Cras justo odio, dapibus ac facilisis in, egestas eget
							quam. Donec id elit non mi porta gravida at eget metus. Nullam id
							dolor id nibh ultricies vehicula ut id elit.</p>
					</div>
				</div>
			</div>
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
