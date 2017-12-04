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

import com.github.openplay.model.CampaignTypeInterface;

@Component
@XmlRootElement(name="campaign_types")
@Entity
@Table(name="campaign_types")
public class CampaignTypes implements CampaignTypeInterface, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7584596726579052904L;

	@Id
	@GeneratedValue
	@Column(name="campaign_TypeId")
	public int campaign_TypeId;
	
	@NotEmpty
	@Column(name="description")
	private String description;
	
	//@OneToMany(fetch=FetchType.LAZY, mappedBy = "interest")
	//private Set<Campaign> campaign = new HashSet<Campaign>(0);
	
	public int getId() {
		return campaign_TypeId;
	}

	public void setId(int campaign_TypeId) {
		this.campaign_TypeId = campaign_TypeId;
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
