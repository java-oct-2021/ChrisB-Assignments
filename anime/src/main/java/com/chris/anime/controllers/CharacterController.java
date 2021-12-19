package com.chris.anime.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chris.anime.models.Characters;
import com.chris.anime.services.AnimeService;
import com.chris.anime.services.CharactersService;

@Controller
@RequestMapping("/character")
public class CharacterController {
	@Autowired
	private CharactersService cService;
	@Autowired
	private AnimeService aService;
	
	@GetMapping("/new")
	public String create(@ModelAttribute("characters")Characters characters, Model viewModel) {
		viewModel.addAttribute("anime", this.aService.getAllAnimes());
		return "/characters/new.jsp";
	}
	
	@PostMapping("/newCharacter")
	public String addChar(@Valid @ModelAttribute("character")Characters characters, BindingResult result) {
		Long idAnime=characters.getAnimeCharIsFrom().getId();
		if(result.hasErrors()) {
			return"characters/new.jsp";
		}
		this.cService.create(characters);
		return "redirect:/details/" + idAnime;
	}
//	// FROM LECTURE
//	@GetMapping("/characters/login/{id}")
//	public String login(@PathVariable("id")Long id, HttpSession session) {
//		session.setAttribute("userId", id);
//		return "redirect:/characters";
//	}
//	
//	@GetMapping("/characters/like/{id}")
//	public String like(@PathVariable("id")Long id, HttpSession mysession) {
//		Long animeiD=(Long)mysession.getAttribute("animeId");
//		Anime anime=aService.getOneAnime(animeiD);
//		Characters characters=cService.getOneCharacter(id);
//		cService.addLikes(characters, anime);
//		return "redirect:/characters";
//	}
}
