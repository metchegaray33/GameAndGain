package com.github.openplay.resource.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.xml.bind.annotation.XmlRootElement;

import org.glassfish.jersey.server.mvc.Viewable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.openplay.model.impl.Badge;
import com.github.openplay.model.impl.Comment;
import com.github.openplay.model.impl.User;
import com.github.openplay.resource.AdminResourceInterface;
import com.github.openplay.service.AdminService;

@Component
@Path("adminResource")
@XmlRootElement
public class AdminResource implements AdminResourceInterface {

	@Autowired
	private AdminService adminService; //reemplazar por el tag que se encuentra en AdminServiceImple : @Service("adminService")
	
	//GET PAGE WHEN NOT LOGGED IN ERROR
	@GET
	@Path("not_logged_in")
	@Produces(MediaType.TEXT_HTML)
	public Response notLoggedIn() {
		return Response.ok(new Viewable("/notLoggedIn")).build();
	}

	//GET SIGNUP
	@GET
	@Path("signup")
	@Produces(MediaType.TEXT_HTML)
	public Response signup() {
		return Response.ok(new Viewable("/signup")).build();
	}
	
	//POST SIGNUP
	@POST
	@Path("signup")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public Response signup(@FormParam("emailAddress") String emailAddress,
			@FormParam("password") String password,
			@FormParam("firstName") String firstName,
			@FormParam("lastName") String lastName,
			@FormParam("birthdate") String birthdate,
			@FormParam("phone") String phone,
			@FormParam("country") String country,
			@FormParam("interest") String interest,
			@FormParam("role") String role 
			)
			throws ParseException {

		if (emailAddress == null || password == null || firstName == null
				|| lastName == null || birthdate == null
				|| phone == null || country == null) {
			return Response.status(Status.PRECONDITION_FAILED).build();
		}

		User user = new User();
		user.setPassword(password);
		user.setName(firstName);
		user.setLastname(lastName);
		user.setMail(emailAddress);
		user.setPhone(phone);
		user.setCountry(country);
		user.setInterests_InterestId(Integer.parseInt(interest));
		user.setRoles_RoleId(Integer.parseInt(role));
		user.setBirthdate(new java.sql.Date(new SimpleDateFormat("MM/dd/yyyy").parse(birthdate).getTime()));


		if (adminService.findByUserName(emailAddress)) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", "User Name exists. Try another user name");
			map.put("student", user);
			return Response.status(Status.BAD_REQUEST)
					.entity(new Viewable("/signup", map)).build();
		} else {
			adminService.save(user);
			return Response.ok().entity(new Viewable("/login")).build();
		}
	}
	
	//GET LOGIN
	@GET
	@Path("login")
	@Produces(MediaType.TEXT_HTML)
	public Response login() {
		return Response.ok(new Viewable("/login")).build();
	}

	//POST LOGIN
	@POST
	@Path("login")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public Response login(@FormParam("emailAddress") String emailAddress, @FormParam("password") String password) {

		if (emailAddress == null || password == null) {
			return Response.status(Status.PRECONDITION_FAILED).build();
		}

		boolean found = adminService.findByLogin(emailAddress, password);
		if (found) {
			int valor = adminService.findByUserRoleId(emailAddress);
			
			if (valor==1){
				return Response.ok().entity(new Viewable("/success")).build();
			}else if(valor==2){
				return Response.ok().entity(new Viewable("/donor")).build();
			}else if(valor==3){
				return Response.ok().entity(new Viewable("/beneficiary")).build();
			}else if(valor==4){
				return Response.ok().entity(new Viewable("/campaign_manager")).build();
			}else if(valor==5){
				return Response.ok().entity(new Viewable("/admin")).build();
			}else {
				return Response.status(Status.BAD_REQUEST).entity(new Viewable("/failure")).build();
			}
			}else {
				return Response.status(Status.BAD_REQUEST).entity(new Viewable("/failure")).build();
			}
	}
	
	//GET COMMENT (TEMPORAL, BLUE TEAM)
	@GET
	@Path("temporalComment")
	@Produces(MediaType.TEXT_HTML)
	public Response createComment() {
		return Response.ok(new Viewable("/TemporalComment")).build();
	}
	
	//POST COMMENT (TEMPORAL, BLUE TEAM)
	@POST
	@Path("temporalComment")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public Response createComment(
			@FormParam("users_UserIdFrom") String users_UserIdFrom,
			@FormParam("users_UserIdTo") String users_UserIdTo,
			@FormParam("date") String date,
			@FormParam("comment") String comment
			)
			throws ParseException {

		if (users_UserIdFrom == null || users_UserIdTo == null || date == null
				|| comment == null) {
			return Response.status(Status.PRECONDITION_FAILED).build();
		}

		Comment newComment = new Comment();


		newComment.setUsers_userIdFrom(Integer.parseInt(users_UserIdFrom));
		newComment.setUsers_userIdTo(Integer.parseInt(users_UserIdTo));
		newComment.setDate(new java.sql.Date(new SimpleDateFormat("MM/dd/yyyy").parse(date).getTime()));
		newComment.setComment(comment);
		
		adminService.saveComment(newComment);
		return Response.ok().entity(new Viewable("/success")).build();
	}

	//PROFILE VIEWABLE
	@GET
	@Path("profile")
	@Produces(MediaType.TEXT_HTML)
	public Response profile() {
		
		Map<String, Object> map = new HashMap<String, Object>(); 
        User userfound = adminService.showUser(4);
        map.put("info", userfound);
        
       
        
        
		return Response.ok(new Viewable("/profile", map)).build();
	}
	
	@POST
	@Path("searchResult")
	@Produces(MediaType.TEXT_HTML)
	public Response searchResult(@FormParam("seachW") String search) {
		
		Map<String, Object> map = new HashMap<String, Object>();
        List<User> usr = adminService.showSearchResult(search);
        map.put("word", usr);
        
        
        return Response.ok().entity(new Viewable("/searchResult",map)).build();
	}
	
	//GET PROFILE INFORMATION
	@POST
	@Path("getProfile")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public Response getProfile(
			@FormParam("userId") String userId)
			throws ParseException {
				if (userId == null) {
					return Response.status(Status.PRECONDITION_FAILED).build();
				}
				User usr = (User) adminService.getUser(Integer.parseInt(userId));
				
				System.out.println(usr.getName());
				System.out.println(usr.getLastname());
				System.out.println(usr.getCountry());
				System.out.println(usr.getMail());
				System.out.println(usr.getPhone());
				System.out.println(usr.getPoints());
				System.out.println(usr.getBirthdate());
				
				//las insignias en "UserHasBadge" grupo de Eliseo
				
				//los comentarios grupo de Gabriela
				
				return Response.ok().entity(new Viewable("/success")).build();
	}
	
	//UPDATE PROFILE
	@POST
	@Path("updateProfile")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public Response updateProfile
			(@FormParam("userId") String userId,		
			@FormParam("emailAddress") String emailAddress,
			@FormParam("password") String password,
			@FormParam("firstName") String firstName,
			@FormParam("lastName") String lastName,
			@FormParam("birthdate") String birthdate,
			@FormParam("phone") String phone,
			@FormParam("country") String country,
			@FormParam("interest") String interest,
			@FormParam("role") String role 
			)
			throws ParseException {

				if (userId == null) {
					return Response.status(Status.PRECONDITION_FAILED).build();
				}			
				
				User usr = (User) adminService.getUser(Integer.parseInt(userId));
				
				User updatedUser = new User();
				
				updatedUser.setUserId(Integer.parseInt(userId));
				
				if(password != null && !password.isEmpty()){
					updatedUser.setPassword(password);
				} else {
					updatedUser.setPassword(usr.getPassword());
				}
				
				
				if (firstName != null && !firstName.isEmpty()) {
					updatedUser.setName(firstName);
				} else {
					updatedUser.setName(usr.getName());
				}

				
				
				if (lastName != null && !lastName.isEmpty()) {
					updatedUser.setLastname(lastName);
				} else {
					updatedUser.setLastname(usr.getLastname());
				}
				
				
				if (emailAddress != null && !emailAddress.isEmpty()) {
					updatedUser.setMail(emailAddress);
				} else {
					updatedUser.setMail(usr.getMail());
				}
				
				
				if (phone != null && !phone.isEmpty()) {
					updatedUser.setPhone(phone);
				} else {
					updatedUser.setPhone(usr.getPhone());
				}
				
				if (country != null && !country.isEmpty()) {
					updatedUser.setCountry(country);
					System.out.println(country);
				} else {
					updatedUser.setCountry(usr.getCountry());					
				}
				
				if (interest != null && !interest.isEmpty()) {
					updatedUser.setInterests_InterestId(Integer.parseInt(interest));
				} else {
					updatedUser.setInterests_InterestId(usr.getInterests_InterestId());
				}
				
				
				if (role != null && !role.isEmpty()) {
					updatedUser.setRoles_RoleId(Integer.parseInt(role));
				} else {
					updatedUser.setRoles_RoleId(usr.getRoles_RoleId());
				}
				
				
				if (birthdate != null && !birthdate.isEmpty() && birthdate != "") {
					updatedUser.setBirthdate(new java.sql.Date(new SimpleDateFormat("MM/dd/yyyy").parse(birthdate).getTime()));
				} else {
					updatedUser.setBirthdate(usr.getBirthdate());
				}
				
				adminService.save(updatedUser);
				return Response.ok().entity(new Viewable("/success")).build();
	}
	
	//GET BADGES VIEWABLE
		@GET
		@Path("badges")
		@Produces(MediaType.TEXT_HTML)
		public Response badges() {
			Map<String, Object> map = new HashMap<String, Object>();
	       
	        List<Badge> badges = adminService.showBadges();
	        map.put("word", badges);
			return Response.ok(new Viewable("/badges", map)).build();
			
		}
	
	//SHOW BADGES - GETS ALL BADGES INFORMATION
//	@GET
//	@Path("showBadges")
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	@Produces(MediaType.TEXT_HTML)
//	public Response showBadges(){
//		List<Badge> badges = adminService.showBadges();
//		for(int i = 0; i < badges.size(); i++) {
//			System.out.println(badges.get(i).getBadgeId());
//            System.out.println(badges.get(i).getName());
//            System.out.println(badges.get(i).getValue()); 
//        }
//		return null;
//	}
//	
	//UPDATE BADGE
	@POST
	@Path("updateBadge")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public Response updateBadge(
			@FormParam("update_badgeName") String badgeName,
			@FormParam("update_badgeValue") String badgeValue)
			throws ParseException {
				if (badgeName == null ||badgeValue == null) {
					return Response.status(Status.PRECONDITION_FAILED).build();
				}
				Badge newBadge = new Badge();
				newBadge.setName(badgeName);
				newBadge.setValue(Integer.parseInt(badgeValue));
								
				adminService.updateBadge(newBadge);
				
				return null;
	}	
	
	//CREATE BADGE
		@POST
		@Path("createBadge")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.TEXT_HTML)
		public Response createBadge(
				@FormParam("badgeName") String badgeName,
				@FormParam("badgeValue") String badgeValue)
				throws ParseException {
					if (badgeName == null) {
						return Response.status(Status.PRECONDITION_FAILED).build();
					}
			
					Badge newBadge = new Badge();
					newBadge.setName(badgeName);
					newBadge.setValue(Integer.parseInt(badgeValue));
									
					adminService.saveBadge(newBadge);
					return Response.ok().entity(new Viewable("/success")).build();
		}	
		
		
	
	//DELETE BADGE
	@POST
	@Path("deleteBadge")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public Response deleteBadge(
			@FormParam("delete_badgeId") String badgeId)
			throws ParseException {
				if (badgeId == null) {
					return Response.status(Status.PRECONDITION_FAILED).build();
				}

				adminService.deleteBadge(Integer.parseInt(badgeId));
				
				return Response.ok().entity(new Viewable("/success")).build();
	}

	@Override
	public Response showBadges() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response showUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response showSearchResult(String search) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
		
	
	
	
	
	
}
