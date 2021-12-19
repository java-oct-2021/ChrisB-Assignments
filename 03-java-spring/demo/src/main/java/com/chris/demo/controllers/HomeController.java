package com.chris.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	// method
	public String hello(Model model) {
		model.addAttribute("firstName", "Chris");
		model.addAttribute("stack", "Java");
		return "index.jsp";
	}
	@RequestMapping("/java")
	// method
	public String helloJava() {
		return "I love coding in java";
	}
	
	@RequestMapping("/welcome")
	// method
	public String welcome(@RequestParam(value="q")String firstName) {
		return "Welcome to Java " + firstName;
	}
	
	
	
}
