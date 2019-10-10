package com.app.crudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.repository.NoticiasRepository;

public class AppCount {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");		
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		//contar el numero de filas
		long num = repo.count();
		
		System.out.println("Total de Noticias : " + num);
		
		context.close();
		
	}

}
