package br.com.serratec.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.dtos.CarrinhoRequestDTO;
import br.com.serratec.dtos.CarrinhoResponseDTO;
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
	
	public List<CarrinhoResponseDTO> listaCarrinho(){
		return repository.findAll().stream().map(l -> new CarrinhoResponseDTO(l)).collect(Collectors.toList());
	}
	public CarrinhoResponseDTO buscarCarrinho(ProdutoPedidoId id){
		Optional<Carrinho> carrinho = repository.findById(id); // Optional == achar 1 coisa especificar
		if(carrinho.isPresent()) {
			return new CarrinhoResponseDTO(carrinho.get());
		}
		throw new ResourceNotFoundException("Carrinho não encontrado!");
	}
	
	public CarrinhoResponseDTO atualizarCarrinho(Carrinho carrinho, ProdutoPedidoId id) {
		Optional<Carrinho> carrinhoAntigo = repository.findById(id);
		if(carrinhoAntigo == null) throw new ResourceNotFoundException("Carrinho inválido");
		carrinho.setId(id);
		return new CarrinhoResponseDTO(repository.save(carrinho));
		
	}
	public CarrinhoResponseDTO inserirCarrinho(CarrinhoRequestDTO carrinho){

        if(carrinho == null) throw new ResourceNotFoundException("Carrinho inválido");
        Optional<Produto> produto = prodRepository.findById(carrinho.getIdProduto());
        Optional<Pedido> pedido = pedRepository.findById(carrinho.getIdPedido());
        
        Carrinho carrinho1 = new Carrinho(carrinho,pedido.get(),produto.get());
        repository.save(carrinho1);
        carrinho1.getId().setPedido(pedido.get());;
        carrinho1.getId().setProduto(produto.get());
    
        return new CarrinhoResponseDTO(carrinho1);

    }
}
