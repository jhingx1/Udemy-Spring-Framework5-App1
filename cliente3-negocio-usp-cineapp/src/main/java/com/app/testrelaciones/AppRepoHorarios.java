package com.app.testrelaciones;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.model.Horario;
import com.app.repository.HorariosRepository;

public class AppRepoHorarios {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");		
		//Recuperar todas las entidades de tipo pelicula
		HorariosRepository repo = context.getBean("horariosRepository", HorariosRepository.class);
	
		List<Horario> lista = repo.findAll();//lista de objto de tipo pelicula
		
		System.out.println("N entidades" + lista.size());
		
		for(Horario p:lista)
			System.out.println(p);
		
		//para el manejo de hora - ante la pegunta por que en el modelo es string y en la db es time
		//esto es por que spring(post o get) siempre envia como string y cuando lo recive spring ya los convierte
		//con el uso de data.binding
		//https://www.oscarblancarteblog.com/2016/11/23/mapeo-fechas-temporal/
		
		context.close();
	}
}
