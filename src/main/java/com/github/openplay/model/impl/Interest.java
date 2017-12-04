package com.github.openplay.model.impl;

import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import java.io.Serializable;

import com.github.openplay.model.InterestInterface;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.github.openplay.model.impl.Campaign;

@Component
@XmlRootElement(name="interests")
@Entity
@Table(name="interests")
public class Interest implements InterestInterface, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2794780953771180641L;

	@Id
	@GeneratedValue
	public int interestId;
	
	@NotEmpty
	private String description;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "campaignType")
	private Set<Campaign> campaign = new HashSet<Campaign>(0);

	public int getId(){
		return interestId;
	}

	public void setId(int id) {
		this.interestId = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Set<Campaign> getCampaigns(){
		return this.campaign;
	 }
	 
	 public void setCampaign(Set<Campaign> campaign){
		 this.campaign = campaign;
	 }

}