package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Perfil;
import com.app.model.Usuario;
import com.app.service.IPerfilesService;
import com.app.service.IUsuariosService;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private IUsuariosService serviceUsuarios;
	
	@Autowired
	private IPerfilesService servicePerfiles;
	
	@GetMapping("/demo-bcrypt")
	public String pruebaBcrypt() {
		String password = "mari123";
		String encriptado = encoder.encode(password);
		System.out.println("Password encriptado: " + encriptado);
		return "usuarios/demo";
	}
	
	@GetMapping("/crear")
	public String crear(@ModelAttribute Usuario usuario) {
		//usuario es que vamos a colocar en el formulario
		return "usuarios/formUsuario";
	}
	
	@PostMapping("/save")
	public String guardar(@ModelAttribute Usuario usuario,@RequestParam("perfil") String perfil) {
		System.out.println("Usuario " + usuario);
		System.out.println("Perfil : " + perfil); //para luego guardar en la db
		
		//guardar objetos en la base de datos
		String tmpPass = usuario.getPwd(); //regresa la contraseña
		String encriptado = encoder.encode(tmpPass); //pass encriptado
		
		usuario.setPwd(encriptado); //cambiando la contraseña
		usuario.setActivo(1); //para que el usuario este activado por default
		
		//en DB
		serviceUsuarios.guardar(usuario);
		
		//para guardar un objeto de tipo perfil
		Perfil perfilTmp = new Perfil();
		perfilTmp.setCuenta(usuario.getCuenta());
		perfilTmp.setPerfil(perfil);
		
		//en DB
		servicePerfiles.guardar(perfilTmp);
				
		return "redirect:/usuarios/index";
	}
	
	@GetMapping("/index")
	public String index() {
		return "usuarios/listUsuarios";
	}
		
}
