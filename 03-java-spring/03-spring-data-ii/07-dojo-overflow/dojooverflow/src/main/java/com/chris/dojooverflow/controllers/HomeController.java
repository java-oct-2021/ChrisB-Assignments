package com.chris.dojooverflow.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.chris.dojooverflow.models.Answer;
import com.chris.dojooverflow.models.Question;
import com.chris.dojooverflow.services.AnswerService;
import com.chris.dojooverflow.services.TagService;
import com.chris.dojooverflow.validators.TagValidator;

@Controller
public class HomeController {
	@Autowired
	private AnswerService aService;

	@Autowired
	private TagService tService;
	@Autowired
	private TagValidator validator;
	
	@GetMapping("/")
	public String index(Model viewModel) {
		viewModel.addAttribute("questions", this.tService.getAllQuestions());
		return "dashboard.jsp";
	}
	
	@GetMapping("/new")
	public String newQuestion(@ModelAttribute("question")Question question) {
		return "NewQuestion.jsp";
	}
	
	@PostMapping("/newQuestion")
	public String createQuestion(@Valid @ModelAttribute("question")Question question, BindingResult result) {
		validator.validate(question, result);
		if(result.hasErrors()) {
			return "NewQuestion.jsp";
		}
		this.tService.createQuestion(question);
		return "redirect:/";
	}
	
	@GetMapping("/show/{id}")
	public String show(@PathVariable("id")Long id, Model viewModel, @ModelAttribute("answer")Answer answer) {
		viewModel.addAttribute("question", this.tService.findOneQuestion(id));
		return "Show.jsp";
	}
	
	@PostMapping("/addAnswer")
	public String createAnswer(@Valid @ModelAttribute("answer")Answer answer, BindingResult result, Model viewModel) {
		if(result.hasErrors()) {
			viewModel.addAttribute("answer", this.tService.findOneQuestion(answer.getQuestionAnswerIsOn().getId()));
			return "Show.jsp";
		}
		this.aService.createAnswer(answer);
		return "redirect:/show/" + answer.getQuestionAnswerIsOn().getId();
	}
	
}
