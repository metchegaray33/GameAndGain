package com.github.openplay.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.github.openplay.model.impl.Mission;
import com.github.openplay.model.impl.Question;

public class QuestionServiceImpl {
	@PersistenceContext
	public EntityManager entityManager;

	public void createQuestion(Question question) {
		// TODO Auto-generated method stub
		Mission mission=entityManager.getReference(Mission.class, question.mission.missionId);
		Question QuestionAdded = new Question();
		QuestionAdded.setQuestion(question.question);
		QuestionAdded.setScore(question.score);
		QuestionAdded.setMission(mission);
		entityManager.persist(QuestionAdded);
		
	}

	public Question getQuestion(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(Question.class, id);
	}

	public List<Question> getAllQuestion() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select question from Question question").getResultList();
	}

	public void editQuestion(Question question) {
		// TODO Auto-generated method stub
		Mission mission=entityManager.getReference(Mission.class, question.mission.missionId);
		Question QuestionEdit = new Question();
		QuestionEdit.setQuestion(question.question);
		QuestionEdit.setScore(question.score);
		QuestionEdit.setMission(mission);
		
		entityManager.merge(QuestionEdit);
		
	}

	public void deleteQuestion(int id) {
		// TODO Auto-generated method stub
		Question c = entityManager.find(Question.class, id);
		entityManager.remove(c);
		
	}
}
