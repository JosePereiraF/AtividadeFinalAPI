package br.com.serratec.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.entities.Carrinho;
import br.com.serratec.entities.ProdutoPedidoId;
import br.com.serratec.exception.ResourceNotFoundException;
import br.com.serratec.repositories.CarrinhoRepository;

@Service
public class CarrinhoService {
	
	@Autowired
	private CarrinhoRepository repository;
	
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
	public Carrinho inserirCarrinho(Carrinho carrinho){
		if(carrinho == null) throw new ResourceNotFoundException("Carrinho inválido");
		return repository.save(carrinho);
	}
	public Carrinho atualizarCarrinho(Carrinho carrinho, ProdutoPedidoId id) {
		Optional<Carrinho> carrinhoAntigo = repository.findById(id);
		if(carrinhoAntigo == null) throw new ResourceNotFoundException("Carrinho inválido");
		carrinho.setId(id);
		return repository.save(carrinho);
	}
	
}
