package br.com.serratec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
