package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Perfil;
import com.app.repository.PerfilesRepository;

@Service
public class PerfilesServiceJPA implements IPerfilesService{

	@Autowired
	private PerfilesRepository perfilesRepo;
	
	@Override
	public void guardar(Perfil perfil) {
		
		perfilesRepo.save(perfil);
		
	}

}
