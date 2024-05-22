package br.com.serratec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.entities.Produto;
import br.com.serratec.services.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;
	
	
	@GetMapping
	public ResponseEntity<List<Produto>> listarProdutos (){
		 return ResponseEntity.ok(service.listaProdutos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> mostrarProduto (@PathVariable Long id){
		return ResponseEntity.ok(service.produtoPorId(id));
	}
	
	@PostMapping
	public ResponseEntity<Produto> produtoInserir (@RequestBody Produto produto){
		return ResponseEntity.created(null).body(service.inserirProduto(produto));
	}
	
}
