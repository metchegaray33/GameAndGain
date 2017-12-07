<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="../../assets/css/searchResult.css" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>
<!-- header -->
	<div class="navbar">
		<div class="access_menu">
			
		</div>
		<div class="logo_header">
			<a href="#">
				<img src="../../assets/img/logo.png" class="logo_title"> 
			</a>
		</div>
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-responsive-collapse">
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span>
			</button>
		</div>
		<div class="menu_bar">
			<a class="menu_bar-link" href="#">INICIO</a>
			<!-- <a class="menu_bar-link" href="webapi/adminResource/profile">MI PERFIL</a> -->
			<a class="menu_bar-link" href="webapi/adminResource/not_logged_in">JUGAR</a>
			<a class="menu_bar-link" href="webapi/adminResource/not_logged_in">RANKINGS</a>
			<form action="webapi/adminResource/searchResult" method="post">
				<input class="menu_bar-link search" type="text" name="seachW" placeholder="Buscar">
			</form>
		</div>
	</div>
	<c:forEach var="i" items="${it.word}">
			<div class="profile--section">
				<h2> ${i.name} ${i.lastname} </h2>
				<p style="display: none">${i.userId}</p>
				<img src="../../assets/img/pp.png" class="profilePic">
				<table class="profileInformation">
					<tr>
						<td>Email</td>
						<td>${i.mail}</td>
					</tr>
					<tr>
						<td>Puntos</td>
						<td>${i.points}</td>
					</tr>
					<tr>
						<td>Pais</td>
						<td>${i.country}</td>
					</tr>
					<tr>
						<td>Interes</td>
						<td>
						<c:choose>
							<c:when test="${i.interests_InterestId==1}">
						       Educativo
						    </c:when>  
						    <c:when test="${i.interests_InterestId==2}">
						    	Cultural
						    </c:when>  
						    <c:otherwise>
						        Ambiental
						    </c:otherwise>
						</c:choose>
						</td>
					</tr>
					<tr>
						<td>Rol</td>
						<td>
						<c:choose>
							<c:when test="${i.roles_RoleId==1}">
							    Jugador
						    </c:when>  
						    <c:when test="${i.roles_RoleId==2}">
						    	Donante
						    </c:when>  
						    <c:when test="${i.roles_RoleId==3}">
						    	Beneficiario
						    </c:when> 
						    <c:when test="${i.roles_RoleId==4}">
						    	Gestor de Campania
						    </c:when> 
						    <c:otherwise>
						        Administrador
						    </c:otherwise>
						</c:choose>
						</td>
					</tr>
				</table>
				<button class="profile--btn">Ver Perfil Completo</button>	   
			</div>
	 </c:forEach>
			
</body>
</html>