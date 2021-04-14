package com.gesusuarios.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table (name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_usuario;
	private String nombre;
	private char activo;
	/*@ManyToOne
	@JoinColumn (name = "id_rol")
	private Rol id_rol;*/
	private int id_rol;
	
	public Usuario() {
	}
	
	public Usuario(String nombre, char estado, int rol) {
		super();
		this.nombre = nombre;
		this.activo = estado;
		this.id_rol = rol;
	}
	public Long getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public char getActivo() {
		return activo;
	}
	public void setActivo(char estado) {
		this.activo = estado;
	}
	public int getRol_id() {
		return id_rol;
	}
	public void setRol_id(int rol) {
		this.id_rol = rol;
	}
}
