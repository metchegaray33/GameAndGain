package com.github.openplay.model.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Proxy;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.github.openplay.model.CampaignInterface;
import com.github.openplay.model.impl.Interest;
import com.github.openplay.model.impl.CampaignStates;
import com.github.openplay.model.impl.CampaignTypes;

import java.util.Set;

import javax.persistence.*;

@Component
@XmlRootElement(name="campaigns")
@Entity
@Proxy(lazy=false)
@Table(name="campaigns")
public class Campaign implements CampaignInterface, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="campaignsId")
	@GeneratedValue
	public int campaignsId;
	
	@NotEmpty
	@Column(name="name")
	@Size(min=4, max=70)
	public String name;
	
	@NotEmpty
	@Column(name="description")
	@Size(min=4, max=300)
	public String description;
	
	@Column(name="maxScore")
	public Integer maxScore;
	
	@Past
	@Column(name="startDate")
	@DateTimeFormat(pattern="MM/dd/yyyy")
	public Date startDate;
	
	@Past
	@Column(name="endDate")
	@DateTimeFormat(pattern="MM/dd/yyyy")
	public Date endDate;

	// Foreign keys association
	@NotNull
	@ManyToOne
	@JoinColumn(name="campaign_States_Campaign_StateId")
	public CampaignStates campaignState;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="campaign_Types_Campaign_TypeId")
	public CampaignTypes campaignType;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="users_userId")
	public User users;
	
	//@OneToMany(fetch=FetchType.EAGER, mappedBy = "campaign")
	//private Set<Mission>mission= new HashSet<Mission>(0);
	
	@NotNull
	@ManyToOne
	public Project project;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="interests_InterestId")
	public Interest interest;

	// Missing Foreign keys and foreign keys methods

	public int getId() {
		return campaignsId;
	}

	public void setId(int campaignsId) {
		this.campaignsId = campaignsId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getMaxScore() {
		return maxScore;
	}

	public void setMaxScore(Integer maxScore) {
		this.maxScore = maxScore;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	//  Foreign keys functions

	public CampaignStates getCampaignState(){
		return campaignState;
	}

	public void setCampaignState(CampaignStates campaignState){
		this.campaignState = campaignState;
	}

	public CampaignTypes getCampaignType(){
		return campaignType;
	}

	public void setType(CampaignTypes campaignType){
		this.campaignType = campaignType;
	}

	
	public Interest getInterest(){
		return interest;
	}

	public void setInterest(Interest interest){
		this.interest = interest;
	}

	@ManyToOne
	@JoinColumn(name="users")
	public User getUser(){
		return users;
	}

	public void setUser(User user){
		this.users = user;
	}

	@ManyToOne
	@JoinColumn(name="projects")
	public Project getProject(){
		return project;
	}

	public void setProject(Project project){
		this.project = project;
	}

	
	//public Set<Mission> getMission(){
	//	return this.mission;
//	}

	//public void setMission(Set<Mission> mission){
	//	this.mission = mission;
	//}

	public void setCampaignType(CampaignTypes type) {
		// TODO Auto-generated method stub
		this.campaignType= type;
	}

}