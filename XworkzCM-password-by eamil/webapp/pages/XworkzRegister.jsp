<%@page import="org.springframework.ui.ModelMap"%>
<%@page import="org.springframework.ui.Model"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="style.css">
<script type="text/javascript" src="behavior.js"></script>
<title>Xworkz-Register</title>
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
	font-family:inherit;
}
.error {
	color: red
}
</style>

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
</head>
<nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark">
	<a class="navbar-brand" href="#"> <img
		src="C:\Users\Vinay Viny\Desktop\xworkz1.jpg" width="70" height="40"
		class="d-inline-block align-top" alt="xworkz-logo"> <b>XWORKZ</b>

	</a>
	<nav class="navbar navbar-dark bg-dark">
		<form class="form-inline">
			<button style="margin-left: 18cm;" class="btn btn-outline-success"
				type="button" onclick="window.location.href='XworkzLogin.jsp'">LOGIN</button>
			<button style="margin-left: 5px;" class="btn btn-outline-success"
				type="button" onclick="window.location.href='Home.jsp'">HOME</button>
		</form>
	</nav>
</nav>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	></script>
<body>

	<div class="container" align="center">
		<div id=msg>
			<h2>${success}</h2>
			<h2>${disagree}</h2>
			<h2>${emailExicit}</h2>
			<h2>${userExicit}</h2>
		</div>
		<div class="card bg-light" style="align-items: center;">
			<article class="card-body mx-auto"
				style="max-width: 400px; align-content: center;">
				<h4 class="card-title mt-3 text-center">Create Account</h4>
				<p class="text-center">Get started with your free account</p>
				<p class="divider-text"></p>
				<form action="register.odc" method="post">
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-user"></i>
							</span>
						</div>
						<input name="userId" class="form-control" placeholder="User Id"
							type="text" value="${dto.userId}" />
					</div>
					<!-- form-group// -->
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-envelope"></i>
							</span>
						</div>
						<input name="email" class="form-control"
							placeholder="Email address" type="email" value="${dto.email}" />
					</div>
					<!-- form-group// -->
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-phone"></i>
							</span>
						</div>
						<select class="custom-select" style="max-width: 120px;">
							<option selected="selected">+91</option>
							<option value="1">+92</option>
							<option value="2">+98</option>
							<option value="3">+70</option>
						</select> <input name="phone" class="form-control"
							placeholder="Phone number" type="number" value="${dto.phone}" />
					</div>
					<!-- form-group// -->
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-book"></i>
							</span>
						</div>
						<select class="form-control" name="course">
							<option selected="selected">java</option>
							<option>Web Designing</option>
							<option>Testing</option>
							<option>Angular</option>
						</select>
					</div>
					<!-- form-group end.// -->
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i
								class="fa fa-check-circle"></i>
							</span>
						</div>
						Agree <input name="agree" class="form-control" type="radio"
							value="yes" /> DisAgree <input name="agree" class="form-control"
							type="radio" value="no" />
					</div>
					<!-- form-group// -->
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-block">
							Create Account</button>
					</div>
					<!-- form-group// -->
					<p class="text-center">
						Have an account? <a href="/XworkzLogin.jsp">Log In</a>
					</p>
				</form>
			</article>
		</div>
		<!-- card.// -->
	</div>
	<!--container end.//-->

</body>

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
</html>