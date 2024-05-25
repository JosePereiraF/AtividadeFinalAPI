package br.com.serratec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.dtos.ClienteRequestDTO;
import br.com.serratec.dtos.ClienteResponseDTO;
import br.com.serratec.entities.Cliente;
import br.com.serratec.services.ClienteService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping("/listarClientes")
	public List<ClienteResponseDTO> listarClientes() {
		return service.listarClientes();
	}
	
	@GetMapping("/listarClientePorId/{id}")
	public ResponseEntity<ClienteResponseDTO> listarClientePorId(@PathVariable Long id) {
		return ResponseEntity.ok(service.listarClientePorId(id));
		
	}
	
	@PostMapping("/cadastrar/{cep}")
		public ResponseEntity<ClienteResponseDTO> cadastrarCliente(@Valid @RequestBody ClienteRequestDTO clienteRequestDTO,@PathVariable String cep) {
		return ResponseEntity.created(null).body(service.cadastrarCliente(cep,clienteRequestDTO));
		
	}
	
	@PutMapping("/atualizar/{id}")
	public ClienteResponseDTO atualizarCliente ( @Valid @PathVariable Long id, @RequestBody Cliente cliente)
	{
		return service.atualizarCliente(id, cliente);
	}
}
