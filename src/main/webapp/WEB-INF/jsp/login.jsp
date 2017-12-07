<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link href="../../assets/css/bootstrap-united.css" rel="stylesheet" />
		<link href="../../assets/css/login.css" rel="stylesheet" />
		<style>
		.error {
			color: #ff0000;
			font-size: 0.9em;
			font-weight: bold;
		}
		
		.errorblock {
			color: #000;
			background-color: #ffEEEE;
			border: 3px solid #ff0000;
			padding: 8px;
			margin: 16px;
		}
		</style>
		<title>Iniciar Sesion</title>
	</head>
	<body>
	
		<!-- HEADER -->
		<div class="navbar">
			<div class="access_menu">
				<a class="access_menu-link" href="./signup">Registrarse</a>
				<a class="access_menu-link" href="#">Iniciar Sesión</a>
			</div>
			<div class="logo_header">
				<a href="#">
					<img src="../../assets/img/logo.png" class="logo_title"> 
				</a>
			</div>
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-responsive-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</div>
			<div class="menu_bar">
				<a href="../../." class="menu_bar-link">INICIO</a>
				<a href="../../webapi/adminResource/not_logged_in" class="menu_bar-link">JUGAR</a>
				<a href="../../webapi/adminResource/not_logged_in" class="menu_bar-link">RANKINGS</a>
				<form action="/GameAndGain/webapi/adminResource/searchResult" method="post">
				<input class="menu_bar-link search" type="text" name="seachW" placeholder="Buscar">
			</form>
				
			</div>
		</div>
		
		<!-- SCRIPTS -->
		<script src="../../jquery-1.8.3.js"></script>
		<script src="../../bootstrap/js/bootstrap.js"></script>
	
		<!-- LOGIN SECTION -->
		<section class="login_section">
			<table class="login_section-table">
					<th class="login_section-table-header">Iniciar Sesion</th>
			</table>
			<form:form id="myForm" class="login_section-form" method="post" action="login">
				<label for="emailAddressInput" class="login_section-form-labels">Email</label>
				<input type="text" class="login_section-form-inputs" name="emailAddress" id="emailAddressInput" placeholder="tomas.vuka23@me.com" value="${it.user.emailAddress}" />
				<label for="passwordInput" class="login_section-form-labels">Password</label>
				<input type="password" class="login_section-form-inputs" name="password" id="passwordInput"  value="${it.user.password}" />												
				<div class="login_section-form-btns">
					<button class="btn btn-default btn-cancel">Cancelar</button>
					<button class="btn btn-primary btn-login">Iniciar Sesion</button>
				</div>
			</form:form>
		</section>
		
		<!-- FOOTER -->
		
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