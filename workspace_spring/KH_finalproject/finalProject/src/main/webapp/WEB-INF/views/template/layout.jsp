<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<!-- Define Charset -->
<meta charset="utf-8">

<!-- Responsive Metatag -->
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

<!-- Page Description and Author -->
<meta name="description" content="Construction - Responsive HTML5 Template">
<meta name="author" content="iThemesLab">
<link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">

<!-- key값을 이용해서 value를 읽어 옴 -->
<title><tiles:getAsString name="title"></tiles:getAsString></title>
<!-- Bootstrap start -->
   <!-- Bootstrap CSS  -->
   <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" type="text/css">

   <!-- Font Awesome CSS -->
   <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/css/font-awesome.min.css" type="text/css">
   
   <!-- Owl Carousel CSS -->
   <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/css/owl.carousel.css" type="text/css">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/css/owl.theme.css" type="text/css">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/css/owl.transitions.css" type="text/css">
   
   <!-- Light Box CSS -->
   <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/css/lightbox.css" type="text/css">
   

   <!-- Construction CSS Styles  -->
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap/css/style.css">
   
   <!-- Default Color -->
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap/css/colors/light-red.css">
   
   <!-- Colors CSS -->
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap/css/colors/light-red.css" title="light-red">
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap/css/colors/green.css" title="green">
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap/css/colors/blue.css" title="blue">
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap/css/colors/light-blue.css" title="light-blue">
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap/css/colors/yellow.css" title="yellow">
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap/css/colors/black.css" title="black">
   
   <!-- Responsive CSS Style -->
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap/css/responsive.css">

   <!-- Css3 Transitions Styles  -->
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap/css/animate.css">
   
   
   <!-- Construction JS File -->
   <script src="${pageContext.request.contextPath}/resources/bootstrap/js/jquery-2.1.1.min.js"></script>
   <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
   <script src="${pageContext.request.contextPath}/resources/bootstrap/js/modernizr.custom.js"></script>
   <script src="${pageContext.request.contextPath}/resources/bootstrap/js/owl.carousel.min.js"></script>
   <script src="${pageContext.request.contextPath}/resources/bootstrap/js/lightbox.min.js"></script>
   <script src="${pageContext.request.contextPath}/resources/bootstrap/js/jquery.appear.js"></script>
   <script src="${pageContext.request.contextPath}/resources/bootstrap/js/jquery.fitvids.js"></script>
   <script src="${pageContext.request.contextPath}/resources/bootstrap/js/jquery.nicescroll.min.js"></script>
   <script src="${pageContext.request.contextPath}/resources/bootstrap/js/superfish.min.js"></script>
   <script src="${pageContext.request.contextPath}/resources/bootstrap/js/supersubs.js"></script>
   <script src="${pageContext.request.contextPath}/resources/bootstrap/js/styleswitcher.js"></script>
   <script src="${pageContext.request.contextPath}/resources/bootstrap/js/script.js"></script>
   
</head>
<body>
<div id="container">
	<div id="main_header">
		<tiles:insertAttribute name="header"/>
	</div>
	<div id="main_body">
		<tiles:insertAttribute name="body"/>
	</div>
	<div id="main_footer">
		<tiles:insertAttribute name="footer"/>
	</div>
</div>
</body>
</html>