<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="style.css">
<title>Xworkz-LoginSucces page</title>
<style type="text/css">
b {
	color: #fc6209;
	font-family: verdana;
	font-size: 15px;
	text-shadow: 2px 2px 5px black;
}

.form-inline {
	margin-right: 25px;
}

.page-footer {
	position: fixed;
	left: 0;
	bottom: 0;
	width: 100%;
	height: 60px; /* Height of the footer */
	background: #212529;
}

.msg {
	color: white;
	font-family: cursive;
	font-style: inherit;
	font-size: 15px;
}
</style>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>

<body>
	<nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark">
		<a class="navbar-brand" href="#"> <img
			src="C:\Users\Vinay Viny\Desktop\xworkz1.jpg" width="70" height="40"
			class="d-inline-block align-top" alt="xworkz-logo"> <b>XWORKZ</b>

		</a>
		<nav class="navbar navbar-dark bg-dark">
			<form class="form-inline">
				<div style="text-align: right; width: 100%; padding: 0;">
					<button style="margin-left: 18cm;" class="btn btn-outline-success"
						type="button" onclick="window.location.href='Home.jsp'">HOME</button>
				</div>
			</form>
		</nav>
	</nav>

	<div class="msg">
		<h1>${loginsuccess}</h1>
		<h1>${msg}</h1>
	</div>
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