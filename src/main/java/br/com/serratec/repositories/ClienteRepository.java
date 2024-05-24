package br.com.serratec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	Cliente findByEmail(String email);
	

}
