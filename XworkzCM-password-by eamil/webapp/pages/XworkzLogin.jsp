<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="style.css">
<script type="text/javascript" src="behavior.js"></script>

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
<title>XWORKZ-LOGIN</title>
<style type="text/css">
b {
	color: #fc6209;
	font-family: verdana;
	font-size: 15px;
	text-shadow: 2px 2px 5px black;
}
.page-footer {
	position: fixed;
	left: 0;
	bottom: 0;
	width: 100%;
	height: 60px; /* Height of the footer */
	background: #212529;
}
#msg {
	color: red;
	align-content: center;
	font-family: inherit;
}
</style>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
</head>

<body>
	<nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark">
		<a class="navbar-brand" href="#"> <img
			src="C:\Users\Vinay Viny\Desktop\xworkz1.jpg" width="70" height="40"
			class="d-inline-block align-top" alt="xworkz-logo"> <b>XWORKZ</b>

		</a>
		<nav class="navbar navbar-dark bg-dark">
			<form class="form-inline">
				<button style="margin-left: 18cm;" class="btn btn-outline-success"
					type="button" onclick="window.location.href='Home.jsp'">HOME</button>
				<button style="margin-left: 5px;" class="btn btn-outline-success"
					type="button"
					onclick="window.location.href='pages/XworkzRegister.jsp'">REGISTER</button>

			</form>
		</nav>
	</nav>

	<div class="container" align="center">
		<div id=msg>
			<h2>${loginfaildbyemail}</h2>
			<h2>${loginfaildbypasswod}</h2>
			<h1>${loginfaildbycount}</h1>
		</div>
		<div class="card bg-light" style="align-items: center;">
			<article class="card-body mx-auto"
				style="max-width: 400px; align-content: center;">
				<h4 class="card-title mt-3 text-center">LOGIN</h4>
				<p class="divider-text"></p>
				<form action="login.odc" method="post">
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-envelope"></i>
							</span>
						</div>
						<input name="email" class="form-control" placeholder="Enter Email"
							type="email" value="${dto.email}" />
					</div>
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-envelope"></i>
							</span>
						</div>
						<input name="password" class="form-control"
							placeholder="Enter password" type="password"
							value="${dto.password}" />
					</div>
					<!-- form-group// -->
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-block">
							Login</button>
					</div>
					<!-- form-group// -->
					<p class="text-center">
						<a href="XworkzResetPassword.jsp">Forgot Password?</a>
					</p>
				</form>
			</article>
		</div>
		<!-- card.// -->
	</div>
	<!--container end.//-->

	<!-- Footer -->
	<footer class="page-footer font-dark">

		<!-- Copyright -->
		<div class="footer-copyright text-center py-3" style="color: white;">
			© 2020 Copyright: <a
				href="https://www.google.com/search?rlz=1C1CHBF_enIN861IN861&sxsrf=ALeKk00n_oruu5czc58lamIZ9LDWYX882Q%3A1586855738603&ei=On-VXrK1JMz2rQGyxgk&q=x-workz&oq=x-workz&gs_lcp=CgZwc3ktYWIQA1D_HFj_HGDPJGgAcAB4AIABAIgBAJIBAJgBAKABAaoBB2d3cy13aXo&sclient=psy-ab&ved=0ahUKEwiyuu-kyufoAhVMeysKHTJjAgAQ4dUDCAw&uact=5/">
				X-wokz.com</a>
		</div>
		<!-- Copyright -->

	</footer>
	<!-- Footer -->
</body>