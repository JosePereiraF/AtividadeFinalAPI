package br.com.serratec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.entities.Funcionario;


public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
	
}
