package com.github.openplay.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.openplay.model.impl.Mission;
import com.github.openplay.model.impl.Question;
import com.github.openplay.service.QuestionService;

@Service
@Transactional
@Component
public class QuestionServiceImpl implements QuestionService {
	@PersistenceContext
	public EntityManager entityManager;

	public void createQuestion(Question question) {
		// TODO Auto-generated method stub
		Mission mission=entityManager.getReference(Mission.class, question.mission.missionId);
		Question questionAdded = new Question();
		questionAdded.setQuestion(question.question);
		questionAdded.setScore(question.score);
		questionAdded.setMission(mission);
		entityManager.persist(questionAdded);
		
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
		Question questionEdit = entityManager.getReference(Question.class, question.questionId);
		questionEdit.setQuestion(question.question);
		questionEdit.setScore(question.score);
		questionEdit.setMission(mission);
		
		entityManager.merge(questionEdit);
		
	}

	public void deleteQuestion(int id) {
		// TODO Auto-generated method stub
		Question c = entityManager.find(Question.class, id);
		entityManager.remove(c);
		
	}
}
