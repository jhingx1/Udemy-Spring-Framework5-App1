package com.app.testjparepo;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Sort;

import com.app.model.Noticia;
import com.app.repository.NoticiasRepository;

public class AppSorting {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");		
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		//obtener todas las entidades ordenadas por un campo
		//List<Noticia> lista = repo.findAll(Sort.by("titulo").descending());
				
		//Ordenas por dos o mas atributos
		List<Noticia> lista = repo.findAll(Sort.by("fecha").descending().and(Sort.by("titulo").ascending()));
		
		for(Noticia n:lista)
			System.out.println(n);
		
		context.close();

	}

}
