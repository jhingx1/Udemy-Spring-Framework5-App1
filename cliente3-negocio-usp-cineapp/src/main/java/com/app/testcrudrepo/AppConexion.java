package com.app.testcrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.repository.NoticiasRepository;


public class AppConexion {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		System.out.println("Total de Noticias : " + repo.count());
		
		context.close();

	}

}
