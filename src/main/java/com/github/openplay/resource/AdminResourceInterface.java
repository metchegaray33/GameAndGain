package com.github.openplay.resource;

import java.text.ParseException;

import javax.ws.rs.core.Response;

public interface AdminResourceInterface {

	public Response signup();

	public Response signup(String emailAddress, String password, String firstName, String lastName,
			String birthdate, String phone, String country, String interest, String role)
			throws ParseException;

	public Response login();

	public Response login(String userName, String password);
}


