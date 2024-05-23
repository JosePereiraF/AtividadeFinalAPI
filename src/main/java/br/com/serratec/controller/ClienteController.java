package br.com.serratec.controller;

import java.util.List;

import br.com.serratec.dtos.ClienteRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.serratec.dtos.ClienteResponseDTO;
import br.com.serratec.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping("/listarClientes")
	public List<ClienteResponseDTO> listarClientes() {
		return service.listarClientes();
	}
	
	@GetMapping("/listarClientePorId/id")
	public ResponseEntity<ClienteResponseDTO> listarClientePorId(@PathVariable Long id) {
		return service.listarClientePorId(id);
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<ClienteResponseDTO> cadastrarCliente(@RequestBody ClienteRequestDTO clienteRequestDTODTO) {
		ClienteResponseDTO clienteResponseDTO = service.cadastrarCliente(clienteRequestDTODTO);
		return ResponseEntity.ok(clienteResponseDTO);
		
	}
}
