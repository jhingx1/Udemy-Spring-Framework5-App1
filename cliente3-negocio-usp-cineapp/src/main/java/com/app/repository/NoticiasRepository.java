package com.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Noticia;

@Repository
//public interface NoticiasRepository extends CrudRepository<Noticia, Integer> {
public interface NoticiasRepository extends JpaRepository<Noticia, Integer> {
	
	//declarando un metodo query
	List<Noticia> findBy();//buscar por
	
	//select * from noticias where estatus=?
	
	public List<Noticia> findByEstatus(String estatus);//buscar por
	
	List<Noticia> findByFecha(Date fecha);//buscar por
	
	//where estatus=? and fecha=?
	List<Noticia> findByEstatusAndFecha(String estatus,Date fecha);
	
	//where estatus=? or fecha=?
	List<Noticia> findByEstatusOrFecha(String estatus,Date fecha);
	
	//where fecha betwen ? and ?
	List<Noticia> findByFechaBetween(Date fecha1,Date fecha2);
	
	//where fecha betwen ? and ?
	List<Noticia> findByIdBetween(int n1,int n2);
	
	// select * from Noticias where estatus = ? order by id desc limit 3
	public List<Noticia> findTop3ByEstatusOrderByIdDesc(String estatus);
	
	
}
