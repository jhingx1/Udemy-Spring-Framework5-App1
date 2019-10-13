package com.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.app.model.Pelicula;

public interface IPeliculasService {
	
	//lista de objeto de tipo pelicula
	List<Pelicula> buscarTodas();
	
	//Para buscar la pelicula por id
	Pelicula buscarPorId(int idPelicula);
	
	//metodo para insertar
	void insertar(Pelicula pelicula);
	
	//Para las lista de generos
	List<String> buscarGeneros();
	
	void eliminar(int idPelicula);
	
	//sobrecargado
	public Page<Pelicula> buscarTodas(Pageable page);

}
