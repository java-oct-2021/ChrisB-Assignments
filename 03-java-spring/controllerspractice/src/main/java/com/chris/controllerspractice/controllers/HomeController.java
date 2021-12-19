package com.chris.controllerspractice.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hello")
@RestController
public class HomeController {

	@RequestMapping("")
	public String hello() {
		return "Hello World, it's your boy Chris";
	}
	@RequestMapping("/world")
	public String world() {
		return "I'm hungry boy";
	}
	
	
}
