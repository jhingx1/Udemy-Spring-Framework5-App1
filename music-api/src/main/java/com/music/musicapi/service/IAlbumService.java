package com.music.musicapi.service;

import java.util.List;

import com.music.musicapi.entity.Album;

public interface IAlbumService {
	
	List<Album> buscarTodos();
	void guardar(Album album);
	void eliminar(int idAlbum);
}
