package com.app.testcrudrepo;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.model.Noticia;
import com.app.repository.NoticiasRepository;

public class AppRead {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");		
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		//Operacion CRUD - read
		//clase optional: puede contener o no un valor nulo.
		//La clase optinal es para evitar la excepcion null.
		Optional<Noticia> noticia = repo.findById(1);
		System.out.println(noticia.get());
				
		context.close();

	}

}
