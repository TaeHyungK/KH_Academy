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
            <li class="nav-item active px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="index.html">Home
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
    <!-- Login Form -->
    <div class="container">
    	<div class="p-4" align="right">
	    	<form action="login.do" method="post" id="login_form">
		            	<label for="id">ID</label>
		            	<input type="text" name="id" id="id" size="10" maxlength="15"><br>
		            	<label for="passwd">Password</label>
		            	<input type="password" name="passwd" id="passwd" size="10" maxlength="15"><br>
		            	<input type="submit" value="Login">
		            	<input type="button" value="Join" onclick="location.href='#'">
	        </form>
    	</div>
    </div>

    <div class="container">
      <div class="bg-faded p-4 my-4">
        <!-- Welcome Message -->
        <div class="text-center mt-4">
        <form action="searchAir.do" method="post" id="search_form">
		<ul>
			<li>
				<label for="start_location">Start</label>
				<input type="text" name="start_location" id="start_location" width="500">     
			</li>
			<li>
				<label for="end_location">End</label>
				<input type="text" name="end_location" id="end_location" width="500">
			</li>
			<li>
				<label for="go_date">Departure Date</label>
				<input type="date" name="go_date" id="go_date" size="15">
				<label for="go_time">Departure Time</label>
				<input type="time" name="go_time" id="go_time" size="15">
			</li>
			<li>
				<label for="arrival_date">Arrival Date</label>
				<input type="date" name="arrival_date" id="arrival_date" size="15">
				<label for="arrival_time">Arrival Time</label>
				<input type="time" name="arrival_time" id="arrival_time" size="15">
			</li>
			<li style="clear:both;">
				<label for="adult_num" style="width:100px">Adult</label>
				<input type="number" name="adult_num" id="adult_num" style="width:40px;" value="1" min="0"> 
				<label for="student_num" style="width:100px">Student</label>
				<input type="number" name="student_num" style="width:40px;" id="student_num" size="5" value="0" min="0">
				<label for="kid_num" style="width:100px">kid</label>
				<input type="number" name="kid_num" id="kid_num" style="width:40px;" value="0" min="0">
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="search">
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
