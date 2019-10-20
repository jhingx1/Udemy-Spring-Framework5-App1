package com.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.app.model.Horario;

public interface IHorariosService {

	List<Horario> buscarPorIdPelicula(int idPelicula,Date fecha); //
	List<Horario> buscarTodos(); //lista de peliculas
	Page<Horario> buscarTodos(Pageable page);

}
