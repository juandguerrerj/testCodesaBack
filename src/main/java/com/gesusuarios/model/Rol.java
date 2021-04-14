package com.gesusuarios.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "rol")
public class Rol {

	@Id
	@Column(nullable=false)
	private int id_rol;
	private String nombre;
	
	public Rol() {
	}
		
	public Rol(String nombre) {
		super();
		this.nombre = nombre;
	}
	public int getId_rol() {
		return id_rol;
	}
	public void setId_rol(int id_rol) {
		this.id_rol = id_rol;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
