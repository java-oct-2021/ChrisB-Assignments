package com.chris.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.chris.dojosandninjas.models.Dojo;
import com.chris.dojosandninjas.models.Ninja;
import com.chris.dojosandninjas.services.DojoService;
import com.chris.dojosandninjas.services.NinjaService;

@Controller
public class HomeController {
	
	@Autowired
	private DojoService dService;
	
	@Autowired
	private NinjaService nService;
	
	
	@GetMapping("/ninjas/new")
	public String addNinja(@ModelAttribute("ninja")Ninja ninja, Model viewModel){
		List<Dojo> allDojos = this.dService.getAllDojos();
		viewModel.addAttribute("allDojos", allDojos);
		return "addninja.jsp";
	}
	
	@PostMapping("/createNinja")
	public String createNinja(@Valid @ModelAttribute("ninja")Ninja ninja, BindingResult result, Model viewModel ) {
		if(result.hasErrors()) {
			List<Dojo> allDojos = this.dService.getAllDojos();
			viewModel.addAttribute("allDojos", allDojos);
			return "addninja.jsp";
		}
		this.nService.createNinja(ninja);
		return "redirect:/dojos/" + ninja.getDojo().getId();
	}
		
	
	@GetMapping("/dojos/new")
	public String addDojo(@ModelAttribute("dojo")Dojo dojo) {
		return "adddojo.jsp";
	}
	
	@PostMapping("/createDojo")
	public String dojoCreate(@Valid @ModelAttribute("dojo")Dojo dojo, BindingResult result ) {
		if(result.hasErrors()) {
			return "adddojo.jsp";
		}
		this.dService.createDojo(dojo);
		return "redirect:/ninjas/new";
	}
	
	@GetMapping("/dojos/{id}")
	public String dash(Model viewModel, @PathVariable("id")Long id) {
		viewModel.addAttribute("dojo", this.dService.getOneDojo(id));
		return "dashboard.jsp";
	}
	

}
