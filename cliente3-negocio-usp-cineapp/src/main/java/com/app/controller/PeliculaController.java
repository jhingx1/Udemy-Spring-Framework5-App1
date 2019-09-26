package com.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.model.Pelicula;
import com.app.service.PeliculasServiceImpl;

@Controller
@RequestMapping(value="/peliculas")
public class PeliculaController {
	
	@Autowired	
	private PeliculasServiceImpl servicePeliculas;	
	
	@GetMapping(value="/create")
	public String crear() {
		return "peliculas/formPelicula";
	}
	
	@PostMapping(value="/save")
	public String guardar(Pelicula pelicula,BindingResult result) {
		
		if (result.hasErrors()) {
			System.out.println("Existen errore");
			return "peliculas/formPelicula";
		}
		
//		for (ObjectError error: result.getAllErrors()){
//			System.out.println(error.getDefaultMessage());
//		}
				
		
		System.out.println("Objeto pelicula : " + pelicula);
		System.out.println("elemetos en la lista antes " + servicePeliculas.buscarTodas().size());
		servicePeliculas.insertar(pelicula);
		System.out.println("elemetos en la lista despues " + servicePeliculas.buscarTodas().size());
		return "peliculas/formPelicula";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@GetMapping("/index")
	private String mostrarIndex(Model model) {
		
		//Listado de peliculas
		List<Pelicula> lista = servicePeliculas.buscarTodas();
		
		model.addAttribute("peliculas", lista);
		
		return "peliculas/listPeliculas";
	}
	
}
