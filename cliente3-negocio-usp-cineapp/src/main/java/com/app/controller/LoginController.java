package com.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class LoginController {

	@GetMapping(value = "/logout")
	public String logout(HttpServletRequest request) {
		SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
		logoutHandler.logout(request, null, null);
		//return "redirect:/login"; ruta por default
		return "redirect:/formLogin";
	}
	
	@GetMapping(value="/index")
	public String mostrarPrincipalAdmin(Authentication authentication) {
		
		//recuperar nombre de usuario - log de usuario
		System.out.println("username : " + authentication.getName());
		
		for(GrantedAuthority rol:authentication.getAuthorities())
			System.out.println("ROL : " + rol.getAuthority());
		
		return "admin";
	}

}
