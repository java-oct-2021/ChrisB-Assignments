package com.chris.ideas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chris.ideas.models.Idea;
import com.chris.ideas.models.User;
import com.chris.ideas.repositories.IdeaRepository;

@Service
public class IdeaService {
	@Autowired
	private IdeaRepository iRepo;
	
	public List<Idea> getAllIdeas(){
		return this.iRepo.findAll();
	}
	
	public Idea getOneIdea(Long id) {
		return this.iRepo.findById(id).orElse(null);
	}
	
	public Idea createIdea(Idea idea) {
		return this.iRepo.save(idea);
	}
	
	public Idea editIdea(Idea idea) {
		return this.iRepo.save(idea);
	}
	
	public String deleteIdea(Long id) {
		this.iRepo.deleteById(id);
		return "Idea has been deleted";
	}
	
	public void likeIdea(User user, Idea idea) {
		List<User> usersWhoLiked = idea.getLikers();
		usersWhoLiked.add(user);
		this.iRepo.save(idea);
	}
	public void unlikeIdea(User user, Idea idea) {
		List<User> usersWhoLiked = idea.getLikers();
		usersWhoLiked.remove(user);
		this.iRepo.save(idea);
	}
}
