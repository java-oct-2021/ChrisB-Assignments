package com.chris.anime.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chris.anime.models.Characters;
import com.chris.anime.repositories.CharactersRepository;

@Service
public class CharactersService {
	@Autowired
	private CharactersRepository cRepo;
	
	public Characters create(Characters characters) {
		return this.cRepo.save(characters);
	}
	public Characters editChar(Characters  characters) {
		return this.cRepo.save(characters);
	}
	
	// To delete anime
	public String deleteChar(Long id) {
		this.cRepo.deleteById(id);
		return "Character...has been deleted";
	}
	
	public Characters getOneCharacter(Characters characters) {
		return this.cRepo.save(characters);
	}
}
