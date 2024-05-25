package br.com.serratec.dtos;

import br.com.serratec.entities.Carrinho;

public class PedidoItemDTO {

	private String nomeProduto;
	private Double valorPedido;
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
	public Double getValorPedido() {
		return valorPedido;
	}
	public void setValorPedido(Double valorPedido) {
		this.valorPedido = valorPedido;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
