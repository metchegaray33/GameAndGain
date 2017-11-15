package com.github.openplay.model.impl;

import java.util.HashSet;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import com.github.openplay.model.impl.Mission;
import com.github.openplay.model.QuestionsInterface;

import java.util.Set;

import javax.persistence.*;

@Component
@XmlRootElement(name="questions")
@Entity
@Table(name="questions")
public class Question implements QuestionsInterface {
	
	@Id
	@GeneratedValue
	@Column(name="questionId")
	public int questionId;
	
	@NotEmpty
	@Size(min=4, max=20)
	public String question;
	

	@NotEmpty
	public Integer score;


	// Foreign keys association
	@NotNull
	@ManyToOne
	@JoinColumn(name="missionId")
	public Mission mission;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "question")
	private Set<Answers> answer = new HashSet<Answers>(0);
	
	public int getId() {
		return questionId;
	}

	public void setId(int questionId) {
		this.questionId = questionId;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Mission getMission(){
		return mission;
	}

	public void setMission(Mission mission){
		this.mission = mission;
	}

	
	public Set<Answers> getAnswers(){
		return answer;
	}

	public void setAnswer(Set<Answers> answer){
		this.answer = answer;
	}


}