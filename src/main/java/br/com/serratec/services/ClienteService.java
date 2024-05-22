package br.com.serratec.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.serratec.dtos.ClienteResponseDTO;
import br.com.serratec.entities.Cliente;
import br.com.serratec.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	public List<ClienteResponseDTO> listarClientes()
	{
		List<Cliente> clientes = repository.findAll();
		return clientes.stream().map((cli) -> new ClienteResponseDTO(cli)).collect(Collectors.toList());
	}
	
	public ResponseEntity<ClienteResponseDTO> listarClientePorId (Long id)
	{
		Cliente cli; 
		
		if(repository.existsById(id)) 
		{
			cli = repository.findById(id).get();
			return  ResponseEntity.ok(new ClienteResponseDTO(cli));
		}
		
		else 
		{
			return ResponseEntity.notFound().build();
		}
	}
	
}