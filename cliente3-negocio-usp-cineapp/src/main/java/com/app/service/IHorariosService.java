package com.app.service;

import java.util.Date;
import java.util.List;

import com.app.model.Horario;

public interface IHorariosService {

	List<Horario> buscarPorIdPelicula(int idPelicula,Date fecha);

}
