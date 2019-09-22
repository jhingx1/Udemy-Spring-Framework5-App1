package com.app.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String goHome() {
		
		//Mi logica
		return "home";
		
	}
	
	@RequestMapping(value="/detail")
	public String mostrarDetalle(Model model) {
		String tituloPelicula = "Rapidos y Furiosos";
		int duracion = 136;
		double precioEntrada = 50;
		
		model.addAttribute("titulo", tituloPelicula);
		model.addAttribute("duracion", duracion);
		model.addAttribute("precioEntrada", precioEntrada);
		
		//regresando el nombre de la vista
		return "detalle";
		
	}
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String mostrarPrincipal(Model model) {
		
		List<String> peliculas = new LinkedList<>();
		peliculas.add("Rapidos y Furiosos");
		peliculas.add("El aro 2");
		peliculas.add("Aliens");
		model.addAttribute("peliculas", peliculas);
		
		String demo = "demo";
		model.addAttribute("demo", demo);
		
		
		return "home";
	}
	
	
	
}
