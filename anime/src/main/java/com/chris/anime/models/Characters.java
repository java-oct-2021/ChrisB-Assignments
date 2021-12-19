package com.chris.anime.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="characters")
public class Characters {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String charName;
	private String ability;
	private String affiliation;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="anime_id")
	private Anime animeCharIsFrom;

	
	private Characters() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCharName() {
		return charName;
	}

	public void setCharName(String charName) {
		this.charName = charName;
	}

	public String getAbility() {
		return ability;
	}

	public void setAbility(String ability) {
		this.ability = ability;
	}

	public String getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}
	
	public Anime getAnimeCharIsFrom() {
		return animeCharIsFrom;
	}

	public void setAnimeCharIsFrom(Anime animeCharIsFrom) {
		this.animeCharIsFrom = animeCharIsFrom;
	}

	
}
