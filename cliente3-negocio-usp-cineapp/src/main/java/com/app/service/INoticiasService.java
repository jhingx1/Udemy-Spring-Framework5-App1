package com.app.service;

import java.util.List;

import com.app.model.Noticia;

public interface INoticiasService {

	void guardar(Noticia noticia);
	
	List<Noticia> buscarUltimas();
	
}
