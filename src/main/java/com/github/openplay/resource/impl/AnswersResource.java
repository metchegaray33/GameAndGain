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

import com.github.openplay.model.impl.Answers;
import com.github.openplay.service.AnswersService;



@Component
@Path("answersResource")
@XmlRootElement
public class AnswersResource {
	@Autowired
	public AnswersService AnswersServImpl;
	
	@POST
	@Path("create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void createAnswers(@RequestBody Answers answers){
		AnswersServImpl.createAnswers(answers);
	}
	
	@GET @Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Answers getAnswers(@PathParam("id") int id){
		Answers Answers= AnswersServImpl.getAnswers(id);
		return Answers;
	}
	
	@GET @Path("list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Answers> getAllAnswerss(){
		return AnswersServImpl.getAllAnswers();
	}
	
	
	@PUT @Path("update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void editAnswers(@RequestBody Answers answers){
		AnswersServImpl.editAnswers(answers);
	}
	
	
	@DELETE @Path("delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteAnswers(@PathParam("id") int id){
		AnswersServImpl.deleteAnswers(id);
	}
}
