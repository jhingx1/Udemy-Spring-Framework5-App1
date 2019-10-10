package com.app.testcrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.repository.NoticiasRepository;

public class AppDelete {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");		
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		//Op CRUD - deleteById
		int idNoticia = 2;
				
		if(repo.existsById(idNoticia)) {//verificar si existe
			repo.deleteById(idNoticia);
		}
		
		context.close();

	}

}
