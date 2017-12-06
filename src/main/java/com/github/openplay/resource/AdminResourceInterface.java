package com.github.openplay.resource;

import java.text.ParseException;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.core.Response;

import com.github.openplay.model.impl.Badge;

public interface AdminResourceInterface {
	
	//NOT LOGGED IN ERROR VIEWABLE

	public Response notLoggedIn();
	
	//SIGNUP
	
	public Response signup();

	public Response signup(String emailAddress, String password, String firstName, String lastName,
							String birthdate, String phone, String country, String interest, 
							String role) throws ParseException;

	//LOGIN
	
	public Response login();
	
	public Response login(String userName, String password);
	
	//COMMENTS
	
	public Response createComment();
	
	public Response createComment(String users_UserIdFrom, String users_UserIdTo, String date, 
									String comment)throws ParseException;
	
	//PROFILE
	
	public Response profile();
	
	public Response showUser(int id);
	
	public Response showSearchResult(String search);
	
	public Response getProfile(String userId) throws ParseException;
	
	public Response updateProfile(String userId, String emailAddress, String password, String firstName, 
								String lastName, String birthdate, String phone, String country, 
								String interest, String role) throws ParseException;
	
	//BADGES
	
	public Response badges();
	
	public Response createBadge(String badgeName, String badgeValue) throws ParseException;
	
	public Response deleteBadge(String badgeId) throws ParseException;

	public Response showBadges();
	
	

	public Response updateBadge(String badgeName, String badgeValue) throws ParseException;
	
	
}

