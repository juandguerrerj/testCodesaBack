package com.gesusuarios.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gesusuarios.controller.response.UsuarioResponse;
import com.gesusuarios.model.Usuario;
import com.gesusuarios.service.UsuarioService;

@RestController
@RequestMapping (value = "/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	private ResponseEntity<List<Usuario>> getAllUsers(){
		return ResponseEntity.ok(usuarioService.findAll());
	}
	
	@GetMapping ("/{name}")
	private ResponseEntity<List<Usuario>> getAllUsersByName(@PathVariable("name") String userName){
		return ResponseEntity.ok(usuarioService.findAllByNombre(userName));
	}
	
	@PostMapping
	private ResponseEntity<UsuarioResponse> saveUser(@RequestBody Usuario usuario){
		
		try {
			Usuario savedUser = usuarioService.saveOrUpdate(usuario);
			UsuarioResponse usrRes = new UsuarioResponse();
			usrRes.setUser(savedUser);
			usrRes.setStatus("OK");
			return new ResponseEntity<UsuarioResponse>(usrRes,HttpStatus.OK);
		} catch (Exception e) {
			UsuarioResponse usrRes = new UsuarioResponse();
			usrRes.setStatus("ERROR");
			usrRes.setMessage(e.getMessage());
			return new ResponseEntity<UsuarioResponse>(usrRes,HttpStatus.OK);
		}
	}
	
	@DeleteMapping (path = "/{id}")
	private ResponseEntity<UsuarioResponse> deleteUser(@PathVariable ("id") Long userId){
		try {
			usuarioService.deleteById(userId);
			UsuarioResponse usrRes = new UsuarioResponse();
			usrRes.setStatus("OK");
			return new ResponseEntity<UsuarioResponse>(usrRes,HttpStatus.OK);
		} catch (Exception e) {
			UsuarioResponse usrRes = new UsuarioResponse();
			usrRes.setStatus("ERROR");
			usrRes.setMessage(e.getMessage());
			return new ResponseEntity<UsuarioResponse>(usrRes,HttpStatus.OK);
		}
	}
	
	@PutMapping 
	private ResponseEntity<UsuarioResponse> updateUser(@RequestBody Usuario usuario){
		try {
			Usuario savedUser = usuarioService.saveOrUpdate(usuario);
			UsuarioResponse usrRes = new UsuarioResponse();
			usrRes.setUser(savedUser);
			usrRes.setStatus("OK");
			return new ResponseEntity<UsuarioResponse>(usrRes,HttpStatus.OK);
		} catch (Exception e) {
			UsuarioResponse usrRes = new UsuarioResponse();
			usrRes.setStatus("ERROR");
			usrRes.setMessage(e.getMessage());
			return new ResponseEntity<UsuarioResponse>(usrRes,HttpStatus.OK);
		}
	}
	
}
