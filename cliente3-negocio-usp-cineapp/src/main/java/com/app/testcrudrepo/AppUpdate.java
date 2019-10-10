package com.app.testcrudrepo;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.model.Noticia;
import com.app.repository.NoticiasRepository;

public class AppUpdate {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");		
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		//Update
		//1.- Buscar la entidad que vamos a modificar
		Optional<Noticia> optional = repo.findById(1);
		
		//2.- Modificar la entidad y la guardamos
		//verificar si tiene datos el objeto optional
		if(optional.isPresent()) {
			Noticia noticia = optional.get(); //get:nos debuelve el objeto de tipo noticia
			//System.out.println(noticia);
			//modificando valor
			noticia.setEstatus("inactiva");
			repo.save(noticia);
		}
		
		//Antes del close.context() e añadido context.clearResourceCaches();
				
		context.close();
	}

}
