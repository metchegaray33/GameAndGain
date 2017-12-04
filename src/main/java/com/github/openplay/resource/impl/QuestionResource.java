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

import com.github.openplay.model.impl.Question;
import com.github.openplay.service.QuestionService;


@Component
@Path("questionResource")
@XmlRootElement
public class QuestionResource {
	
	@Autowired
	public QuestionService questionServImpl;
	
	@POST
	@Path("create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void createQuestion(@RequestBody Question Question){
		questionServImpl.createQuestion(Question);
	}
	
	@GET @Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Question getQuestion(@PathParam("id") int id){
		Question Question= questionServImpl.getQuestion(id);
		return Question;
	}
	
	@GET @Path("list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Question> getAllQuestions(){
		return questionServImpl.getAllQuestion();
	}
	
	
	@PUT @Path("update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void editQuestion(@RequestBody Question question){
		questionServImpl.editQuestion(question);
	}
	
	
	@DELETE @Path("delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteQuestion(@PathParam("id") int id){
		questionServImpl.deleteQuestion(id);
	}
}
