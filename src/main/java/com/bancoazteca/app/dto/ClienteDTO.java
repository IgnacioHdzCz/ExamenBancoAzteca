package com.bancoazteca.app.dto;

import lombok.Getter;
import lombok.Setter;


public class ClienteDTO {

	private Long id;
	private String nombre;
	private String correo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public ClienteDTO(Long id, String nombre, String correo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
	}

	public ClienteDTO() {
		super();
	}
}
