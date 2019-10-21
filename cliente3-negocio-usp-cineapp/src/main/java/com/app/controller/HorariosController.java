package com.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import com.app.model.Banner;
import com.app.model.Horario;
import com.app.model.Pelicula;
import com.app.service.IHorariosService;
import com.app.service.IPeliculasService;
import com.app.service.PeliculasServiceImpl;

@Controller
@RequestMapping(value="/horarios")
public class HorariosController {
	
	@Autowired	
	private IPeliculasService servicePeliculas;
	
	@Autowired
	private IHorariosService serviceHorarios;
	
	
	/**
	 * Metodo para mostrar el listado de horarios
	 * @param model
	 * @return
	 */
	@GetMapping("/index")
	public String mostrarIndex(Model model) { //mostrar lista de peliculas sin paginar
		
		List<Horario> listaHorarios = serviceHorarios.buscarTodos();
		model.addAttribute("horarios", listaHorarios);
		return "horarios/listHorarios";
	}
		
	/**
	 * Metodo para mostrar el formulario para crear un nuevo horario
	 * @return
	 */
	@GetMapping(value = "/create")
	public String crear(@ModelAttribute Horario horario) { //,Model model
		
		// Ejercicio: Recuperar lista de peliculas para poblar <select>
		//reemplazado por el metodo
		//List<Pelicula> listaPeliculas = servicePeliculas.buscarTodas();
					
		// Ejercicio: agregar al modelo listado de peliculas
		//reemplazado por el metodo
		//model.addAttribute("peliculas", listaPeliculas);
		
		// Ejercicio: crear archivo formHorario.jsp y configurar el diseño utilizando el codigo HTML
		// del archivo formHorario.html de la plantilla (utilizar Form Tag Library)
		
		return "horarios/formHorario";
	}
		
	/**
	 * Metodo para guardar el registro del Horario
	 * @param horario
	 * @param model
	 * @return
	 */
	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute Horario horario,BindingResult result,RedirectAttributes attributes,Model model) {				
		
		// Ejercicio: Verificar si hay errores en el Data Binding
		if (result.hasErrors()) {
			//List<Pelicula> listaPeliculas = servicePeliculas.buscarTodas();
			List<Pelicula> listaPeliculas = servicePeliculas.buscarActivas();
			model.addAttribute("peliculas", listaPeliculas);
			return "horarios/formHorario";
		}
		
		// Ejercicio: En caso de no haber errores, imprimir en consola el objeto de model Horario 
		// que ya debera de tener los datos del formulario
		
		System.out.println("Objeto horario : " +  horario);
		
		serviceHorarios.insertar(horario);
		attributes.addFlashAttribute("msg", "El Horario fue guardado");
				
		// De momento, hacemos un redirect al mismo formulario
		//Horario paginado
		//return "redirect:/horarios/create";
		
		return "redirect:/horarios/indexPaginate";
	}
	
	// Ejercicio: Crear metodo para personalizar el Data Binding para las todas las propiedades de tipo Date	
	//para redefinir la fecha del sistema
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Horario> lista = serviceHorarios.buscarTodos(page);
		model.addAttribute("horarios",lista);
		return "horarios/listHorarios";
	}
	
	/**
	 * Metodo que muestra el formulario para editar un horario
	 * @param idHorario
	 * @param model
	 * @return
	 */
	
	@GetMapping(value="/edit/{id}")
	public String editar(@PathVariable("id") int idHorario,Model model) {
		
		Horario horario = serviceHorarios.buscarPorId(idHorario);
		model.addAttribute("horario", horario);
		return "horarios/formHorario";
		
	}
	
	//Para no añadir peliculas al modelo
	@ModelAttribute("peliculas")
	public List<Pelicula> getPeliculas(){		
		return servicePeliculas.buscarActivas(); 
	}
	
	@GetMapping(value="/delete/{id}")
	public String eliminar(@PathVariable("id") int idHorario,RedirectAttributes attributes) {			
		serviceHorarios.eliminar(idHorario);					
		attributes.addFlashAttribute("msg","La Pelicula fue eliminada");				
		//return "redirect:/horarios/index";
		return "redirect:/horarios/indexPaginate";
	}
	
	
}
