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
    <script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="../js/member.js"></script>
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
            <li class="nav-item active px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="../index.jsp">Home
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="about.html">List</a>
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
          
    <!-- Join Form -->
    <div class="container">
    <div class="align-content-center">
      <div class="bg-faded p-4 my-4">
        <hr class="divider">
        <h2 class="text-center text-lg text-uppercase my-0">
          <strong>Join Form</strong>
        </h2>
        <hr class="divider">
        <form id="modify_form" action="modifyUser.do" method="post">
        <div class="row">
            <div class="form-group col-lg-4" style="margin:0 auto;">
              <label class="text-heading" for="id">ID : </label>
              <input type="hidden" class="form-control" name="id" id="id" value="${member.id}"><strong>${member.id}</strong>
            </div>
         </div>
          <div class="row">
            <div class="form-group col-lg-4" style="margin:0 auto;">
              <label class="text-heading" for="name">Name</label>
              <input type="text" class="form-control" name="name" id="name" value="${member.name}">
            </div>
         </div>
         <div class="row">
            <div class="form-group col-lg-4" style="margin:0 auto;">
              <label class="text-heading" for="phone">Phone Number</label>
              <input type="tel" class="form-control" name="phone" id="phone" value="${member.phone}">
            </div>
         </div>
         <div class="row">
            <div class="form-group col-lg-4" style="margin:0 auto;">
              <label class="text-heading" for="sex">Gender</label>
              <input type="text" class="form-control" name="sex" id="sex" value="${member.sex}">
            </div>
         </div>
         <div class="row">
            <div class="form-group col-lg-4" style="margin:0 auto;">
              <label class="text-heading" for="card_num">Card Number</label>
              <input type="text" class="form-control" name="card_num" id="card_num" value="${member.card_num}">
            </div>
            <div class="clearfix"></div>
         </div>
            <div class="form-group col-lg-12" align="center" style="margin-top:10px">
              <button type="submit" class="btn btn-secondary">Submit</button>
            </div>
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
