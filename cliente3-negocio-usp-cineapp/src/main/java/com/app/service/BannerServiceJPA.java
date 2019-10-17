package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Banner;
import com.app.repository.BannersRepository;

@Service
public class BannerServiceJPA implements IBannersService{
	
	@Autowired
	private BannersRepository bannersRepo;

	@Override
	public void insertar(Banner banner) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Banner> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Banner> buscarActivos() {		

		return bannersRepo.findByEstatusOrderByIdDesc("Activo");
	}

}
