package br.com.serratec.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.serratec.entities.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long>{
	
//	@Query("SELECT f FROM fornecedor f WHERE f.ativo = true", nativeQuery = true)
//	List<Fornecedor> findAllAtivos();
	
	//retorna todos os fornecedores ativos
	public List<Fornecedor> findByAtivoTrue();
	
	//retorna um fornecedor ativo pelo id
	@Query("SELECT f FROM Fornecedor f WHERE f.id = :id AND f.ativo = true")
    public Optional<Fornecedor> findByIdAndAtivoTrue(@Param("id") Long id);

}
