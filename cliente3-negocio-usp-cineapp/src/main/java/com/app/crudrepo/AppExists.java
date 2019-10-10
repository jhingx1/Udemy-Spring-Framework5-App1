package com.app.crudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.repository.NoticiasRepository;

public class AppExists {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");		
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		//metodo para verificar si una entidad existe en base de datos
		int idNoticia = 1;
		System.out.println(repo.existsById(idNoticia)); //true:existe,false:no existe
		
		context.close();
		
	}

}
