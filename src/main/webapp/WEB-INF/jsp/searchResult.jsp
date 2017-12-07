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
			
			    <table class="profile--table">
					<th class="profile--title--header"> ${i.name} ${i.lastname}</th>
				</table>
				<br>
				<label for="emailAddress" class="login_section-form-labels">Email</label>
			    <p class="profile--info">${i.mail}</p>
			    <label for="emailAddress" class="login_section-form-labels">Puntos</label>
			    <p class="profile--info">${i.points}</p>
			    <label for="emailAddress" class="login_section-form-labels">Interes</label>
			    
			    <c:choose>
				<c:when test="${i.interests_InterestId==1}">
				       <p class="profile--info">Educativo</p> 
				        
				    </c:when>  
				    <c:when test="${i.interests_InterestId==2}">
				    <p class="profile--info">Cultural</p>
				    </c:when>  
				    <c:otherwise>
				        <p class="profile--info">Ambiental</p> 
				       
				    </c:otherwise>
				</c:choose>
			    <label for="emailAddress" class="login_section-form-labels">Rol</label>
			    
			     <c:choose>
				<c:when test="${i.roles_RoleId==1}">
				       <p class="profile--info">Jugador</p> 
				        
				    </c:when>  
				    <c:when test="${i.roles_RoleId==2}">
				    <p class="profile--info">Donante</p>
				    </c:when>  
				    <c:when test="${i.roles_RoleId==3}">
				    <p class="profile--info">Beneficiario</p>
				    </c:when> 
				    <c:when test="${i.roles_RoleId==4}">
				    <p class="profile--info">Gestor de Campania</p>
				    </c:when> 
				    
				    <c:otherwise>
				        <p class="profile--info">Administrador</p> 
				       
				    </c:otherwise>
				</c:choose>
			    <label for="emailAddress" class="login_section-form-labels">Pais</label>
			    <p class="profile--info">${i.country}</p>
			       
			
			   
	</div>
	 </c:forEach>
			    
			    <!-- End of table -->
			
</body>
</html>