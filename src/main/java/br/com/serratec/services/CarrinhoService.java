package br.com.serratec.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.dtos.CarrinhoRequestDTO;
import br.com.serratec.entities.Carrinho;
import br.com.serratec.entities.Pedido;
import br.com.serratec.entities.Produto;
import br.com.serratec.entities.ProdutoPedidoId;
import br.com.serratec.exception.ResourceNotFoundException;
import br.com.serratec.repositories.CarrinhoRepository;
import br.com.serratec.repositories.PeditoRepository;
import br.com.serratec.repositories.ProdutoRepository;

@Service
public class CarrinhoService {
	
	@Autowired
	private CarrinhoRepository repository;
	@Autowired
	private ProdutoRepository prodRepository;
	@Autowired
	private PeditoRepository pedRepository;
	
	public List<Carrinho> listaCarrinho(){
		return repository.findAll();
	}
	public Carrinho buscarCarrinho(ProdutoPedidoId id){
		Optional<Carrinho> carrinho = repository.findById(id); // Optional == achar 1 coisa especificar
		if(carrinho.isPresent()) {
			return carrinho.get();
		}
		throw new ResourceNotFoundException("Carrinho não encontrado!");
	}
	public Carrinho inserirCarrinho(CarrinhoRequestDTO carrinho){
		if(carrinho == null) throw new ResourceNotFoundException("Carrinho inválido");
		Optional<Produto> produto = prodRepository.findById(carrinho.getIdProduto());
		Optional<Pedido> pedido = pedRepository.findById(carrinho.getIdProduto());
		System.out.println(produto.get());
		System.out.println(pedido.get());
		return repository.save(new Carrinho(carrinho,pedido.get(),produto.get()));
		
	}
	public Carrinho atualizarCarrinho(Carrinho carrinho, ProdutoPedidoId id) {
		Optional<Carrinho> carrinhoAntigo = repository.findById(id);
		if(carrinhoAntigo == null) throw new ResourceNotFoundException("Carrinho inválido");
		carrinho.setId(id);
		return repository.save(carrinho);
	}
	
}
