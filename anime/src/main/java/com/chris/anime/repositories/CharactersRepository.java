package com.chris.anime.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chris.anime.models.Characters;

@Repository
public interface CharactersRepository extends CrudRepository<Characters, Long> {

}
