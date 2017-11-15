package com.github.openplay.model.impl;

import java.util.HashSet;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import com.github.openplay.model.MissionInterface;

import java.util.Set;

import javax.persistence.*;

@Component
@XmlRootElement(name="missions")
@Entity
@Table(name="missions")
public class Mission implements MissionInterface {
	
	@Id
	@Column(name="missionId")
	@GeneratedValue
	public int missionId;
	
	@NotEmpty
	@Column(name="name")
	@Size(min=4, max=60)
	public String name;
	
	@NotEmpty
	@Column(name="description")
	@Size(min=4, max=300)
	public String description;
	
	@Column(name="score")
	public Integer score;

	// Foreign keys association
	@NotNull
	@ManyToOne
	@JoinColumn(name="campaigns_CampaignsId")
	public Campaign campaign;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="difficulties_DifficultyId")
	public Difficulties difficulty;
	
	@OneToMany(fetch=FetchType.LAZY ,mappedBy = "mission")
	private Set<Question> question = new HashSet<Question>(0);
	
	public int getId() {
		return missionId;
	}

	public void setId(int missionId) {
		this.missionId = missionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Campaign getCampaign(){
		return campaign;
	}

	public void setCampaign(Campaign campaign){
		this.campaign = campaign;
	}

	public Difficulties getDifficulty(){
		return difficulty;
	}

	public void setDifficulty(Difficulties difficulty){
		this.difficulty = difficulty;
	}

	
	public Set<Question> getQuestion(){
		return this.question;
	}

	public void setMission(Set<Question> question){
		this.question = question;
	}

}