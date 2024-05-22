package br.com.serratec.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Carrinho {
	
	@EmbeddedId
	private ProdutoPedidoId id = new ProdutoPedidoId();
	private Integer quantidade;
	
	private Carrinho () {}

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
