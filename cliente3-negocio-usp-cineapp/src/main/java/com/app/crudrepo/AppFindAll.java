package com.app.crudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.model.Noticia;
import com.app.repository.NoticiasRepository;

public class AppFindAll {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");		
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		//recuperar todos los registros en un Iterable
		Iterable<Noticia> it = repo.findAll();
		
		for(Noticia n:it) {
			System.out.println(n);
		}
		
		context.close();
		
	}

}
