package com.music.musicapi.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.musicapi.entity.Album;
import com.music.musicapi.repository.AlbumsRepository;
import com.music.musicapi.service.IAlbumService;

@Service
public class AlbumsService implements IAlbumService {
	
	@Autowired
	private AlbumsRepository repoAlbums; //inyectando dp

	@Override
	public List<Album> buscarTodos() {
		
		return repoAlbums.findAll(); //uso de metodos por defecto
	}

	@Override
	public void guardar(Album album) {
		repoAlbums.save(album);		
	}

	@Override
	public void eliminar(int idAlbum) {
		repoAlbums.deleteById(idAlbum);		
	}

}
