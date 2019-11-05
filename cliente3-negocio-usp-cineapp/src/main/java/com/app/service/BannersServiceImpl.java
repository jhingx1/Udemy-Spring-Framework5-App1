package com.app.service;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import com.app.model.Banner;

//@Service
public class BannersServiceImpl implements IBannersService {

	private List<Banner> lista = null; 
	/**
	 * En el constructor creamos una lista enlazada con objetos de tipo Banner
	 */
	public BannersServiceImpl() {
		
		System.out.println("Instancia de la clase BannerServiceImpl");
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy");
				
		try {			
			// Ejercicio: Crear una nueva lista enlazada		
			lista = new LinkedList<Banner>();
			
			// Ejercicio: Crear algunos objetos de tipo Banner (estaticos)
			Banner banner1 = new Banner();
			banner1.setId(1);
			banner1.setTitulo("banner1");
			banner1.setFecha(formatter.parse("02-05-2019"));
			banner1.setArchivo("slide1.jpg");
			banner1.setEstatus("activo");
			
			Banner banner2 = new Banner();
			banner2.setId(2);
			banner2.setTitulo("banner1");
			banner2.setFecha(formatter.parse("03-05-2019"));
			banner2.setArchivo("slide2.jpg");
			banner2.setEstatus("activo");
			
			Banner banner3 = new Banner();
			banner3.setId(3);
			banner3.setTitulo("banner3");
			banner3.setFecha(formatter.parse("12-05-2019"));
			banner3.setArchivo("slide3.jpg");
			banner3.setEstatus("activo");
			
			Banner banner4 = new Banner();
			banner4.setId(4);
			banner4.setTitulo("banner4");
			banner4.setFecha(formatter.parse("02-06-2019"));
			banner4.setArchivo("slide4.jpg");
			banner4.setEstatus("activo");			
				
			// Ejercicio: Agregar los objetos Banner a la lista
			
			lista.add(banner1);
			lista.add(banner2);
			lista.add(banner3);
			lista.add(banner4);
			
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
		}
		
		System.out.println("Lista banner : " + lista);
		
	}

	/**
	 * Insertamos un objeto de tipo Banner a la lista
	 */
	@Override
	public void insertar(Banner banner) {
		
		// Ejercicio: Implementar metodo
		lista.add(banner);
		
	}

	/**
	 * Regresamos la lista de objetos Banner
	 */
	@Override
	public List<Banner> buscarTodos() {		
		
		// Ejercicio: Implementar metodo			
		return lista;
		
	}

	@Override
	public List<Banner> buscarActivos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Banner buscarPorId(int idBanner) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(int idBanner) {
		// TODO Auto-generated method stub
		
	}

}
