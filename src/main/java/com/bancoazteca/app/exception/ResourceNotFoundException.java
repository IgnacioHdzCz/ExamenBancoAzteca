package com.bancoazteca.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;
import lombok.Setter;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String nombreDelCliente;
	private String nombreDelCampo;
	private Long valorDelId;
	public ResourceNotFoundException(String nombreDelCliente, String nombreDelCampo, Long valorDelId) {
		super(String.format("%s cliente no existe : %s : '%s'", nombreDelCliente, nombreDelCampo,valorDelId));
		this.nombreDelCliente = nombreDelCliente;
		this.nombreDelCampo = nombreDelCampo;
		this.valorDelId = valorDelId;
	}
	public String getNombreDelCliente() {
		return nombreDelCliente;
	}
	public void setNombreDelCliente(String nombreDelCliente) {
		this.nombreDelCliente = nombreDelCliente;
	}
	public String getNombreDelCampo() {
		return nombreDelCampo;
	}
	public void setNombreDelCampo(String nombreDelCampo) {
		this.nombreDelCampo = nombreDelCampo;
	}
	public Long getValorDelId() {
		return valorDelId;
	}
	public void setValorDelId(Long valorDelId) {
		this.valorDelId = valorDelId;
	}
	
}
