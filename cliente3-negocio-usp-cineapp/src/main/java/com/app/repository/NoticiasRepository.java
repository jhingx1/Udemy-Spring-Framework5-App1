package com.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Noticia;

@Repository
public interface NoticiasRepository extends CrudRepository<Noticia, Integer> {

}
