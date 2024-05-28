package br.com.serratec.dtos;

import br.com.serratec.entities.Carrinho;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class PedidoItemDTO {
	@NotNull
	private String nomeProduto;
	@NotNull
	private BigDecimal valorPedido;
	@Positive
	private Integer quantidade;

	public PedidoItemDTO(Carrinho produto) {
		this.nomeProduto = produto.getId().getProduto().getNome();
		this.valorPedido = produto.getId().getProduto().getPrecoUnitario();
		this.quantidade = produto.getQuantidade();
		
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public BigDecimal getValorPedido() {
		return valorPedido;
	}
	public void setValorPedido(BigDecimal valorPedido) {
		this.valorPedido = valorPedido;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
