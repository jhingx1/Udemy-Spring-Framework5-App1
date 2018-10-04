package net.itinajero.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/noticias")
public class NoticiasController {
	
	@GetMapping(value="/create")
	public String crear() {
		return "noticias/formNoticia";
	}
	
	@PostMapping(value="/save")
	public String guardar(
			@RequestParam("titulo") String titulo,
			@RequestParam("estatus") String estatus,
			@RequestParam("detalle") String detalle
			) {
		
			System.out.println("Titulo : " + titulo + " Estatus: " + estatus + " detalle:" +detalle);
		
		return "noticias/formNoticia";
	}
	
}
