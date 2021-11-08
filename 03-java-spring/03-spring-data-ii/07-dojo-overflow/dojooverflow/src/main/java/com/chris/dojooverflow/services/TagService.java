package com.chris.dojooverflow.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chris.dojooverflow.models.Question;
import com.chris.dojooverflow.models.Tag;
import com.chris.dojooverflow.repositories.QuestionRepository;
import com.chris.dojooverflow.repositories.TagRepository;

@Service
public class TagService {
	@Autowired
	private TagRepository tRepo;
	@Autowired
	private QuestionRepository qRepo;
	
	public Tag getSingleTag(String subject) {
		return this.tRepo.findBySubject(subject);
	}
	
	public ArrayList<Tag> splitTags(String tags) {
		ArrayList<Tag> tagsForQuestion = new ArrayList<Tag>();
		String[] tagsToSave = tags.split(", ");
		for(String s : tagsToSave) {
			if(this.tRepo.existsBySubject(s)) {
				Tag tagToAdd = this.getSingleTag(s);
				tagsForQuestion.add(tagToAdd);
			} else {
				Tag newTag = new Tag();
				newTag.setSubject(s);
				this.tRepo.save(newTag);
				tagsForQuestion.add(this.getSingleTag(s));
			}
		}
		return tagsForQuestion;
	}
	
	public Question createQuestion(Question question) {
		question.setQuestionTags(this.splitTags(question.getUserTags()));
		return this.qRepo.save(question);
	}
	public List<Question> getAllQuestions(){
		return this.qRepo.findAll();
	}
	
	public Question findOneQuestion(Long id) {
		return this.qRepo.findById(id).orElse(null);
	}
}
