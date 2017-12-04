package com.github.openplay.model.impl;

import java.util.HashSet;
import java.util.Set;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import com.github.openplay.model.CampaignStatesInterface;

@Component
@XmlRootElement(name="campaign_states")
@Entity
@Table(name="campaign_states")
public class CampaignStates implements CampaignStatesInterface, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4237854234223276960L;

	@Id
	@GeneratedValue
	@Column(name="campaign_StateId")
	public int campaign_StateId;
	
	@NotEmpty
	@Column(name="description")
	private String description;
	
	//@OneToMany(fetch=FetchType.LAZY, mappedBy = "campaignState")
	//private Set<Campaign> campaign = new HashSet<Campaign>(0);
	
	public int getId() {
		return campaign_StateId;
	}

	public void setId(int campaign_StateId) {
		this.campaign_StateId = campaign_StateId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	//public Set<Campaign> getCampaigns(){
		//return this.campaign;
	 //}
	 
	 //public void setCampaign(Set<Campaign> campaign){
		// this.campaign = campaign;
	 //}
}
