<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Campañas</title>
	<link href="../../bootstrap/css/bootstrap.css" rel="stylesheet" />
	<link href="../../datepicker/css/datepicker.css" rel="stylesheet" />
	<link href="../../assets/css/bootstrap-united.css" rel="stylesheet" />
	<link href="../../assets/css/signup.css" rel="stylesheet" />
	<style>
.green {
	font-weight: bold;
	color: green;
}

.message {
	margin-bottom: 10px;
}

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

.lblpadding {
	padding: 10px;
}

.centpadding {
	padding: 50px;
}

.results{
	padding:0 50px;
	color: #ce5f5f;
	font-weight:bold;
}
#new_signup{
	height:initial;
}
</style>
</head>
<body>
<div class="navbar">
	<div class="logo_header">
			<section class="logo_title"></section>
		</div>
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-responsive-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>
		<div class="menu_bar">
			<a href="../../" class="menu_bar-link">INICIO</a>
			<a href="#" class="menu_bar-link">MI PERFIL</a>
			<a href="#" class="menu_bar-link">JUGAR</a>
			<a href="#" class="menu_bar-link">RANKINGS</a>
			<input class="menu_bar-link search" type="text" name="searchIn" placeholder="Buscar">
		</div>
		<!-- /.nav-collapse -->
	</div>
	<script src="../../jquery-1.8.3.js"></script>
	<script src="../../bootstrap/js/bootstrap.js"></script>
	<script src="../../datepicker/js/bootstrap-datepicker.js"></script>
	
	<section id="new_signup" class="signup_section">
		<table class="signup_section-table">
				<th class="signup_section-table-header">Campaña</th>
		</table>
	
		<form action="getCampaign" method="post">
			<label class="signup_section-form-labels centpadding">Campaña</label>
			<input type="text" class="signup_section-form-inputs" value="${it.campaign.campaign}" name="campaign" id = "campaignId" placeholder="Nombre de la campaña"/>
			<input type="submit" value="Traer" id="commentT" class="btn btn-primary signup_section-form-btns lblpadding">
			<p><label class="signup_section-form-labels centpadding">Nombre</label></p>
			<p class="signup_section-form-labels results">${it.campaignData.name}</p>
			<p><label class="signup_section-form-labels centpadding">Puntaje Máximo</label></p>
			<p class="signup_section-form-labels results">${it.campaignData.maxScore}</p>
			<p><label class="signup_section-form-labels centpadding">Empieza</label></p>
			<p class="signup_section-form-labels results">${it.campaignData.startDate}</p>
			<p><label class="signup_section-form-labels centpadding">Termina</label></p>
			<p class="signup_section-form-labels results">${it.campaignData.endDate}</p>
			<p><label class="signup_section-form-labels centpadding">Estado</label></p>
			<p class="signup_section-form-labels results">${it.campaignData.campaignState.description}</p>
			<p><label class="signup_section-form-labels centpadding">Tipo de Campaña</label></p>
			<p class="signup_section-form-labels results">${it.campaignData.campaignType.description}</p>
			<p><label class="signup_section-form-labels centpadding">Interés en</label></p>
			<p class="signup_section-form-labels results">${it.campaignData.interest.description}</p>
		</form>
	</section>
	
	
<footer class="footer">
	<img src="../../assets/img/gg.png" class="footer-img">
	<p class="footer-paragraph">2017 Â© Universidad de Belgrano</p>
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