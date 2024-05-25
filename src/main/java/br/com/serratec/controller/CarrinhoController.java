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

import br.com.serratec.entities.Carrinho;
import br.com.serratec.entities.ProdutoPedidoId;
import br.com.serratec.services.CarrinhoService;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {
	
	@Autowired
	private CarrinhoService service;
	
	@GetMapping
	public ResponseEntity<List<Carrinho>> listaCarrinho(){
		return ResponseEntity.ok(service.listaCarrinho());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Carrinho> buscarCarrinho(@PathVariable ProdutoPedidoId id){
		return ResponseEntity.ok(service.buscarCarrinho(id));
	}
	
	@PostMapping
	public ResponseEntity<Carrinho> inserirCarrinho(@RequestBody Carrinho carrinho){
		return ResponseEntity.created(null).body(service.inserirCarrinho(carrinho));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Carrinho> atualizarCarrinho(@PathVariable ProdutoPedidoId id,@RequestBody Carrinho carrinho){
		return ResponseEntity.ok(service.atualizarCarrinho(carrinho, id)); 
	}
}
