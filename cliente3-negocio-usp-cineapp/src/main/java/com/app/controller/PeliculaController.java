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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String guardar(Pelicula pelicula,BindingResult result,RedirectAttributes attributes) {
		
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
		
		//model.addAttribute("mensaje", "El registro fue Guardado");
		// Procesar objeto de modelo
		attributes.addFlashAttribute("mensaje", "Registro Guardado");
		
		//return "peliculas/formPelicula";		
		//realizar un redireccionamiento
		return "redirect:/peliculas/index";
		
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
