package com.chris.displaydate.controllers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


//import java.util.Date();

@Controller
public class HomeController {
	
	public Date getDate() {
		Date now = new Date();
		return now;
	}
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model viewModel) {
		viewModel.addAttribute("datetime", getDate());
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model viewModel) {
		viewModel.addAttribute("datetime", getDate());
		return "time.jsp";
	}
}
