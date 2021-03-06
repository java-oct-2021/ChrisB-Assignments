package com.chris.albums.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chris.albums.models.Album;
import com.chris.albums.repositories.AlbumRepository;

@Service
public class AlbumService {
	@Autowired
	private AlbumRepository aRepo;
//	public AlbumService(AlbumRepository repository) {
//		this.aRepo = repository;
//	}	
	
	// Get Every Single Album From Database and Return in ArrayList
	public List<Album> getAllAlbums(){
		return this.aRepo.findAll();
	}
	
	// Get One Album
	public Album getOneAlbum(Long id) {
		return this.aRepo.findById(id).orElse(null);
	}
	
	// Create Album
	public Album createAlbum(Album album) {
		return this.aRepo.save(album);
	}
	
	// Update Album
	public Album editAlbum(Album album) {
		return this.aRepo.save(album);
	}
	
	// Delete Album
	public String deleteAlbum(Long id) {
		this.aRepo.deleteById(id);
		return "Album has been deleted";
	}
	
}
