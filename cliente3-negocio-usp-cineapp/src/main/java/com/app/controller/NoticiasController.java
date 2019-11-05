package com.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.app.model.Noticia;

import com.app.service.INoticiasService;

@Controller
@RequestMapping("/noticias")
public class NoticiasController {
	
	@Autowired
	private INoticiasService serviceNoticias;
	
	@GetMapping(value="/create")
	public String crear(@ModelAttribute Noticia noticia){
		//public String crear(){ -- sin data bindingResult
		return "noticias/formNoticia";
	}

	@PostMapping(value="/save")
	public String guardar(@ModelAttribute Noticia noticia,BindingResult result,RedirectAttributes attributes,Model model) {		
		
		//pendiente guardar el objeto noticia en la DB		
		
		System.out.println("Objeto Noticia : "+noticia);
				
		//inyectando el servicio
		serviceNoticias.guardar(noticia);
		attributes.addFlashAttribute("msg", "El Horario fue guardado");
		
		//return "noticias/formNoticia";
		return "redirect:/noticias/index";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
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
	
	@GetMapping(value="/edit/{id}")
	public String editar(@PathVariable("id") int idNoticia,Model model) {
		Noticia noticia = serviceNoticias.buscarPorId(idNoticia);
		model.addAttribute("noticia",noticia);
		return "noticias/formNoticia";
	}
	
	@GetMapping(value="/delete/{id}")
	public String eliminar(@PathVariable("id") int idNoticia,RedirectAttributes attributes) {
		
		serviceNoticias.eliminar(idNoticia);
		attributes.addFlashAttribute("msg", "Noticia Eliminada");
		
		return "redirect:/noticias/index";
	}
	
}
