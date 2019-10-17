package com.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Banner;
import com.app.model.Horario;
import com.app.model.Noticia;
import com.app.model.Pelicula;
import com.app.service.IBannersService;
import com.app.service.IHorariosService;
import com.app.service.INoticiasService;
import com.app.service.IPeliculasService;
import com.app.util.Utileria;

@Controller
public class HomeController {
	
	@Autowired //para inyectar el servicio
	private IPeliculasService servicePeliculas;
	
	@Autowired
	private IBannersService serviceBanners;
	
	@Autowired
	private IHorariosService serviceHorarios;
	
	@Autowired
	private INoticiasService serviceNoticias; //
	
	private SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String goHome() {
		
		//Mi logica
		return "home";
		
	}
	
	//@RequestMapping(value="/detail/{id}/{fecha}",method=RequestMethod.GET)
	//public String mostrarDetalle(Model model,@PathVariable("id") int idPelicula,@PathVariable("fecha") String fecha)
	
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String mostrarDetalle(Model model,@RequestParam("idMovie") int idPelicula,
			@RequestParam("fecha") Date fecha) {
		
//		System.out.println("idPelicula : " + idPelicula);
//		System.out.println("Buscando horarios pelicula : " + fecha);
		
		//TODO buscar en la DB los horarios
		
//		String tituloPelicula = "Rapidos y Furiosos";
//		int duracion = 136;
//		double precioEntrada = 50;
//		
//		model.addAttribute("titulo", tituloPelicula);
//		model.addAttribute("duracion", duracion);
//		model.addAttribute("precioEntrada", precioEntrada);
		
		List<Horario> horarios = serviceHorarios.buscarPorIdPelicula(idPelicula, fecha);
		model.addAttribute("horarios", horarios);
		
		//fecha que selecciono el usuario
		model.addAttribute("fechaBusqueda", dateformat.format(fecha));
		
		//uso de service
		model.addAttribute("pelicula", servicePeliculas.buscarPorId(idPelicula));
		
		//regresando el nombre de la vista
		return "detalle";
		
	}
	
	//para redefinir la fecha del sistema
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	//Metodo para buscar las peliculas por fecha
	@RequestMapping(value="/search",method=RequestMethod.POST)
	public String buscar(@RequestParam("fecha") Date fecha,Model model) { //
		
		
		//tambien usaremos el metodo buscarPorFecha
		try {
			//formato de fecha sin hora
			Date fechaSinHora = dateformat.parse(dateformat.format(fecha));
			
			System.out.println("Buscando fecha peliculas:" + fecha);	
			//para las fechas
			List<String> listaFechas = Utileria.getNextDays(4);
			
			// Regresamos la fecha que selecciono el usuario con el mismo formato
			model.addAttribute("fechaBusqueda", dateformat.format(fecha)); //Mostrar la fecha seleccionada	
			
			//reemplazado por buscarPorFecha
			//List<Pelicula> peliculas = servicePeliculas.buscarTodas();
			List<Pelicula> peliculas  = servicePeliculas.buscarPorFecha(fechaSinHora);
			model.addAttribute("peliculas", peliculas);
			//agregando las lista de fechas al modelo
			model.addAttribute("fechas", listaFechas);
			
			//banners - Para la pagina principal
			List<Banner> banners = serviceBanners.buscarTodos();
			//banners-pagina principal
			model.addAttribute("banners", banners);
			
		} catch (ParseException e) {
			System.out.println("Error: HomeController.buscar" + e.getMessage());
		}
		
		return "home";
	}
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String mostrarPrincipal(Model model) {
		
		
		try {
			//vamos a ponerlo como variable de clase
			Date fechaSinHora = dateformat.parse(dateformat.format(new Date()));
			
			//para las fechas:lista de fechas a mostrar
			List<String> listaFechas = Utileria.getNextDays(4); //por ser un metodo statico
			System.out.println(listaFechas);
			
			//se va reemplazar para que filtre solo peliculas activas y con horario
			//List<Pelicula> peliculas = servicePeliculas.buscarTodas();
			List<Pelicula> peliculas = servicePeliculas.buscarPorFecha(fechaSinHora);
			
			//agregando las lista de fechas al modelo
			model.addAttribute("fechas", listaFechas);
			
			//para comparar con la fecha de hoy
			model.addAttribute("fechaBusqueda", dateformat.format(new Date()));
			
			model.addAttribute("peliculas", peliculas);
			
			//banners
			model.addAttribute("banners", serviceBanners.buscarTodos());
			
		} catch (ParseException e) {
			System.out.println("Error: HomeController.mostrarPrincipal" + e.getMessage());
		}
			
		return "home";
	}
	
	//Metodo para buscar las 3 ultimas noticas
	@ModelAttribute("noticias")
	public List<Noticia> getNoticias(){
		return serviceNoticias.buscarUltimas();
	}
	
}
