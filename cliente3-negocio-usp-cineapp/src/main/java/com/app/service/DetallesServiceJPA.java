package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Detalle;
import com.app.repository.DetallesRepository;

@Service
public class DetallesServiceJPA implements IDetalleService{

	@Autowired
	private DetallesRepository detallesRepo;
	
	@Override
	public void insertar(Detalle detalle) {
		
		detallesRepo.save(detalle);
		
	}

	@Override
	public void eliminar(int idDetalle) {
		detallesRepo.deleteById(idDetalle);		
	}

}
