package br.com.serratec.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.serratec.dtos.CategoriaRequestDTO;
import br.com.serratec.dtos.CategoriaResponseDTO;
import br.com.serratec.entities.Categoria;
import br.com.serratec.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired // Repoistório de Categorias
	private CategoriaRepository repository;

	public List<CategoriaResponseDTO> listarCategorias() {
		/*
		 * usuarios.stream().map((u) -> new
		 * UsuarioResponseDTO(u)).collect(Collectors.toList());
		 */

		List<Categoria> categorias = repository.findAll();
		return categorias.stream().map((cat) -> new CategoriaResponseDTO(cat)).collect(Collectors.toList());
	}

	public CategoriaResponseDTO adicionarCategoria(CategoriaRequestDTO categoria) {
		// nova instância de categoria
		Categoria cat = new Categoria();

		// preenchendo com os dados obtidos do RequestDTO
		cat.setNome(categoria.getNome());
		cat.setDescricao(categoria.getDescricao());
		repository.save(cat);

		return new CategoriaResponseDTO(cat);

	}
	
	public ResponseEntity<Categoria> atualizarCategoria( Long id, CategoriaRequestDTO categoria)
	{
		Categoria catAtualizada;
		
		if(repository.existsById(id))
		{
			catAtualizada = new Categoria(id, categoria.getNome(),categoria.getDescricao());
			return ResponseEntity.ok(repository.save(catAtualizada));
		}
		
		else
		{
			return ResponseEntity.notFound().build();
		}
		
	}

}
