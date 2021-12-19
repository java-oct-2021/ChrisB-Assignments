package com.chris.anime.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chris.anime.models.Anime;

@Repository
public interface AnimeRepository extends CrudRepository<Anime, Long> {
	List<Anime> findAll();
	List<Anime> findByAnimeTitleContaining(String containing);
	List<Anime> findByOrderByNumberOfEpisDesc();
	boolean existsByAnimeTitle(String animeTitle);
}
