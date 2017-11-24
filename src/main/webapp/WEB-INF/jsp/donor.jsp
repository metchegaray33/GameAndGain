<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../../assets/css/bootstrap-united.css" rel="stylesheet" />
<link href="../../bootstrap/css/bootstrap-responsive.css" rel="stylesheet" />
<link href="../../assets/css/donor.css" rel="stylesheet" />
<link rel="stylesheet" href="../../assets/css/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
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
			<a class="menu_bar-link" href="#">INICIO</a>
			<a class="menu_bar-link" href="./profile">MI PERFIL</a>
			
			<a class="menu_bar-link" href="#">RANKINGS</a>
			<a class="menu_bar-link" href="#" onclick="contentMenu()"><i class="fa fa-bars fa-inverse bars " aria-hidden="true"></i></a>
			<div class="dropdown">
				  <div id="myDropdown" class="dropdown-content">
				    <a href="#home">Ver mis Campa�as</a>
				    <a href="#about">Mis Beneficiarios</a>
				    <a href="../../.">Cerrar Sesion</a>
				  </div>
			</div>
			<input class="menu_bar-link search" type="text" name="searchIn" placeholder="Buscar">
		</div>
		<!-- /.nav-collapse -->
	</div>
	<section class="games_section">	
			<table class="games_section-table">
				<tr class="games_section-table-row">
					<th class="games_section-table-header">RECIENTES</th>
					<th class="games_section-table-header">HOT</th>
				</tr>
				<tr class="games_section-table-row">
					<td class="games_section-table-col">
						
					</td>
					<td class="games_section-table-col">
						
					</td>
				</tr>
				
			</table>
	</section>
	
	
	<section class="collaborators_section">	
			<table class="collaborators_section-table">
				<th class="collaborators_section-table-header">COLABORADORES</th>
				<tr class="footer-table-row">
					<td class="footer-table-col">
						<div id="slideshow">
		  					 <div >
		   		 				<img src="../../assets/img/mc.jpg" class="slider-imgs">
		   					</div>
		   					<div>
		    					<img src="../../assets/img/bel.jpg" class="slider-imgs">
		    				</div>
		   					<div>
		     					<img src="../../assets/img/google.jpg" class="slider-imgs">
		   					</div>
						</div>
						<div >
							
						</div>
						<div id="slideshow-bene">
		  					 <div >
		   		 				<img src="../../assets/img/smile.jpg" class="slider-imgs">
		   					</div>
		   					<div>
		    					<img src="../../assets/img/fundaleu.jpg" class="slider-imgs">
		    				</div>
		   					<div>
		     					<img src="../../assets/img/garrahan.png" class="slider-imgs">
		   					</div>
						</div>
						<div class="paper">
								
							<img src="../../assets/img/paper.png" >
							<p class="paper-text">Ya se sumaron millones de donantes y beneficiarios a la causa</p>
						</div>
						<div class="arrow"> 

						</div>
						<div class="paper-2">
								
							<img src="../../assets/img/paper2.png" >
							<p class="paper-text-2">�Que estas esperando?<br>
								JUGA por una buena causa</p>
							
						</div>
					</td>
				</tr>
				
			</table>
	</section>
	
	<footer class="footer">
		<img src="../../assets/img/gg.png" class="footer-img">
		<p class="footer-paragraph">2017 � puto el que copia</p>
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
	<script src="../../jquery-1.8.3.js">
		
	</script>

	<script src="../../bootstrap/js/bootstrap.js">
		
	</script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
	<script type="text/javascript" src = "../../assets/js/index.js"></script>

</body>
</html>
