package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

}
