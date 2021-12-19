package com.chris.albums.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chris.albums.models.Album;
import com.chris.albums.services.AlbumService;

@Controller
public class HomeController {
	@Autowired
	private AlbumService aService;
	
	@GetMapping("/")
	public String index(Model viewModel) {
		viewModel.addAttribute("allAlbums", this.aService.getAllAlbums());
		return "index.jsp";
	}
	
	@GetMapping("/new")
	public String add() {
		return "add.jsp";
	}
	
	@PostMapping("/new")
	public String addNew(@RequestParam("albumName")String album, @RequestParam("bandName")String band, @RequestParam("year")Integer year) {
		Album albumToSave = new Album(album, band, year);
		this.aService.createAlbum(albumToSave);
		return "redirect:/";
	}
}
