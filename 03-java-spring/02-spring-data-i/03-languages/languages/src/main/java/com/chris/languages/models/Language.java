package com.chris.languages.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="languages")
public class Language {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(min=3, max=20)
	private String langName;
	@NotBlank
	@Size(min=3, max=20)
	private String creator;
	@NotNull
	@Min(0)
	private Float version;

	// Constructor
	public Language() {

	}
	
	public Language(@NotBlank @Size(min = 3, max = 20) String langName,
			@NotBlank @Size(min = 3, max = 20) String creator, @NotNull @Min(0) Float version) {
		super();
		this.langName = langName;
		this.creator = creator;
		this.version = version;
	}

	// Getters and Setters

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLangName() {
		return langName;
	}

	public void setLangName(String langName) {
		this.langName = langName;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Float getVersion() {
		return version;
	}

	public void setVersion(Float version) {
		this.version = version;
	}
	
	
}
