package com.chris.ideas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chris.ideas.models.Idea;

@Repository
public interface IdeaRepository extends CrudRepository<Idea, Long> {
	List<Idea> findAll();
//	List<Idea> findByIdeaTitleContaining(String containing);
//	boolean existsByIdeaTitle(String content);
}
