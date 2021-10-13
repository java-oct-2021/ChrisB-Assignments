package com.chris.HelloHuman.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	
	@RequestMapping("/name")
	public String name1(@RequestParam(value="q") String firstName, @RequestParam(value="last_name") String lastName) {
		return "Hello " + firstName + " " + lastName;
	}
	
}

