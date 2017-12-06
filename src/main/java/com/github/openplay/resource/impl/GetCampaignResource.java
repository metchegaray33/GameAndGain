package com.github.openplay.resource.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

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

import com.github.openplay.model.impl.Campaign;
import com.github.openplay.model.impl.CampaignStates;
import com.github.openplay.resource.GetCampaignResourceInterface;
import com.github.openplay.service.CommentService;
import com.github.openplay.service.GetCampaignService;

@Component
@Path("getCampaignResource")
@XmlRootElement
public class GetCampaignResource implements GetCampaignResourceInterface{
	
	@Autowired
	private GetCampaignService getCampaignService; 
	
	@GET
	@Path("getCampaign")
	@Produces(MediaType.TEXT_HTML)
	public Response getCampaign() {
		return Response.ok(new Viewable("/campaign")).build();
	}
	
	@POST
	@Path("getCampaign")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public Response getCampaign(@FormParam("campaign") String campaign)
			throws ParseException {
		
		Map<String, Object> map = new HashMap<String, Object>();
		Campaign cValues = getCampaignService.getCampaignId(campaign);
		
		map.put("campaignData", cValues);

		if (campaign == null) {
			return Response.status(Status.PRECONDITION_FAILED).build();
		}
		return Response.ok().entity(new Viewable("/campaign", map)).build();
	}
}
