package com.github.openplay.service;

import java.util.List;

import com.github.openplay.model.impl.Question;

public interface QuestionService {
	public void createQuestion(Question question);
	public Question getQuestion(int id);
	public List<Question> getAllQuestion();
	public void editQuestion(Question question);
	public void deleteQuestion(int id);
}
