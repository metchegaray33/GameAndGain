<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="../../assets/css/bootstrap-united.css" rel="stylesheet" />
	<link href="../../assets/css/notlogged.css" rel="stylesheet" />
	<title>Give and Gain</title>
</head>
<body>
	<!-- nav bar -->
	<div class="navbar">
		<div class="access_menu">
			<a class="access_menu-link" href="./signup">Registrarse</a>
			<a class="access_menu-link" href="./login">Iniciar Sesión</a>
			<!--  <a class="access_menu-link" href="webapi/adminResource/badges">Administrar Insignias</a> -->
		</div>
		<div class="logo_header">
			<a href="#">
				<img src="../../assets/img/logo.png" class="logo_title"> 
			</a>
		</div>
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-responsive-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> 
				<span class="icon-bar"></span>
			</button>
		</div>
		<div class="menu_bar">
			<a class="menu_bar-link" href="#">INICIO</a>
			<a class="menu_bar-link" href="#">JUGAR</a>
			<a class="menu_bar-link" href="#">RANKINGS</a>
			<form action="/GameAndGain/webapi/adminResource/searchResult" method="post">
				<input class="menu_bar-link search" type="text" name="seachW" placeholder="Buscar">
			</form>
		</div>
	</div>
	
	<!-- scripts -->
	<script src="../../jquery-1.8.3.js"></script>
	<script src="../../bootstrap/js/bootstrap.js"></script>

	<!-- main div -->
	<div class="main_div">
		<div class="main_div-table-header">Oops!</div>
		<p class="main_div-message">
			Inicia sesión para acceder al contenido!
		</p>
		<div class="main_div-form" method="get" action="">
			<div class="form-btns">
				<div onclick="location.href='./login';" class="main_div-btn login-btn">Inicia Sesion!</div>
				<p>¿No tienes una cuenta?</p>
				<div class="form-btns--a">
					<a href="./signup">Registrate aqui</a>	
				</div>
			
			</div>
		</div>
	</div>

	<!-- footer -->
	
	<footer class="footer">
		<img src="../../assets/img/gg.png" class="footer-img">
		<p class="footer-paragraph">2017 © puto el que copia</p>
		<div class="footer-div">
				<table class="footer_table-about">
					<th class="footer-table-about-header">About</th>
					<tr class="footer-table-row">
						<td class="footer-table-col">
							<a href="" class="footers-titles-links">FAQ</a>
						</td>
					</tr>
					<tr class="footer-table-row">
						<td class="footer-table-col">
							<a href="" class="footers-titles-links">Contact</a>
						</td>
					</tr>
					<tr class="footer-table-row">
						<td class="footer-table-col">
							<a href="" class="footers-titles-links">Tutorial</a>
						</td>
					</tr>
				</table>
				<table class="footer_table-social">
					<th class="footer-table-social-header">Follow Us</th>
					<tr class="footer-table-row">
						<td class="footer-table-col">
							<a href="" class="social-links">
								<img src="../../assets/img/face.png">
							</a>
							<a href="" class="social-links">
								<img src="../../assets/img/twitter.png">
							</a>
							<a href="" class="social-links">
								<img src="../../assets/img/gmail.png">
							</a>
							<a href="" class="social-links">
								<img src="../../assets/img/email.png">
							</a>
						</td>
					</tr>
				</table>
		 </div>
	</footer>

</body>
</html>