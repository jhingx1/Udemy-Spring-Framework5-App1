package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.model.Banner;
import com.app.service.IBannersService;
import com.app.util.Utileria;

@Controller
@RequestMapping("/banners/")
public class BannersController {

	// Ejercicio: Inyectar instancia de la clase de servicio
	@Autowired
	private IBannersService serviceBanners;
		
	/**
	 * Metodo para mostrar el listado de banners
	 * @param model
	 * @return
	 */
	@GetMapping("/index")
	public String mostrarIndex(Model model) { //mostrar lista de peliculas
		
		// Ejercicio: Implementar metodo
		List<Banner> lista = serviceBanners.buscarTodos();
		
		// Ejercicio: Crear vista listBanners.jsp. Utilizar el archivo listBanners.html de la plantilla
		model.addAttribute("banners", lista);
		
		return "banners/listBanners";
	}
	
	/**
	 * Metodo para mostrar el formulario para crear un nuevo Banner
	 * @return
	 */
	@GetMapping("/create")
	public String crear() {
		
		// Ejercicio: Crear vista formBanner.jsp. 
		//Utilizar el archivo formBanner.html de la plantilla
			
		return "banners/formBanner";
		
	}
	
	/**
	 * Metodo para guardar el objeto de modelo de tipo Banner
	 * @return
	 */
	@PostMapping("/save")
	public String guardar(Banner banner,BindingResult result,RedirectAttributes attributes,
			@RequestParam("archivoImagen") MultipartFile multiPart, HttpServletRequest request) {
		
		// Ejercicio: Implementar el metodo.
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "banners/index";
		}
		
		//verificar si el objto no biene vacio
		if (! multiPart.isEmpty()) {
			String nombreImagen = Utileria.guardarImagen(multiPart, request);
			//asigmanos la imagen
			banner.setArchivo(nombreImagen);
		}
		
		//guardar el banner en la lista
		serviceBanners.insertar(banner);
		
		// Procesar objeto de modelo
		attributes.addFlashAttribute("mensaje", "Registro Guardado");
		
		return "redirect:/banners/index";
	}	
}
