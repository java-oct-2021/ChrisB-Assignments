package com.chris.dojosandninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chris.dojosandninjas.models.Ninja;
import com.chris.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	@Autowired
	private NinjaRepository nRepo;
	
	public List<Ninja> getAllNinjas(){
		return this.nRepo.findAll();
	}
	public Ninja getOneNinja(Long id) {
		return this.nRepo.findById(id).orElse(null);
	}
	
	public Ninja createNinja(Ninja ninja) {
		return this.nRepo.save(ninja);
	}
	



}
