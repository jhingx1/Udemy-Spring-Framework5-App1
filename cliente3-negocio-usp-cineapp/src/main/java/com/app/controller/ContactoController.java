package com.app.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.model.Contacto;
import com.app.service.IPeliculasService;
import com.app.service.PeliculasServiceImpl;

@Controller
public class ContactoController {
	
	@Autowired	
	private IPeliculasService servicePeliculas;	
	
	@GetMapping(value="/contacto")
	public String mostrarFormulario(@ModelAttribute("instanciaContacto") Contacto contacto,Model model) {
			
		//model.addAttribute("generos",servicePeliculas.buscarGeneros());
		model.addAttribute("tipos", tipoNotificaciones());
		return "formContacto";
	}

	@PostMapping(value="/contacto")
	public String guardar(@ModelAttribute("instanciaContacto") Contacto contacto) { //realizaremos el data-binding
		
		System.out.println(contacto);
		return "redirect:/contacto";
	}
	
	private List<String> tipoNotificaciones(){
		//nots: esto se podria generar desde una base de datos
		List<String> tipos = new LinkedList<>();		
		tipos.add("Estrenos");
		tipos.add("Promociones");
		tipos.add("Noticias");
		tipos.add("Preventas");
		
		return tipos;
	}
	
}
