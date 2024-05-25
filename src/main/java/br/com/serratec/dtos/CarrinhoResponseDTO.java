package br.com.serratec.dtos;

import br.com.serratec.entities.Carrinho;

public class CarrinhoResponseDTO {
	
	private Integer numeroDoPedido;
	
	private PedidoItemDTO produtos;
	
	
	
	public CarrinhoResponseDTO(Carrinho carrinho) {
		super();
		this.numeroDoPedido = carrinho.getId().getPedido().getNumeroDoPedido();
		this.produtos = new PedidoItemDTO(carrinho);
	}

	public CarrinhoResponseDTO() {
		super();
	}

	public Integer getNumeroDoPedido() {
		return numeroDoPedido;
	}

	public void setNumeroDoPedido(Integer numeroDoPedido) {
		this.numeroDoPedido = numeroDoPedido;
	}

	public PedidoItemDTO getProdutos() {
		return produtos;
	}

	public void setProdutos(PedidoItemDTO produtos) {
		this.produtos = produtos;
	}
	

	
	
	
}
