package com.gesusuarios.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.gesusuarios.model.Usuario;
import com.gesusuarios.repository.UsuarioRepository;

@Service
public class UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> findAll(){		
		return usuarioRepository.findAll();		
	}
	
	public Usuario saveOrUpdate(Usuario entity) throws Exception {
		List<Usuario> usuarios = usuarioRepository.findAllByNombreIsContainingIgnoreCase(entity.getNombre());
		if (entity.getId_usuario() == null || entity.getId_usuario().equals(0)) {
			/*Creando el usuario*/
			if (usuarios != null && !usuarios.isEmpty()) {
				throw new Exception("El usuario ya existe");
			}
		}else {
			/*Modificando el usuario*/
			for (Usuario usuario : usuarios) {
				if (!usuario.getId_usuario().equals(entity.getId_usuario())) {
					throw new Exception("El usuario ya existe");
				}
			}
		}
		
		return usuarioRepository.save(entity);
	}
	
	public void deleteById(Long id) {
		usuarioRepository.deleteById(id);
	}
	
	public List<Usuario> findAllByNombre(String nombre){
		return usuarioRepository.findAllByNombreIsContainingIgnoreCase(nombre);
	}
}
