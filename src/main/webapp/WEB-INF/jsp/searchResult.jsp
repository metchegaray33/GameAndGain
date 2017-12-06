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
			<a class="access_menu-link" href="webapi/adminResource/signup">Registrarse</a>
			<a class="access_menu-link" href="webapi/adminResource/login">Iniciar Sesión</a>
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
			<div class="table">
			    <div class="row header">
			     
			      <div class="cell">
			        Nombre
			      </div>
			      <div class="cell">
			        Apellido
			      </div>
			    </div>
			    <c:forEach var="i" items="${it.word}">
			    <div class="row">
			      <div class="cell">
			        ${i.name}
			      </div>
			      <div class="cell">
			        ${i.lastname}
			      </div>
			    </div>
			    </c:forEach>
			    
			    <!-- End of table -->
			 </div>
</body>
</html>