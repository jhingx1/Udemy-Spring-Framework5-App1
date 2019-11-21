package com.music.musicapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.music.musicapi.entity.Album;
import com.music.musicapi.service.IAlbumService;

@RestController
@RequestMapping("/api")
public class AlbumsController {
	
	@Autowired
	private IAlbumService serviceAlbums; //inyectando 
	
	//listado de albuns
	@GetMapping("/albums")
	public List<Album> buscarTodos(){		
		return serviceAlbums.buscarTodos();
	}
	
	@PostMapping("/albums")
	public Album guardar(@RequestBody Album album) {
		
		//@RequestBody : indicando a springBoot que cuando se haga una peticion tipo post a la url(/album) va 
		//buscar en el cuerpo de esa peticion la informacion que venga en formato json y debe de realizar 
		//el data-bindig(mapeio con la clase y la tabla) de forma automatica a un objeto album y esto ya obtendremos 
		//los datos que se obtubieron en el cuerpo de la peticion.
		
		serviceAlbums.guardar(album);
		return album;
	}
	
	@PutMapping("/albums")
	public Album modificar(@RequestBody Album album) {
		//vamos a incluir el id -> Realizara un update
		serviceAlbums.guardar(album);
		return album;
	}
	
	@DeleteMapping("/albums/{id}")
	public String eliminar(@PathVariable("id") int idAlbum) { //@PathVariable("id") para capturar la variable
		serviceAlbums.eliminar(idAlbum);
		return "Registro Eliminado";
	}
}