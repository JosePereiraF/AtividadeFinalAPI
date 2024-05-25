package br.com.serratec.entities;

import br.com.serratec.dtos.CarrinhoRequestDTO;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Carrinho {
	
	@EmbeddedId
	private ProdutoPedidoId id = new ProdutoPedidoId();
	private Integer quantidade;
	
	private Carrinho() {}
	
	

	public Carrinho(CarrinhoRequestDTO carrinho,Pedido pedido, Produto produto) {
		super();
		this.id.setPedido(null);
		this.id.setProduto(null);
		this.quantidade = carrinho.getQuantidade();
	}



	public ProdutoPedidoId getId() {
		return id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setId(ProdutoPedidoId id) {
		this.id = id;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	
	

}
