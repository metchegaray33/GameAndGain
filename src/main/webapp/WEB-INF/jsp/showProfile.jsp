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
	<title>${it.info.name} ${it.info.lastname}</title>
</head>
	<body>
		<div class="navbar">
		<div class="access_menu">
			<
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
			<a class="menu_bar-link" href="/GameAndGain">INICIO</a>
			<a href="/GameAndGain/webapi/adminResource/profile" class="menu_bar-link">MI PERFIL</a>
			
			<a href="#" class="menu_bar-link">RANKINGS</a>
			<form action="/GameAndGain/webapi/adminResource/searchResult" method="post">
				<input class="menu_bar-link search" type="text" name="seachW" placeholder="Buscar">
			</form>

		</div>

		<!-- /.nav-collapse -->
	</div>
	<script src="../../jquery-1.8.3.js">
		
	</script>

	<script src="../../bootstrap/js/bootstrap.js">
		
	</script>

	<div class="div_profile">
	
		<table class="div_profile-table">
			<th class="div_profile-table-header">Perfil</th>
		</table>
			
		<form:form class="div_profile-form" method="post" action="updateProfile">
		 
				
				
				<label for="firstNameInput" class="signup_section-form-labels">Nombre</label>
				<p  class="div_profile-form-inputs" name="firstName" id="firstNameInput" >${it.info.name}  </p>
				
				<label for="lastNameInput" class="signup_section-form-labels">Apellido</label>
				<p  class="div_profile-form-inputs" name="lastName" id="firstNameInput" >${it.info.lastname}  </p>
				
				<label for="emailAddressInput" class="signup_section-form-labels">Email</label>
				<p  class="div_profile-form-inputs" name="firstName" id="firstNameInput" >${it.info.mail}  </p>
				
							
				
				<label for="birthdateInput" class="signup_section-form-labels">Fecha de Nacimiento</label>
				<p  class="div_profile-form-inputs" name="firstName" id="firstNameInput" >${it.info.birthdate}  </p>	
				
	
									
				<label for="phoneInput" class="signup_section-form-labels">Telefono</label>
				<p  class="div_profile-form-inputs" name="firstName" id="firstNameInput" >${it.info.phone}  </p>	
										
				<label for="countryInput" class="signup_section-form-labels">Pais</label>
				<p  class="div_profile-form-inputs" name="firstName" id="firstNameInput" >${it.info.country}  </p>
										
				<label for="interestInput" class="signup_section-form-labels">Rol</label>
				<c:choose>
							<c:when test="${it.roles_RoleId==1}">
							    <p  class="div_profile-form-inputs" name="firstName" id="firstNameInput" >Jugador  </p>
						    </c:when>  
						    <c:when test="${it.roles_RoleId==2}">
						    <p  class="div_profile-form-inputs" name="firstName" id="firstNameInput" >Donante  </p>
						    	
						    </c:when>  
						    <c:when test="${it.roles_RoleId==3}">
						   <p  class="div_profile-form-inputs" name="firstName" id="firstNameInput" >Beneficiario  </p>
						    	
						    </c:when> 
						    <c:when test="${it.roles_RoleId==4}">
						    <p  class="div_profile-form-inputs" name="firstName" id="firstNameInput" >Gestor de Campania  </p>
						    	
						    </c:when> 
						    <c:otherwise>
						    <p  class="div_profile-form-inputs" name="firstName" id="firstNameInput" >Administrador </p>
						        
						    </c:otherwise>
						</c:choose>
				
													
				<label for="roleInput" class="signup_section-form-labels">Interes</label>
				<c:choose>
							<c:when test="${it.interests_InterestId==1}">
							    <p  class="div_profile-form-inputs" name="firstName" id="firstNameInput" >Educativo  </p>
						    </c:when>  
						    <c:when test="${it.interests_InterestId==2}">
						    <p  class="div_profile-form-inputs" name="firstName" id="firstNameInput" >Cultural  </p>
						    	
						    </c:when>  
						
						    <c:otherwise>
						    <p  class="div_profile-form-inputs" name="firstName" id="firstNameInput" >Ambiental </p>
						        
						    </c:otherwise>
						</c:choose>
										
				
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