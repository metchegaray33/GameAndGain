<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="getCampaign" method="post">
		<input type="text" value="${it.campaign.campaign}" name="campaign" id = "campaignId" placeholder="Una campaña"/>
		<br>
		<input type="submit" value="Traer" id = "commentT"/>
	</form>

</body>
</html>