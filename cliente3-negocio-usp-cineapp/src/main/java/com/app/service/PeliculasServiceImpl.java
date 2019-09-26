package com.app.service;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.model.Pelicula;

@Service
public class PeliculasServiceImpl implements IPeliculasService{

	private List<Pelicula> lista = null;

	public PeliculasServiceImpl() {
		
		System.out.println("Creando una instancia de la clase peliculasServiceImpl");
		
		//creando la lista de peliculas
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy");
		

		try {
			lista = new LinkedList<>();

			Pelicula pelicula1 = new Pelicula();
			pelicula1.setId(1);
			pelicula1.setTitulo("Power Ranger");
			pelicula1.setDuracion(120);
			pelicula1.setClasificacion("B");
			pelicula1.setGenero("Aventura");
			pelicula1.setFechaEstreno(formatter.parse("02-05-2018"));
			// imgen = "cinema.png"
			// estatus = "Activa"

			Pelicula pelicula2 = new Pelicula();
			pelicula2.setId(2);
			pelicula2.setTitulo("La Bella y la Bestia");
			pelicula2.setDuracion(132);
			pelicula2.setClasificacion("A");
			pelicula2.setGenero("Infantil");
			pelicula2.setFechaEstreno(formatter.parse("02-05-2018"));
			pelicula2.setImagen("bella.png");

			Pelicula pelicula3 = new Pelicula();
			pelicula3.setId(3);
			pelicula3.setTitulo("Contratiempo");
			pelicula3.setDuracion(106);
			pelicula3.setClasificacion("B");
			pelicula3.setGenero("Thriller");
			pelicula3.setFechaEstreno(formatter.parse("28-05-2018"));
			pelicula3.setImagen("contratiempo.png");
			
			Pelicula pelicula4 = new Pelicula();
			pelicula4.setId(4);
			pelicula4.setTitulo("Kong La isla Calavera");
			pelicula4.setDuracion(118);
			pelicula4.setClasificacion("B");
			pelicula4.setGenero("Accion y Aventura");
			pelicula4.setFechaEstreno(formatter.parse("06-06-2018"));
			pelicula4.setImagen("kong.png");
			pelicula4.setEstatus("Inactiva");
			
			// Agregamos una pelicula mas

			Pelicula pelicula5 = new Pelicula();
			pelicula5.setId(5);
			pelicula5.setTitulo("Life: Vida Inteligente");
			pelicula5.setDuracion(104);
			pelicula5.setClasificacion("B");
			pelicula5.setGenero("Drama");
			pelicula5.setFechaEstreno(formatter.parse("10-06-2018"));
			pelicula5.setImagen("estreno5.png");
			pelicula5.setEstatus("Activa");
	
			// anadiendo a la lista
			lista.add(pelicula1);
			lista.add(pelicula2);
			lista.add(pelicula3);
			lista.add(pelicula4);
			lista.add(pelicula5);

			

		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			
		}
	}

	@Override
	public List<Pelicula> buscarTodas() {
		//metodo que regresa la lista de peliculas
		return lista;
	}

	@Override
	public Pelicula buscarPorId(int idPelicula) {
		
		for(Pelicula p:lista) {
			if(p.getId() == idPelicula) {
				return p;
			}
		}
		
		return null;
	}

}