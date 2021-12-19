package com.chris.petstagram.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chris.petstagram.models.Picture;
import com.chris.petstagram.models.User;

@Repository
public interface PictureRepository extends CrudRepository<Picture,Long> {
	
	List<Picture> findAllByUser(User user);
	
}
