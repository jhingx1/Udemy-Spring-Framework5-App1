package com.app.testjparepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.repository.NoticiasRepository;

public class AppDeleteAllInBatch {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		//usa cuando la table tiene mucho registros
		//ejm-JpaRepository
		//delete from noticias
		//ejm-crudrepositoy
		//delete from noticias where id=?
		//delete from noticias where id=?
		
		repo.deleteAllInBatch();
		
		context.close();

	}

}
