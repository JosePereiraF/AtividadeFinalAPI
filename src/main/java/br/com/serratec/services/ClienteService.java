package br.com.serratec.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.serratec.dtos.ClienteRequestDTO;
import br.com.serratec.dtos.ClienteResponseDTO;
import br.com.serratec.entities.Cliente;
import br.com.serratec.entities.Endereco;
import br.com.serratec.exception.EmailException;
import br.com.serratec.exception.ResourceNotFoundException;
import br.com.serratec.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	private Endereco endereco;

	public List<ClienteResponseDTO> listarClientes() {
		List<Cliente> clientes = repository.findAll();
		return clientes.stream().map((cli) -> new ClienteResponseDTO(cli)).collect(Collectors.toList());
	}

	public ResponseEntity<ClienteResponseDTO> listarClientePorId(Long id) {
		Cliente cli;

		if (repository.existsById(id)) {
			cli = repository.findById(id).get();
			return ResponseEntity.ok(new ClienteResponseDTO(cli));
		}

		else {
			return ResponseEntity.notFound().build();
		}
	}

	public ClienteResponseDTO cadastrarCliente(ClienteRequestDTO clienteRequestDTO) {
		if (repository.findByEmail(clienteRequestDTO.getEmail()) != null) {
			throw new EmailException("E-mail já existente no sistema.");
		}
		Cliente cliente = new Cliente(clienteRequestDTO.getNome(), clienteRequestDTO.getTelefone(),
				clienteRequestDTO.getEmail(), clienteRequestDTO.getCpf(), endereco);
		Cliente clienteSalvo = repository.save(cliente);
		return new ClienteResponseDTO(clienteSalvo);
	}

	public ClienteResponseDTO atualizarCliente(Long id, Cliente cliente) {
		Optional<Cliente> cli = repository.findById(id);
		if (cli.isPresent()) {
			cliente.setId(id);
			return new ClienteResponseDTO(repository.save(cliente));

		} else {
			throw new ResourceNotFoundException("Cliente Inexistente.");
		}	
	}

}
