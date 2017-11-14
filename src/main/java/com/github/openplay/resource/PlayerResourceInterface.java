package com.github.openplay.resource;

import java.text.ParseException;

import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.mvc.Viewable;

public interface PlayerResourceInterface {
	public Response registerCampaign(String idUser, String idCampaign) throws ParseException;
	public Response registerCampaign();
	
}
