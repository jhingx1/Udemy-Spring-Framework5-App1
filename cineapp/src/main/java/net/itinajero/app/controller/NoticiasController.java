package net.itinajero.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.itinajero.app.model.Noticia;

@Controller
@RequestMapping(value="/noticias")
public class NoticiasController {
	
	//Va hacia la ruta=url, pagina
	@GetMapping(value="/create")
	public String crear() {
		return "noticias/formNoticia";
	}
	
	@PostMapping(value="/save")//Se van a capturar los valores del formulario.
	public String guardar(
			@RequestParam("titulo") String titulo,
			@RequestParam("estatus") String estatus,
			@RequestParam("detalle") String detalle
			) {
		//Tenemos toda la informacion del formulario en un objeto creado.
		Noticia noticia = new Noticia();
		noticia.setTitulo(titulo);
		noticia.setEstatus(estatus);
		noticia.setDetalle(detalle);
		
		//Guardar el objeto noticia en la BD.
		
		System.out.println(noticia);
		
			System.out.println("Titulo : " + titulo + " Estatus: " + estatus + " detalle:" +detalle);
		
		return "noticias/formNoticia";
	}
	
}
