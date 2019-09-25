package com.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Pelicula;
import com.app.service.IPeliculasService;
import com.app.util.Utileria;

@Controller
public class HomeController {
	
	@Autowired //para inyectar el servicio
	private IPeliculasService servicePeliculas;
	
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
			@RequestParam("fecha") String fecha) {
		
		System.out.println("idPelicula : " + idPelicula);
		System.out.println("Buscando horarios pelicula : " + fecha);
		
		//TODO buscar en la DB los horarios
		
		String tituloPelicula = "Rapidos y Furiosos";
		int duracion = 136;
		double precioEntrada = 50;
		
		model.addAttribute("titulo", tituloPelicula);
		model.addAttribute("duracion", duracion);
		model.addAttribute("precioEntrada", precioEntrada);
		
		//uso de service
		model.addAttribute("pelicula", servicePeliculas.buscarPorId(idPelicula));
		
		//regresando el nombre de la vista
		return "detalle";
		
	}
	
	@RequestMapping(value="/search",method=RequestMethod.POST)
	public String buscar(@RequestParam("fecha") String fecha,Model model) {
		
		System.out.println("Buscando fecha peliculas:" + fecha);
		
		//para las fechas
		List<String> listaFechas = Utileria.getNextDays(4); 		
		List<Pelicula> peliculas = servicePeliculas.buscarTodas();
		
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("fechaBusqueda", fecha); //Mostrar la fecha seleccionada		
		//agregando las lista de fechas al modelo
		model.addAttribute("fechas", listaFechas);
		
		return "home";
	}
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String mostrarPrincipal(Model model) {
		
		//para las fechas
		List<String> listaFechas = Utileria.getNextDays(4); //por ser un metodo statico
		System.out.println(listaFechas);
		
		List<Pelicula> peliculas = servicePeliculas.buscarTodas();
		
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("fechaBusqueda", dateformat.format(new Date()));
		
		//agregando las lista de fechas al modelo
		model.addAttribute("fechas", listaFechas);
		
		return "home";
	}
	
	
}
