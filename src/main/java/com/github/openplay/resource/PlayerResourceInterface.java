package com.github.openplay.resource;

import java.text.ParseException;

import javax.ws.rs.core.Response;

public interface PlayerResourceInterface {
	public Response registerCampaign(String idUser, String idCampaign) throws ParseException;
	public Response registerCampaign();

	public Response userBadges();
	public Response userBadges(String idUser, String idBadge, Integer value) throws ParseException;
	
//	public Response updateScore();
//	public Response updateScore(Integer campaigns_Score) throws ParseException;
}
