package com.app.service;

import java.util.List;
import java.util.Optional;

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
		bannersRepo.save(banner);
	}

	@Override
	public List<Banner> buscarTodos() {
		//para la vista listar todos los banners
		return bannersRepo.findAll();
	}

	@Override
	public List<Banner> buscarActivos() {		
		//metodo para mostrar en la pagina principal - solo los activos
		return bannersRepo.findByEstatusOrderByIdDesc("Activo");
	}

	@Override
	public Banner buscarPorId(int idBanner) {
		Optional<Banner> optional = bannersRepo.findById(idBanner);
		if(optional.isPresent())
			return optional.get();
		
		return null;
	}

	@Override
	public void eliminar(int idBanner) {		
		bannersRepo.deleteById(idBanner);
	}

}
