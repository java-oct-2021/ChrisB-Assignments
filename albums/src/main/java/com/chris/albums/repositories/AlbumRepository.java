package com.chris.albums.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chris.albums.models.Album;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Long> {
	List<Album> findAll();// SELECT *(all) FROM albums;
}
