package com.bancoazteca.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bancoazteca.app.dto.ClienteDTO;
import com.bancoazteca.app.entity.Cliente;
import com.bancoazteca.app.exception.ResourceNotFoundException;
import com.bancoazteca.app.repository.ClienteRepository;

@Service
public class ClientesServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public ClienteDTO crearCliente(ClienteDTO clienteDTO) {
		
//		Cliente cliente = new Cliente ();
//		cliente.setNombre(clienteDTO.getNombre());
//		cliente.setCorreo(clienteDTO.getCorreo());
//		
//		Cliente clienteNuevo = clienteRepository.save(cliente);
//		
//		ClienteDTO clienteRespuesta = new ClienteDTO();
//		clienteRespuesta.setId(clienteNuevo.getId());
//		clienteRespuesta.setNombre(clienteNuevo.getNombre());
//		clienteRespuesta.setCorreo(clienteNuevo.getCorreo());
//		return clienteRespuesta;
		
		Cliente cliente = mappearEntidad(clienteDTO);
		
		Cliente nuevoCliente = clienteRepository.save(cliente);
		
		ClienteDTO clienteRespuesta = mappearDTO(nuevoCliente);
		
		return clienteRespuesta;
		
		
		
		
	}

	@Override
	public List<ClienteDTO> obtenerClientes() {
		List<Cliente> clientes = clienteRepository.findAll();
		return clientes.stream().map(cliente ->  mappearDTO(cliente)).collect(Collectors.toList());
		
	}

	// convierte entity a  DTO
	private ClienteDTO mappearDTO (Cliente cliente) {
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setId(cliente.getId());
		clienteDTO.setNombre(cliente.getNombre());
		clienteDTO.setCorreo(cliente.getCorreo());
		return clienteDTO;
	}
	
	
	// convierte DTO a  DTO
	private Cliente mappearEntidad (ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente();

		cliente.setNombre(clienteDTO.getNombre());
		cliente.setCorreo(clienteDTO.getCorreo());
		return cliente;
	}
	@Override
	public ClienteDTO findById(long id) {
		Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente","id", id));
		return mappearDTO(cliente);
	}
	@Override
	public ClienteDTO actualizarCliente(ClienteDTO clienteDTO, long id) {
	Cliente cliente = clienteRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Cliente", "id", id)) ;
	cliente.setCorreo(clienteDTO.getCorreo());
	cliente.setNombre(clienteDTO.getNombre());
	Cliente clienteActualizado = clienteRepository.save(cliente);
	return mappearDTO(clienteActualizado);
	}
	@Override
	public void elimidarCliente(long id) {
		Cliente cliente = clienteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Cliente", "id", id)) ;
		clienteRepository.delete(cliente);
	}
}
