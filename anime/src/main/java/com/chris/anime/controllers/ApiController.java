package com.chris.anime.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chris.anime.models.Anime;
import com.chris.anime.services.AnimeService;

@RestController
@RequestMapping("/api")
public class ApiController {
	@Autowired
	private AnimeService aService;
	
	@GetMapping("/")
	public List<Anime> index(){
		return this.aService.getAllAnimes();
	}
	
	@GetMapping("/{id}")
	public Anime getOne(@PathVariable("id")Long id) {
		return this.aService.getOneAnime(id);
	}
	
	@PostMapping("/create")
	public Anime create(Anime anime) {
		return this.aService.createAnime(anime);
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete (@PathVariable("id")Long id) {
		return this.aService.deleteAnime(id);
		}
}
