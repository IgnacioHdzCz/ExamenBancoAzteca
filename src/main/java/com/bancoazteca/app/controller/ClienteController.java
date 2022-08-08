package com.bancoazteca.app.controller;

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

import com.bancoazteca.app.dto.ClienteDTO;
import com.bancoazteca.app.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@PostMapping
	public ResponseEntity<ClienteDTO> saveCliente(@RequestBody ClienteDTO clienteDTO){
		return new ResponseEntity<>(clienteService.crearCliente(clienteDTO),HttpStatus.OK);
}
	
	@GetMapping
	public List<ClienteDTO> listarClientes(){
	return clienteService.obtenerClientes();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClienteDTO> obtenerClientePorId (@PathVariable(name= "id") long id) {
		return ResponseEntity.ok(clienteService.findById(id));		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ClienteDTO> actualizarCliente(@RequestBody ClienteDTO clienteDTO, @PathVariable(name ="id") long id){
		ClienteDTO clienteRespuesta = clienteService.actualizarCliente(clienteDTO, id);
		return new ResponseEntity<>(clienteRespuesta,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> eliminarCliente(@PathVariable(name="id") long id){
		clienteService.elimidarCliente(id);
		return new ResponseEntity<>("Cliente eliminado con exito",HttpStatus.OK);
	}

}