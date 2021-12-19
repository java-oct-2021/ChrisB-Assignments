package com.chris.anime.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="animeoct")
public class Anime {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(min = 1, max = 100, message="Hey, you can't put that here!")
	private String animeTitle;
	@NotBlank
	@Size(min = 1, max = 200, message="WHOOOOOOOOOOOOOOOA there")
	private String animeDescr;
	@NotNull
	private Integer numberOfEpis;
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyy-MM-DD HH:mm:ss")
	private Date createdAt;
	@DateTimeFormat(pattern="yyy-MM-DD HH:mm:ss")
	private Date updatedAt;
	@OneToMany(mappedBy="animeCharIsFrom",cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Characters> characters;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="likes",
			joinColumns = @JoinColumn(name = "anime_id"),
			inverseJoinColumns = @JoinColumn(name = "user_id")
			)
	private List<User> likers;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User owner;
	
	public Anime(String animeTitle, String animeDescr, Integer numberOfEpis) {
		this.animeTitle = animeTitle;
		this.animeDescr = animeDescr;
		this.numberOfEpis = numberOfEpis;
	}
	 
	
	public List<Characters> getCharacters() {
		return characters;
	}


	public void setCharacters(List<Characters> characters) {
		this.characters = characters;
	}


	public Anime() {
		
	}

	@PrePersist // If this is new, do it
	protected void onCreate() {
		this.createdAt = new Date();
	}
		
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getAnimeTitle() {
		return animeTitle;
	}

	public void setAnimeTitle(String animeTitle) {
		this.animeTitle = animeTitle;
	}

	public String getAnimeDescr() {
		return animeDescr;
	}

	public void setAnimeDescr(String animeDescr) {
		this.animeDescr = animeDescr;
	}


	public Integer getNumberOfEpis() {
		return numberOfEpis;
	}

	public void setNumberOfEpis(Integer numberOfEpis) {
		this.numberOfEpis = numberOfEpis;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


	public List<User> getLikers() {
		return likers;
	}


	public void setLikers(List<User> likers) {
		this.likers = likers;
	}


	public User getOwner() {
		return owner;
	}


	public void setOwner(User owner) {
		this.owner = owner;
	}



	
}
