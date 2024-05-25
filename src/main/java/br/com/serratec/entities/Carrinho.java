package br.com.serratec.entities;

import br.com.serratec.dtos.CarrinhoRequestDTO;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Carrinho {
	
	@EmbeddedId
	private ProdutoPedidoId id = new ProdutoPedidoId();
	private Integer quantidade;
	
	public Carrinho(CarrinhoRequestDTO carrinho,Pedido pedido, Produto produto) {
		super();
		this.id.setPedido(pedido);
		this.id.setProduto(produto);
		this.quantidade = carrinho.getQuantidade();
	}


	
	public Carrinho() {
		super();
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



	@Override
	public String toString() {
		return "Carrinho [id=" + id + ", quantidade=" + quantidade + ", getId()=" + getId() + ", getQuantidade()="
				+ getQuantidade() + "]";
	}
	
	
	

}
