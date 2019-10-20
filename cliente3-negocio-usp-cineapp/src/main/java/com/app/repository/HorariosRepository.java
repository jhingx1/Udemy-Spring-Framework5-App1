package com.app.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.app.model.Horario;

/** Marcamos esta clase como un Bean de tipo Repository en nuestro Root ApplicationContext.
Nota: La anotacion @Repository es opcional ya que al extender la interfaz JpaRepository Spring 
crea una instancia en nuestro Root ApplicationContext.
*/
@Repository
public interface HorariosRepository extends JpaRepository<Horario, Integer> {
		
	// Horarios por idPelicula (Pelicula.id = Pelicula_Id and fecha=?)
	//indentificar la pelicul por fecha
	public List<Horario> findByPelicula_IdAndFechaOrderByHora(int idPelicula,Date fecha);
	
	/* mysql.cnf
	 *  [mysqld]
	 * 	sql_mode = "STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION"
	 *  select * from horarios h
		inner join peliculas p on h.idPelicula = p.id
		where h.fecha='2019-10-13' and p.estatus = 'Activa'
		group by h.idPelicula
		order by p.id asc;
		
		notar que la anotacion Query usa los atributos de la clase horario para hacer la consulta. p es 
		el atributo Pelicula que esta en el modelo-clase horario.
		
		Usado para peliculasService
		
	 *  
	 */
	@Query("select h from Horario h where h.fecha = :fecha and pelicula.estatus='Activa' group by h.pelicula order by pelicula.id asc")
	public List<Horario> findByFecha(@Param("fecha") Date fecha);

}
