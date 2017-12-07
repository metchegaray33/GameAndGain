<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="../../assets/css/bootstrap-united.css" rel="stylesheet" />
	<link href="../../bootstrap/css/bootstrap-responsive.css" rel="stylesheet" />
	<link href="../../assets/css/badges.css" rel="stylesheet" />
	<link rel="stylesheet" href="../../assets/css/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
	<title>Administrar Insignia</title>
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
			<a class="menu_bar-link" href="../../">INICIO</a>
			<a class="menu_bar-link" href="./profile">MI PERFIL</a>
			<a class="menu_bar-link" href="#">RANKINGS</a>
			<a class="menu_bar-link" href="#" onclick="contentMenu()"><i class="fa fa-bars fa-inverse bars " aria-hidden="true"></i></a>
			<div class="dropdown">
				  <div id="myDropdown" class="dropdown-content">
				    <a href="#">Administrar Insignias</a>
				    <a href="../../.">Cerrar Sesion</a>
				  </div>
			</div>
			<input class="menu_bar-link search" type="text" name="searchIn" placeholder="Buscar">
		</div>
		<!-- /.nav-collapse -->
	</div>
	
	<section class="badges-btns">
		<table class="badges-btns--title">
				<th class="badges-btns--title--header">Administrar Insignias</th>
		</table>
		<button class="badge-btns--btn" onclick="showCreateForm()">Crea una Insignia</button>
		<div id="creatBadge-form">
			<form id="create-badge--form" action="createBadge" method="post">
		        <h2>Nombre</h2>
		        <input type="text" name="badgeName" value="${it.badges.badgeName}">
		        <h2>Valor</h2>
		        <label for="range">
				      <input type="range" name="badgeValue" id="range" min="20" max="100" step="5"  value="${it.badges.badgeValue}"/>
				</label>
		        <output for="range" class="output"></output>
		        <input type="submit" class="submit-badge--btn" name="submitBadge" value="Crear Insignia!">
		    </form>
		</div>
		<button class="badge-btns--btn" onclick="showBadgesTable()">Modifica Insignias</button>
		<form id="create-badge--form" action="updateBadge" method="post">
		<div id="badgesTable">
			<div class="table">
			    <div class="row header">
			      <div class="cell">
			        ID
			      </div>
			      <div class="cell">
			        Nombre
			      </div>
			      <div class="cell">
			        Valor
			      </div>
			    </div>
			    <c:forEach var="i" items="${it.word}">
			    <div class="row">
			      <div class="cell">
			        ${i.badgeId}
			      </div>
			      <div class="cell">
			        <input type="text" name="badgeName" value="${i.name}"/>
			   
			      </div>
			      <div class="cell">
			        <label for="range">
					      <input type="range" name="badgeValue" id="range" min="20" max="100" step="5" value="${i.value}" />
					</label>
			      </div>
			    </div>
			    </c:forEach>
			    
			    <!-- End of table -->
			  </div>
			  
			  <input type="submit" class="submit-badge--btn" name="updateBadge" value="Realizar Cambios">
		</div>
		</form>
		<button class="badge-btns--btn" onclick="showBagdesTableForDeleting()">Elimina Insignias</button>
		<div id="badgesTable-delete">
			<div class="table">
			    <div class="row header">
			      <div class="cell">
			        ID
			      </div>
			      <div class="cell">
			        Nombre
			      </div>
			      <div class="cell">
			        Valor
			      </div>
			    </div>
			     <c:forEach var="e" items="${it.word}">
			    <div class="row">
			      <div class="cell">
			        <input type="radio">
			      </div>
			      <div class="cell">
			       ${e.name}
			      </div>
			      <div class="cell">
			        <label for="range">
					      ${e.value}
					</label>
			      </div>
			    </div>
			    </c:forEach>  
			  </div> <!-- End of table  -->
			  <input type="submit" class="submit-badge--btn" name="delete_updateBadge" value="Eliminar">
		</div>
			<%-- <form action="deleteBadge" id="delete-badge--form"  method="post">
		    	<h2>ID</h2>
		        <input type="text" name="delete_badgeId" value="${it.badges.update_badgeId}">
		        <input type="submit" name="delete_updateBadge">
		    </form> --%>
	</section>
	
	
	<!-- Create Badge
    <form action="createBadge" method="post">
        <h2>Nombre</h2>
        <input type="text" name="badgeName" value="${it.badges.badgeName}">
        <h2>Valor</h2>
        <label for="range">
		      <input type="range" name="badgeValue" id="range" min="20" max="100" step="5"  value="${it.badges.badgeValue}"/>
		</label>
        <%-- <input type="range" name="badgeValue" value="${it.badges.badgeValue}" min="0" max="10" >  --%>
        <output for="range" class="output"></output>
        <input type="submit" name="submitBadge">
    </form>
     -->
    
    <%-- Get Badges
    <form action="showBadges" method="get">
    	<input type="submit" name="createBadge" label="editar Insignias" onclick="showTable('table1')">
    </form> --%>
    
    <!-- Update Badge
    <form action="updateBadge" method="post">
    	<h2>ID</h2>
        <input type="text" name="update_badgeId" value="${it.badges.update_badgeId}">
        <h2>Nombre</h2>
        <input type="text" name="update_badgeName" value="${it.badges.update_badgeName}">
        <h2>Valor</h2>
        <label for="range">
		      <input type="range" name="update_badgeValue" id="range" min="20" max="100" step="5"  value="${it.badges.update_badgeValue}"/>
		</label>
        <%-- <input type="range" name="badgeValue" value="${it.badges.badgeValue}" min="0" max="10" >  --%>
        <output for="range" class="output"></output>
        <input type="submit" name="submit_updateBadge">
    </form> -->

    <!-- Delete Badge -->
    <!--<form action="deleteBadge" method="post">
    	<h2>ID</h2>
        <input type="text" name="delete_badgeId" value="${it.badges.update_badgeId}">
        <input type="submit" name="delete_updateBadge">
    </form>-->
		
		
	<!-- <div class="buttons-div">
	    <button class="buttons" onclick="showCreateForm()" >Create Badge</button>
	    <form action="createBadge" method="post" class="badges-form" id="creatBadge-form">
	        <h2 class="form-inputs">Nombre</h2>
	        <input type="text" name="badgeName" value="${it.badges.badgeName}">
	        <h2 class="form-inputs">Valor</h2>
	        <label for="range">
			      <input type="range" name="badgeValue" id="range" min="20" max="100" step="5"  value="${it.badges.badgeValue}"/>
			</label>
	        <%-- <input type="range" name="badgeValue" value="${it.badges.badgeValue}" min="0" max="10" >  --%>
	        <output for="range" class="output"></output>
	        <input type="submit" name="submitBadge" value="Enviar" class="buttons">
	    </form>
	    
	   
	    	<spring:url value="#" var="badgeListUrl" htmlEscape="true" />
       		 <a href="${badgeListUrl}" name="viewBadges"  class="buttons"  >Ver Insignias</a>
	    	
	            <table class="badges-table" id="badgesTable">
	             <tr>
	                <th class="badges-table-header">Nombre</th>
	                
	                <th class="badges-table-header">Valor</th>  
	                 
	             </tr>
	             <c:forEach var="i" items="${badge}" varStatus="loopCounter">
	             <tr>
	         
	            	 <td><c:out value="${loopCounter.count}" />hry</td>
	            	 <td><c:out value="${i.badgeName}" />hey</td>
	            	 <td><c:out value="${i.badgeValue}" /></td>
					
	             </tr>
	             </c:forEach>           
	            </table>
	           
	   

   

	    
	
	    <button class="buttons">Delete Badge</button>
	  </div>-->
	
	
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
    
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
	
    <script type="text/javascript" src = "../../assets/js/badges.js"></script>
</body>

</html>
