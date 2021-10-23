package com.chris.languages.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.chris.languages.models.Language;
import com.chris.languages.services.LanguageService;

@Controller
public class HomeController {
	@Autowired
	private LanguageService lService;
	
	@GetMapping("/languages")
	public String index(Model model, @ModelAttribute("language")Language language) {
		model.addAttribute("allLanguages", this.lService.getAllLanguages());
		return "languages.jsp";
	}
	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable("id")Long id) {
		model.addAttribute("language", this.lService.getOneLanguage(id));
		return "edit.jsp";
	}
	@PutMapping("/edit/{id}")
	public String edit(@Valid @ModelAttribute("language")Language lang, BindingResult result, Model model, @PathVariable("id")Long id) {
		if(result.hasErrors()) {
			model.addAttribute("language", this.lService.getOneLanguage(id));
			return "edit.jsp";
		}
		this.lService.editLanguage(lang);
		return "redirect:/show/{id}";
	}
	
	@PostMapping("/languages/add")
	public String addNew(@Valid @ModelAttribute("language")Language language, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("allLanguages", this.lService.getAllLanguages());
			return "languages.jsp"; 
		}
		this.lService.createLanguage(language);
		return "redirect:/languages";

	}
	
	@GetMapping("/show/{id}")
	public String showLang(Model model, @PathVariable("id")Long id) {
		model.addAttribute("language", this.lService.getOneLanguage(id));
		return "show.jsp";
	}
	
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id")Long id) {
		this.lService.deleteLanguage(id);
		return "redirect:/languages";
	}
}
