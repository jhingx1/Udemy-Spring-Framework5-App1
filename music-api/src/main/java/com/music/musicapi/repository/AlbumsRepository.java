package com.music.musicapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.music.musicapi.entity.Album;

public interface AlbumsRepository extends JpaRepository<Album, Integer> {

}
