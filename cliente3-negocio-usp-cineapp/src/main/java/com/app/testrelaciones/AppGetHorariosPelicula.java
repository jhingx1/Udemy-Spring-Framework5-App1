package com.app.testrelaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.model.Horario;
import com.app.model.Pelicula;
import com.app.repository.PeliculasRepository;

public class AppGetHorariosPelicula {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");		
		//Recuperar todas las entidades de tipo pelicula
		PeliculasRepository repo = context.getBean("peliculasRepository", PeliculasRepository.class);
	
		Optional<Pelicula> optional = repo.findById(7);
				
		//numero de horarios que hay registrado para la pelicula
		System.out.println(optional.get().getHorarios().size());
		
		context.close();
	}
}
