package com.app.service;

import java.util.List;

import com.app.model.Pelicula;

public interface IPeliculasService {
	
	//lista de objeto de tipo pelicula
	List<Pelicula> buscarTodas();
	
	//Para buscar la pelicula por id
	Pelicula buscarPorId(int idPelicula);
	
	//metodo para insertar
	void insertar(Pelicula pelicula);

}
