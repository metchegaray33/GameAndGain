package com.github.openplay.resource.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

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
import com.github.openplay.model.impl.CampaignsHasUsers;
import com.github.openplay.model.impl.Comment;
import com.github.openplay.model.impl.UsersReceivesBadges;
import com.github.openplay.service.CommentService;
import com.github.openplay.service.RankingService;


@Component
@Path("rankingResource")
@XmlRootElement
public class RankingResource {
	
	@Autowired
	private RankingService rankingService;
	
	@GET
	@Path("getRanking")
	@Produces(MediaType.TEXT_HTML)
	public Response getRanking() {
		return Response.ok(new Viewable("/ranking")).build();
	}
	
	@POST
	@Path("getRanking")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public Response getRanking(@FormParam("name") String name)
			throws ParseException {

		if (name == null) {
			return Response.status(Status.PRECONDITION_FAILED).build();
		}
		
		List<UsersReceivesBadges> userBadges = rankingService.getBadge(name);
		List<CampaignsHasUsers> scoresR = rankingService.getRanking(name);
		int scoreGeneral = 0;
		int scoreBagdes = 0;
		int badgeId = 0;
		Badge badge = null;
		
		for (int i=0; i<userBadges.size(); i++){
			scoreBagdes = scoreBagdes + userBadges.get(i).getValue();
			badgeId = userBadges.get(i).getBadges_BadgeId();
			badge = rankingService.getBadgesName(badgeId);
			System.out.println("Una insignia es: " + badge.getName());
			System.out.println("Su imagen es: " + badge.getIcon());
		}
		
		for (int i=0; i<scoresR.size(); i++){
			scoreGeneral = scoreGeneral + scoresR.get(i).getCampaigns_Score();
		}
		
		System.out.println("El scores general de " + name + " es: " + scoreGeneral);
		System.out.println("El scores de los trofeos es: " + scoreBagdes);

		return Response.ok().entity(new Viewable("/ranking")).build();
	}

}
