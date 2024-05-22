package br.com.serratec.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Carrinho {
	
	@EmbeddedId
	private ProdutoPedido id = new ProdutoPedido();
	private Integer quantidade;
	
	private Carrinho () {}

	public ProdutoPedido getId() {
		return id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setId(ProdutoPedido id) {
		this.id = id;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	
	

}
