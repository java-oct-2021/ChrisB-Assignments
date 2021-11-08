package com.chris.dojooverflow.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chris.dojooverflow.models.Answer;
import com.chris.dojooverflow.repositories.AnswerRepository;

@Service
public class AnswerService {
	@Autowired
	private AnswerRepository aRepo;
	
	public Answer createAnswer(Answer answer) {
		return this.aRepo.save(answer);
	}
}
