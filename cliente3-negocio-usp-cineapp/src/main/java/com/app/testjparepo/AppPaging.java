package com.app.testjparepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.app.model.Noticia;
import com.app.repository.NoticiasRepository;

public class AppPaging {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");		
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		//Obtener todas las entidades por paginacion
		//debuelve una lista de tipo page
		//Page<Noticia> page = repo.findAll(PageRequest.of(1, 5)); //para ordenar por titulo
		
		//ordenar por titulo
		Page<Noticia> page = repo.findAll(PageRequest.of(1,10,Sort.by("titulo")));
		
		for(Noticia n:page)
			System.out.println(n);
				
		context.close();
	}
}
