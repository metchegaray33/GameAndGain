<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="../../assets/css/bootstrap-united.css" rel="stylesheet" />
	<link href="../../assets/css/profile.css" rel="stylesheet" />
	<title>Editar Perfil</title>
</head>
	<body>
		<div class="navbar">
		<div class="access_menu">
			<a class="access_menu-link" href="./signup">Cerrar Sesion</a>
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
			<a href="#" class="menu_bar-link">INICIO</a>
			<a href="#" class="menu_bar-link">MI PERFIL</a>
			<a href="#" class="menu_bar-link">JUGAR</a>
			<a href="#" class="menu_bar-link">RANKINGS</a>
			<input class="menu_bar-link search" type="text" name="searchIn" placeholder="Buscar">

		</div>

		<!-- /.nav-collapse -->
	</div>
	<script src="../../jquery-1.8.3.js">
		
	</script>

	<script src="../../bootstrap/js/bootstrap.js">
		
	</script>

	<div class="div_profile">
	
		<table class="div_profile-table">
			<th class="div_profile-table-header">Editar Perfil</th>
		</table>
			
		<form:form class="div_profile-form" method="post" action="updateProfile">
		 
				
				
				<label for="firstNameInput" class="signup_section-form-labels">Nombre</label>
				<input type="text" class="div_profile-form-inputs" name="firstName" id="firstNameInput" placeholder="${it.info.name}" value="${it.user.firstName}" />
				
				<label for="lastNameInput" class="signup_section-form-labels">Apellido</label>
				<input type="text" class="div_profile-form-inputs" name="lastName" id="lastNameInput" placeholder="${it.info.lastname}" value="${it.user.lastName}" />
				
				<label for="emailAddressInput" class="signup_section-form-labels">Email</label>
				<input type="text" class="div_profile-form-inputs" name="emailAddress" id="emailAddressInput" placeholder="${it.info.mail}" value="${it.user.emailAddress}" />
				
				<label for="passwordInput" class="signup_section-form-labels">Password</label>
				<input type="password" class="div_profile-form-inputs" name="password" id="passwordInput"  value="${it.info.password}" />					
				
				<label for="birthdateInput" class="signup_section-form-labels">Fecha de Nacimiento</label>
				<div class="date form_date"
						data-date-format="mm/dd/yyyy" data-date-viewmode="years">
						
						<input type="text" class="div_profile-form-inputs" name="birthdate" id="birthdateInput" placeholder="${it.info.birthdate}" value="${myDate}" />
				</div>
	
									
				<label for="phoneInput" class="signup_section-form-labels">Telefono</label>
				<input type="text" class="div_profile-form-inputs" name="phone" id="phoneInput" placeholder="${it.info.phone}" value="${it.user.phone}" />
										
				<label for="countryInput" class="signup_section-form-labels">Pais</label>
				<input type="text" class="div_profile-form-inputs" name="country" id="countryInput" placeholder="${it.info.country}" value="${it.user.country}" />
										
				<label for="interestInput" class="signup_section-form-labels">Interes</label>
				<select class="signup_section-form-select" name="interest" id="interestInput" value="${it.user.interest}" >
					  <option disabled selected>${it.info.interests_InterestId}</option>
					  <option value="1">Educativo</option>
					  <option value="2">Cultural</option>
					  <option value="3">Ambiental</option>
					</select >
													
				<label for="roleInput" class="signup_section-form-labels">Rol</label>
				<select class="signup_section-form-select" name="role" id="roleInput" value="${it.user.role}">
					  <option disabled selected>${it.info.roles_RoleId}</option>
					  <option value="1" >Jugador</option>
					  <option value="2">Donante</option>
					  <option value="3">Beneficiario</option>
					  <option value="4" >Gestor de Campañas</option>
					</select>
										
				<div class="signup_section-form-btns">
					<button class="btn btn-default btn-cancel">Cancel</button>
					<button class="btn btn-primary btn-login" data-toggle="modal" data-target="#themodal">Submit</button>
					<div id="themodal" class="modal fade" data-backdrop="static">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
									<h3>Signup Form Submission</h3>
								</div>
								<div class="modal-body">
									<p>Are you sure you want to do this?</p>
									<div class="progress progress-striped active">
										<div id="doitprogress" class="progress-bar"></div>
									</div>
								</div>
								<div class="modal-footer">
									<a href="#" class="btn btn-default" data-dismiss="modal">Close</a>
									<input type="submit" value="Yes" id="yesbutton" class="btn btn-primary" data-loading-text="Saving.." data-complete-text="Submit Complete!">
								</div>
							</div>
						</div>
					</div>
				</div>
			</form:form>
	
	</div>

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