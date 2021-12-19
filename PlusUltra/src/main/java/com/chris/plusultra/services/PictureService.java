package com.chris.plusultra.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chris.plusultra.models.Picture;
import com.chris.plusultra.models.User;
import com.chris.plusultra.repositories.PictureRepository;

@Service
public class PictureService {
	@Autowired
	private PictureRepository pRepo;
	
	public void uploadPic(User user, String url, String desc) {
		Picture newPic = new Picture(url, desc, user);
		this.pRepo.save(newPic);
	}
	
	public List<Picture> userPictures(User user){
		return this.pRepo.findAllByUser(user);
	}
}
