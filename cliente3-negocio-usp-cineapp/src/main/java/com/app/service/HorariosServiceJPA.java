package com.app.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.model.Horario;
import com.app.model.Pelicula;
import com.app.repository.HorariosRepository;

@Service
public class HorariosServiceJPA implements IHorariosService{
	
	@Autowired
	private HorariosRepository horariosRepo;

	@Override
	public List<Horario> buscarPorIdPelicula(int idPelicula, Date fecha) {
		
		return horariosRepo.findByPelicula_IdAndFechaOrderByHora(idPelicula, fecha);
		
	}

	@Override
	public List<Horario> buscarTodos() {
		//findAll : es un metodo predeterminado - pero es necesario crear el repositorio
		return horariosRepo.findAll(); 
	}

	@Override
	public Page<Horario> buscarTodos(Pageable page) { //listado paginado
		return horariosRepo.findAll(page);
	}

	@Override
	public void insertar(Horario horario) {		
		horariosRepo.save(horario);
	}

	@Override
	public Horario buscarPorId(int idHorario) {		
		Optional<Horario> optional = horariosRepo.findById(idHorario);		
		//System.out.println(optional);		
		if(optional.isPresent())
			return optional.get();
		
		return null;
	}

	@Override
	public void eliminar(int idHorario) {
		// horariosRepo.delete(idHorario); // Spring 4.3		
		horariosRepo.deleteById(idHorario);		
	}
	
	
}
