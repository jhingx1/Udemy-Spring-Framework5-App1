package com.app.testquery;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.model.Noticia;
import com.app.repository.NoticiasRepository;

public class AppKeywordTests {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");		
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		List<Noticia> lista = repo.findByEstatus("Activa");
		
		for(Noticia n:lista)
			System.out.println(n);
		
		context.close();

	}

}
