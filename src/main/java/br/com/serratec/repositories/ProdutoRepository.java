package br.com.serratec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
}
