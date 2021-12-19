package com.chris.languages.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chris.languages.models.Language;
import com.chris.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	@Autowired
	private LanguageRepository lRepo;
	
	// Get Every Single Language from database and Return an ArrayList
	public List<Language> getAllLanguages(){
		return this.lRepo.findAll();
	}
	
	// Get One Language
	public Language getOneLanguage(Long id) {
		return this.lRepo.findById(id).orElse(null);
	}
	// Create Language
	public Language createLanguage(Language newLang) {
		return this.lRepo.save(newLang);
	}
	//Edit
	public Language editLanguage(Language editLang) {
		return this.lRepo.save(editLang);
	}
	
	// Delete Language
	public void deleteLanguage(Long id) {
		this.lRepo.deleteById(id);
	}


}
