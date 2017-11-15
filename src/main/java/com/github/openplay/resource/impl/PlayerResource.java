package com.github.openplay.resource.impl;

import java.text.ParseException;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.xml.bind.annotation.XmlRootElement;

import org.glassfish.jersey.server.mvc.Viewable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.openplay.model.impl.Badge;
import com.github.openplay.model.impl.Campaign;
import com.github.openplay.model.impl.CampaignsHasUsers;
import com.github.openplay.model.impl.User;
import com.github.openplay.model.impl.UsersReceivesBadges;
import com.github.openplay.resource.PlayerResourceInterface;
import com.github.openplay.service.PlayerService;

@Component
@Path("playerResource")
@XmlRootElement
public class PlayerResource implements PlayerResourceInterface{

	@Autowired
	private PlayerService playerService; 
	
	@GET
	@Path("registerCampaign")
	@Produces(MediaType.TEXT_HTML)
	public Response registerCampaign() {
		return Response.ok(new Viewable("/temporalRegister")).build();
	}
	
	@POST
	@Path("registerCampaign")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public Response registerCampaign(
			@FormParam("idUser") String idUser ,
			@FormParam("idCampaign") String idCampaign)
			throws ParseException {

		if (idUser == null || idCampaign == null ) {
			return Response.status(Status.PRECONDITION_FAILED).build();
		}
		
		Integer idUserint = Integer.parseInt (idUser);
		Integer idCampaingInt = Integer.parseInt(idCampaign);
		
		Campaign campaign = new Campaign();
		campaign.setId(idCampaingInt.intValue());
		
		User user = new User();
		user.setUserId(idUserint.intValue());
		
		CampaignsHasUsers campaignsHasUsers = new CampaignsHasUsers();
		campaignsHasUsers.setCampaign(campaign);
		campaignsHasUsers.setUser(user);
		
		playerService.save(campaignsHasUsers);
		
		return Response.ok().entity(new Viewable("/login")).build();
	}
	
	@GET
	@Path("userBadges")
	@Produces(MediaType.TEXT_HTML)
	public Response userBadges() {
		return Response.ok(new Viewable("/temporalBadgeUser")).build();
	}
	
	@POST
	@Path("userBadges")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public Response userBadges(
			@FormParam("idUser") String idUser ,
			@FormParam("idBadge") String idBadge,
			@FormParam("value")Integer value)
			throws ParseException {

		if (idUser == null || idBadge == null || value == null) {
			return Response.status(Status.PRECONDITION_FAILED).build();
		}
		
		Integer idUserint = Integer.parseInt (idUser);
		Integer idBadgeInt = Integer.parseInt(idBadge);
		
		Badge badge = new Badge();
		badge.setBadgeId(idBadgeInt.intValue());
		
		User user = new User();
		user.setUserId(idUserint.intValue());
		
		UsersReceivesBadges usersReceivesBadges = new UsersReceivesBadges();
		usersReceivesBadges.setBadge(badge);
		usersReceivesBadges.setUser(user);
		usersReceivesBadges.setValue(value);
		
		playerService.save(usersReceivesBadges);
		
		return Response.ok().entity(new Viewable("/temporalBadgeUser")).build();
	}
	
//	@GET
//	@Path("updateScore")
//	@Produces(MediaType.TEXT_HTML)
//	public Response updateScore() {
//		return Response.ok(new Viewable("/temporalUpdateScore")).build();
//	}
//	
//	@POST
//	@Path("updateScore")
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	@Produces(MediaType.TEXT_HTML)
//	public Response updateScore(
//			@FormParam("campaigns_Score") Integer campaigns_Score)
//			throws ParseException {
//
//		if (campaigns_Score == null) {
//			return Response.status(Status.PRECONDITION_FAILED).build();
//		}
//		
//		CampaignsHasUsers campaignsHasUsers = new CampaignsHasUsers();
//		campaignsHasUsers.setCampaigns_Score(campaigns_Score);
//		
//		playerService.save(campaignsHasUsers);
//		
//		return Response.ok().entity(new Viewable("/temporalUpdateScore")).build();
//	}
}
