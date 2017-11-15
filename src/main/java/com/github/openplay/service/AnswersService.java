package com.github.openplay.service;

import java.util.List;

import com.github.openplay.model.impl.Answers;

public interface AnswersService {
	public void createAnswers(Answers answers);
	public Answers getAnswers(int id);
	public List<Answers> getAllAnswers();
	public void editAnswers(Answers answers);
	public void deleteAnswers(int id);
}
