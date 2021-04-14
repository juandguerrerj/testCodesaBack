package com.gesusuarios.controller.response;

import com.gesusuarios.model.Usuario;

public class UsuarioResponse {

	private Usuario user;
	private String message;
	private String status;
	
	
	
	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
