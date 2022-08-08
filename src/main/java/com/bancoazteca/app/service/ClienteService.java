package com.bancoazteca.app.service;

import java.util.List;

import com.bancoazteca.app.dto.ClienteDTO;
import com.bancoazteca.app.entity.Cliente;

public interface ClienteService {
	
	public ClienteDTO crearCliente(ClienteDTO clienteDTO);
	public List<ClienteDTO> obtenerClientes();
	public ClienteDTO findById(long id);
	public ClienteDTO actualizarCliente(ClienteDTO clienteDTO, long id);
	public void elimidarCliente(long id);
}
