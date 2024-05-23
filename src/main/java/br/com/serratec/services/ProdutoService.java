package br.com.serratec.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.dtos.ProdutoRequestDTO;
import br.com.serratec.dtos.ProdutoResponseDTO;
import br.com.serratec.entities.Categoria;
import br.com.serratec.entities.Produto;
import br.com.serratec.repositories.CategoriaRepository;
import br.com.serratec.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;
	
	@Autowired
	private CategoriaRepository catRepository;
	
	public List<ProdutoResponseDTO> listaProdutos(){
		return repository.findAll().stream().map(prod-> new ProdutoResponseDTO(prod)).collect(Collectors.toList());		
	}
	
	public ProdutoResponseDTO produtoPorId(Long id){
		Optional<Produto> produto = repository.findById(id);
		
		if(produto.isPresent()) {
			return new ProdutoResponseDTO(produto.get());
		}
		return null;
		
	}
		
	public ProdutoResponseDTO inserirProduto(ProdutoRequestDTO produto) {
		Optional<Categoria> categoria = catRepository.findById(produto.getCategoria().getId());
		if(categoria.isPresent()) {
			produto.setCategoria(categoria.get());
			Produto produtosave = repository.save(new Produto(produto));
			System.out.println(new ProdutoResponseDTO(produtosave).toString());
			return new ProdutoResponseDTO(produtosave);		
		}
		else return null;
		
	}
	
	
}
