package br.com.serratec.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.entities.Produto;
import br.com.serratec.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;
	
	
	public List<Produto> listaProdutos(){
		return repository.findAll();		
	}
	
	public Produto produtoPorId(Long id){
		return repository.findById(id).orElse(null);
	}
	
	
	public Produto inserirProduto(Produto produto) {
		return repository.save(produto);
	}
	
	
}
