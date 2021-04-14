package com.gesusuarios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.gesusuarios.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

	public List<Usuario> findAllByNombreIsContainingIgnoreCase(String nombre);
	
	public List<Usuario> findAll();
	
}
