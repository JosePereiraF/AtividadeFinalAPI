package br.com.serratec.dtos;

import br.com.serratec.entities.Produto;

import java.math.BigDecimal;

public class ProdutoResponseDTO {
	private String nome;
	private String descricao;
	private BigDecimal precoUnitario;
	private String nomeCategoria;
	
	
	
	
	public ProdutoResponseDTO(Produto produto) {
		super();
		this.nome = produto.getNome();
		this.descricao = produto.getDescricao();
		this.precoUnitario = produto.getPrecoUnitario();
		this.nomeCategoria = produto.getCategoria().getNome();
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(BigDecimal precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	public String getNomeCategoria() {
		return nomeCategoria;
	}
	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	@Override
	public String toString() {
		return "ProdutoResponseDTO [nome=" + nome + ", descricao=" + descricao + ", precoUnitario=" + precoUnitario
				+ ", nomeCategoria=" + nomeCategoria + "]";
	}
	
	
	
}
