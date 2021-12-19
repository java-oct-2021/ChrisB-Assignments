package com.chris.plusultra.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chris.plusultra.models.Picture;
import com.chris.plusultra.models.User;

@Repository
public interface PictureRepository extends CrudRepository<Picture, Long> {
	
	List<Picture> findAllByUser(User user);
}
