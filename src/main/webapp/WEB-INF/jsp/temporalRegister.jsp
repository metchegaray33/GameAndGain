<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="registerCampaignr" method="post">
		<input type="text" value="${it.campaigns_has_users.idUser}" name="idUser" id = "userId" placeholder="1"/>
		<input type="text" value="${it.campaigns_has_users.idCampaign}" name="idCamapaign" id = "campaignId" placeholder="2"/>
		<br>
		<input type="submit" value="register" id = "comment"/>
	</form>
	
</body>
</html>