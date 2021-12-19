package com.chris.plusultra.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chris.plusultra.models.Share;
import com.chris.plusultra.models.User;
import com.chris.plusultra.repositories.ShareRepository;

@Service
public class ShareService {
	@Autowired
	private ShareRepository sRepo;
	
	public List<Share> getAllShares() {
		return this.sRepo.findAll(); 
	}

	public Share getOneShare(Long id) {
		return this.sRepo.findById(id).orElse(null);
	}
	
	public Share createShare(Share share) {
		return this.sRepo.save(share);
	}
	
	public Share editShare(Share share) {
		return this.sRepo.save(share);
	}
	
	public String deleteShare(Long id) {
		this.sRepo.deleteById(id);
		return "Your Share has been deleted";
	}
	
	public void likeShare(User user, Share share) {
		List<User> usersWhoLiked = share.getLikers();
		usersWhoLiked.add(user);
		this.sRepo.save(share);
	}
	
	public void unlikeShare(User user, Share share) {
		List<User> usersWhoLiked = share.getLikers();
		usersWhoLiked.remove(user);
		this.sRepo.save(share);
	}
}
