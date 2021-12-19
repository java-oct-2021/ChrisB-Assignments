package com.chris.petstagram.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chris.petstagram.models.Picture;
import com.chris.petstagram.models.User;
import com.chris.petstagram.repositories.PictureRepository;

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
	
//	public Picture getOnePicture(Long id) {
//		return this.pRepo.findById(id).orElse(null);
//	}
//	
//	public Picture editPicture(Picture picture) {
//		return this.pRepo.save(picture);
//	}
//	
//	public String deletePicture(Long id) {
//		this.pRepo.deleteById(id);
//		return "Your Picture has been deleted";
//	}
//	
//	public void likePicture(User user, Picture picture) {
//		List<User> usersWhoLiked = picture.getLikers();
//		usersWhoLiked.add(user);
//		this.pRepo.save(picture);
//	}
//	
//	public void unlikePicture(User user, Picture picture) {
//		List<User> usersWhoLiked = picture.getLikers();
//		usersWhoLiked.remove(user);
//		this.pRepo.save(picture);
//	}
	
}
