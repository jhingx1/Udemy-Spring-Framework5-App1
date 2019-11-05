package com.app.service;

import java.util.List;
import com.app.model.Banner; 

public interface IBannersService {

	void insertar(Banner banner); 
	List<Banner> buscarTodos();
	List<Banner> buscarActivos();
	
	Banner buscarPorId(int idBanner);
	void eliminar(int idBanner);
	
}
