package com.app.crudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.model.Noticia;
import com.app.repository.NoticiasRepository;

public class AppCreate {

	public static void main(String[] args) {
		
		Noticia noticia = new Noticia();
		noticia.setTitulo("Proximo Estreno : Juego Macabro XI");
		noticia.setDetalle("Esto es una prueba de insercion de datos");
				
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		repo.save(noticia);
		
		context.close();

	}

}
