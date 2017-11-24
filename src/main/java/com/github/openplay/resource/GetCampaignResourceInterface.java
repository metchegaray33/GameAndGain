package com.github.openplay.resource;

import java.text.ParseException;

import javax.ws.rs.core.Response;

public interface GetCampaignResourceInterface {

	public Response getCampaign();
	public Response getCampaign(String campaign)throws ParseException;
}
