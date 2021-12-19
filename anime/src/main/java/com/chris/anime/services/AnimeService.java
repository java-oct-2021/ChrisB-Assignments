package com.chris.anime.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chris.anime.models.Anime;
import com.chris.anime.models.User;
import com.chris.anime.repositories.AnimeRepository;

@Service
public class AnimeService {
	@Autowired
	private AnimeRepository aRepo;
	//To get All anime
	public List<Anime> getAllAnimes(){
		return this.aRepo.findAll();
	}
	//To get One anime
	public Anime getOneAnime(Long id) {
		return this.aRepo.findById(id).orElse(null); // .orElse(null) because Anime is an optional type
	}
	
	// To create anime
	public Anime createAnime(Anime anime) {
		return this.aRepo.save(anime);
	}
	
	// To Update anime
	public Anime editAnime(Anime anime) {
		return this.aRepo.save(anime);
	}
	
	// To delete anime
	public String deleteAnime(Long id) {
		this.aRepo.deleteById(id);
		return "Anime has been deleted";
	}
	
	// Like an anime
	public void likeAnime(User user, Anime anime) {
		List<User> usersWhoLiked = anime.getLikers();
		usersWhoLiked.add(user);
		this.aRepo.save(anime);
	}
	// Unlike anime
	public void unlikeAnime(User user, Anime anime) {
		List<User> usersWhoLiked = anime.getLikers();
		usersWhoLiked.remove(user);
		this.aRepo.save(anime);
	}
}
