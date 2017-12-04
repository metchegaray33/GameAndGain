package com.github.openplay.resource.impl;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.stereotype.Component;
import com.github.openplay.service.CampaignService;
import com.github.openplay.model.impl.Campaign;

@Component
@Path("campaignResource")
@XmlRootElement
public class CampaignResource {
	
	@Autowired
	public CampaignService campaignServImpl;
	
	@POST
	@Path("create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void createCampaign(@RequestBody Campaign campaign){
		campaignServImpl.createCampaign(campaign);
	}
	
	@GET @Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Campaign getCampaginById(@PathParam("id") int id){
		Campaign campaign= campaignServImpl.getCampaign(id);
		return campaign;
	}
	
	@GET @Path("list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Campaign> getAllCampaigns(){
		return campaignServImpl.getAllCampaigns();
	}
	
	
	@PUT @Path("update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void editCampaign(@RequestBody Campaign campaign){
		campaignServImpl.editCampaign(campaign);
	}
	
	
	@DELETE @Path("delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteCampaign(@PathParam("id") int id){
		campaignServImpl.deleteCampaign(id);
	}

}
