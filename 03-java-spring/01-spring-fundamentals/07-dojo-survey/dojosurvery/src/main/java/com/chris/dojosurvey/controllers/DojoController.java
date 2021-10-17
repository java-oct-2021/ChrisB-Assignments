package com.chris.dojosurvey.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DojoController {
	@GetMapping("/")
	public String index(Model viewModel) {
		viewModel.addAttribute("locations", new String[] {"Phoenix", "Los Angeles", "Chicago", "Gilbert"});
		viewModel.addAttribute("languages", new String[] {"Java", "MERN", "JavaScript", "Phython"});
		return "index.jsp";
	}

	@PostMapping("/result")
	public String result(@RequestParam("firstName")String fName, 
			@RequestParam("location")String location, 
			@RequestParam("language")String program, 
			@RequestParam("comment")String comment,
			Model model) {
		model.addAttribute("firstName", fName);
		model.addAttribute("location", location);
		model.addAttribute("language", program);
		model.addAttribute("comment", comment);
		return "result.jsp";
	}
	@GetMapping("/info")
	public String info() {
		return "info.jsp";
	}
}
