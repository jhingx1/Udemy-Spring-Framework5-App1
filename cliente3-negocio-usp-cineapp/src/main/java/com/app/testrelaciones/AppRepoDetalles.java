package com.app.testrelaciones;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.model.Detalle;
import com.app.repository.DetallesRepository;

public class AppRepoDetalles {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");		
		//Recuperar todas las entidades de tipo pelicula
		DetallesRepository repo = context.getBean("detallesRepository", DetallesRepository.class);
	
		List<Detalle> lista = repo.findAll();//lista de objto de tipo pelicula
		for(Detalle p:lista)
			System.out.println(p);
		
		//si se bloquea la db : UNLOCK TABLES; en mysql
		
		context.close();

	}

}
