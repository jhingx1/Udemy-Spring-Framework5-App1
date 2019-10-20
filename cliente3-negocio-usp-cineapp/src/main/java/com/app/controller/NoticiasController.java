package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Horario;
import com.app.model.Noticia;
import com.app.service.INoticiasService;

@Controller
@RequestMapping("/noticias")
public class NoticiasController {
	
	@Autowired
	private INoticiasService serviceNoticias;
	
	@GetMapping(value="/create")
	public String crear(){
		return "noticias/formNoticia";
	}

	@PostMapping(value="/save")
	public String guardar(Noticia noticia) {		
		
		//pendiente guardar el objeto noticia en la DB		
		System.out.println(noticia);	
				
		//inyectando el servicio
		serviceNoticias.guardar(noticia);
		
		return "noticias/formNoticia";
	}
	
	/**
	 * Metodo para mostrar el listado de noticias
	 * @param model
	 * @return
	 */
	@GetMapping("/index")
	public String mostrarIndex(Model model) { //mostrar lista de peliculas sin paginar
		
		List<Noticia> listaNoticias = serviceNoticias.buscarTodos();
		model.addAttribute("noticias", listaNoticias);
		return "noticias/listNoticias";
	}
	
}
