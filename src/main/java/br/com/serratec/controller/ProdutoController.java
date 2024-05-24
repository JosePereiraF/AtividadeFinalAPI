package br.com.serratec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.dtos.ProdutoRequestDTO;
import br.com.serratec.dtos.ProdutoResponseDTO;
import br.com.serratec.entities.Produto;
import br.com.serratec.services.ProdutoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;
	
	
	@GetMapping
	public ResponseEntity<List<ProdutoResponseDTO>> listarProdutos (){
		 return ResponseEntity.ok(service.listaProdutos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoResponseDTO> mostrarProduto (@PathVariable Long id){
		return ResponseEntity.ok(service.produtoPorId(id));
	}
	
	@PostMapping
	public ResponseEntity<ProdutoResponseDTO> produtoInserir (@Valid @RequestBody ProdutoRequestDTO produto){
		return ResponseEntity.created(null).body(service.inserirProduto(produto));
	}
	
	@PutMapping
	public ResponseEntity<Produto> produtoatualizar(@PathVariable Long id, Produto produto){
	return ResponseEntity.ok(service.produtoatualizar(id,produto));

}
}

