package com.chris.albums.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="songs")
public class Song {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String length;
	
	// Album that the song belongs to
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="album_id")// 
	private Album albumSongIsOn;
	// Constructor. Empty Java Bean
	public Song() {

	}
	
	public Album getAlbumSongIsOn() {
		return albumSongIsOn;
	}

	public void setAlbumSongIsOn(Album albumSongIsOn) {
		this.albumSongIsOn = albumSongIsOn;
	}

	// Getters & Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	
	
}
