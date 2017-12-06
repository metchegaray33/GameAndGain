<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	@font-face {
	font-family: quickMedium;
	src: url("../../assets/css/fonts/Quicksand-Medium.ttf");
	}
	@font-face{
	font-family: quickBold;
	src: url("../../assets/css/fonts/Quicksand-Bold.ttf");
}
	
	.comment {
		margin:auto;
		width: 40%;
		position: relative;
	}
	.comment-textarea {
		display: inline-block;
		postition: absolute;
		width:100%;
		height: 90px;
		resize: none;
		padding: 5px;
		-webkit-box-sizing: border-box;
       	-moz-box-sizing: border-box;
        box-sizing: border-box;
        resize: none;
        margin:0;
        font-family: quickMedium;
	}
	.comment-submit {
		display:block;
		width: 100%;
		height: 30px;
		margin:0;
		background-color:#f1ed8c;
		color:white;
		font-family:quickBold;
		border: none;
		font-size:16px;
		cursor:pointer;
		
	}
	
	.comment-submit:hover {
		background-color:#d8d47c;
	}
	
	.comment-list{
		list-style-type: none;
		background-color:#f1ed8c;
		border-radius:5px;
		padding:5px;
	}
	
	.comment-list-element{
		font-family: quickMedium;
		border-bottom: 1px solid black;
		
	}
	
	.comment-list-element--date{
		color: #565656;
	}
	 
	
</style>
</head>
<body>
	<section class="comment">
		<form action="temporalComment" method="post">
			<input type="text" value="${it.comment.users_UserIdFrom}" name="users_UserIdFrom" id = "userIdFrom" placeholder="1"/>
			<input type="text" value="${it.comment.users_UserIdTo}" name="users_UserIdTo" id = "userIdTo" placeholder="2"/>
			<input type="text" value="${it.comment.date}" name="date" id = "date" placeholder="31/10/17"/>
			<textarea class="comment-textarea" id="txtComment" value="${it.comment.comment}" name="comment"rows="120" ></textarea>
			<br>
			<input type="submit" value="COMMENT" id = "comment" class="comment-submit"/>
		</form>
		
		<form action="temporalGetComment" method="post">
			<input type="text" value="${it.comment.users_UserIdTo}" name="users_UserIdTo" id = "userIdToT" placeholder="2"/>
			<br>
			<input type="submit" value="Traer" id = "commentT" />
		</form>
		<c:if test="${not empty it.list}">
			<ul class="comment-list">
		    <c:forEach items="${it.list}" var="list">
		    	<li class="comment-list-element">
		    		<p class="comment-list-element--date">${list.date}</p>
	       			<p>${list.comment}</p>
	       		</li>
			</c:forEach>
			</ul>
		</c:if>
	</section>
</body>
</html>
