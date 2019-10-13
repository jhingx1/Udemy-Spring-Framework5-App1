package com.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.model.Pelicula;
import com.app.service.IDetalleService;
import com.app.service.IPeliculasService;
import com.app.service.PeliculasServiceImpl;
import com.app.util.Utileria;

@Controller
@RequestMapping(value="/peliculas")
public class PeliculaController {
	
	@Autowired	
	private IPeliculasService servicePeliculas;
	
	@Autowired
	private IDetalleService serviceDetalles;
	
	@GetMapping(value="/create")
	public String crear(@ModelAttribute Pelicula pelicula,Model model) {
		
		//model.addAttribute("generos",servicePeliculas.buscarGeneros());
		return "peliculas/formPelicula";
	}
	
	@PostMapping(value="/save")
	public String guardar(@ModelAttribute Pelicula pelicula,BindingResult result,RedirectAttributes attributes,
			@RequestParam("archivoImagen") MultipartFile multiPart, HttpServletRequest request) {
		
		if (result.hasErrors()) {
			System.out.println("Existen errore");
			return "peliculas/formPelicula";
		}
		
		//verificar si el objto no biene vacio
		if (! multiPart.isEmpty()) {
			String nombreImagen = Utileria.guardarImagen(multiPart, request);
			//asigmanos la imagen
			pelicula.setImagen(nombreImagen);
		}
		
//		for (ObjectError error: result.getAllErrors()){
//			System.out.println(error.getDefaultMessage());
//		}			
		
//		System.out.println("Objeto pelicula : " + pelicula);
//		System.out.println("elemetos en la lista antes " + servicePeliculas.buscarTodas().size());
				
		//Guardar primero los datos DetallePelicula
		System.out.println("Antes : " + pelicula.getDetalle());
		serviceDetalles.insertar(pelicula.getDetalle()); 
		System.out.println("Despues : " + pelicula.getDetalle());
		
		servicePeliculas.insertar(pelicula);
//		System.out.println("elemetos en la lista despues " + servicePeliculas.buscarTodas().size());
		
		//model.addAttribute("mensaje", "El registro fue Guardado");
		// Procesar objeto de modelo
		attributes.addFlashAttribute("mensaje", "Registro Guardado");
		
		//return "peliculas/formPelicula";		
		//realizar un redireccionamiento
		//return "redirect:/peliculas/index"; antes de la paginacion
		return "redirect:/peliculas/indexPaginate";
		
	}
	
	//para redefinir la fecha del sistema
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
// Lo comentamos por que hemo implementado paginacion
//	@GetMapping("/index")
//	private String mostrarIndex(Model model) {
//		
//		//Listado de peliculas
//		List<Pelicula> lista = servicePeliculas.buscarTodas();		
//		model.addAttribute("peliculas", lista);		
//		return "peliculas/listPeliculas";
//	}
	
	@GetMapping(value="/edit/{id}")
	public String editar(@PathVariable("id") int idPelicula,Model model) {
		
		Pelicula pelicula = servicePeliculas.buscarPorId(idPelicula);
		//model.addAttribute("generos",servicePeliculas.buscarGeneros());
		model.addAttribute("pelicula", pelicula);
		
		return "peliculas/formPelicula"; 
	}
	
	@ModelAttribute("generos")
	public List<String> getGeneros(){
		return servicePeliculas.buscarGeneros();
	}
	
	@GetMapping(value="/delete/{id}")
	public String eliminar(@PathVariable("id") int idPelicula,RedirectAttributes attributes) {
				
		Pelicula pelicula = servicePeliculas.buscarPorId(idPelicula); //obt la pelicula
		
		//1. Eliminarmos la pelicula
		servicePeliculas.eliminar(idPelicula);
		//2. Eliminamos el detalle		
		serviceDetalles.eliminar(pelicula.getDetalle().getId());
				
		attributes.addFlashAttribute("mensaje","La Pelicula fue eliminada");
		
		return "redirect:/peliculas/index";
	}
	
	//En utileria esta metodo para eliminar una imagen del servidor
	
	//otra forma de eliminar
//	@GetMapping("/delete/{id}/{detalleId}")
//	public String delete(@PathVariable("id") int id, @PathVariable("detalleId") int idDetalle, RedirectAttributes ra) {
//		servicePeliculas.eliminar(id);
//		serviceDetalles.delete(id);
//		ra.addFlashAttribute("delMsg", "La pelicula fue eliminada");
//		return "redirect:/peliculas/index";
//	}
	
	
	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Pelicula> lista = servicePeliculas.buscarTodas(page);
		model.addAttribute("peliculas",lista);
		return "peliculas/listPeliculas";
	}
	
}
