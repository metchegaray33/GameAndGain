package com.github.openplay.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.openplay.model.impl.Answers;
import com.github.openplay.model.impl.Question;
import com.github.openplay.service.AnswersService;
@Service
@Transactional
@Component
public class AnswersServiceImpl implements AnswersService {
	@PersistenceContext
	public EntityManager entityManager;

	@Override
	public void createAnswers(Answers answers) {
		// TODO Auto-generated method stub
		Question question=entityManager.getReference(Question.class, answers.question.questionId);
		Answers AnswersAdded = new Answers();
		AnswersAdded.setAnswer(answers.answer);
		AnswersAdded.setAnswerValue(answers.answer_value);
		AnswersAdded.setQuestions(question);
		entityManager.persist(AnswersAdded);
		
	}

	@Override
	public Answers getAnswers(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(Answers.class, id);
	}

	@Override
	public List<Answers> getAllAnswers() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select answer from Answers answer").getResultList();
	}

	@Override
	public void editAnswers(Answers answers) {
		// TODO Auto-generated method stub
		Question question=entityManager.getReference(Question.class, answers.question.questionId);
		Answers AnswersEdit = entityManager.getReference(Answers.class, answers.answerId);
		AnswersEdit.setAnswer(answers.answer);
		AnswersEdit.setAnswerValue(answers.answer_value);
		AnswersEdit.setQuestions(question);
		
		entityManager.merge(AnswersEdit);

		
	}

	@Override
	public void deleteAnswers(int id) {
		// TODO Auto-generated method stub
		Answers c = entityManager.find(Answers.class, id);
		entityManager.remove(c);
		
	}

}
