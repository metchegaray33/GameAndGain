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
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.github.openplay.model.impl.Mission;
import com.github.openplay.service.MissionService;


@Component
@Path("missionResource")
@XmlRootElement
public class MissionResource {
	@Autowired
	public MissionService missionServImpl;
	
	@POST
	@Path("create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void createMission(@RequestBody Mission mission){
		missionServImpl.createMission(mission);
	}
	
	@GET @Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Mission getMission(@PathParam("id") int id){
		Mission mission= missionServImpl.getMission(id);
		return mission;
	}
	
	@GET @Path("list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Mission> getAllMissions(){
		return missionServImpl.getAllMissions();
	}
	
	
	@PUT @Path("update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void editMission(@RequestBody Mission mission){
		missionServImpl.editMission(mission);
	}
	
	
	@DELETE @Path("delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteMission(@PathParam("id") int id){
		missionServImpl.deleteMission(id);
	}
}