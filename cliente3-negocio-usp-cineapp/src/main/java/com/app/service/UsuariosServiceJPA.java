package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Usuario;
import com.app.repository.UsuariosRepository;

@Service
public class UsuariosServiceJPA implements IUsuariosService{
	
	@Autowired
	private UsuariosRepository usuarioRepo;

	@Override
	public void guardar(Usuario usuario) {
		
		usuarioRepo.save(usuario);
	}

}
