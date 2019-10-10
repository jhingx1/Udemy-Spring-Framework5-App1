package com.app.testcrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.repository.NoticiasRepository;

public class AppDeleteAll {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");		
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		//Borrar los registros - metodo deleteAll
		//Metodo muy peligroso
		
		repo.deleteAll();
		
		context.close();
		
	}

}
