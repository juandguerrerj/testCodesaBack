package com.gesusuarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gesusuarios.model.Rol;
import com.gesusuarios.service.RolService;

@RestController
@RequestMapping (value = "/rol/")
public class RolController {
	
	@Autowired
	private RolService rolService;
	
	@GetMapping
	private ResponseEntity<List<Rol>> getAllRoles(){
		return ResponseEntity.ok(rolService.findAll());
	}
}
