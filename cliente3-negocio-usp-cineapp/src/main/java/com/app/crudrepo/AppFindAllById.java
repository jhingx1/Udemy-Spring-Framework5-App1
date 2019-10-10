package com.app.crudrepo;

import java.util.LinkedList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.model.Noticia;
import com.app.repository.NoticiasRepository;



public class AppFindAllById {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");		
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		//recuperar varios registros por id
		List<Integer> ids = new LinkedList<>(); //list: internamente implementa a iterable
		ids.add(3);
		ids.add(4);
		ids.add(5);
		
		Iterable<Noticia> it = repo.findAllById(ids);
		for(Noticia n:it)
			System.out.println(n);
		
		context.close();		

	}

}
