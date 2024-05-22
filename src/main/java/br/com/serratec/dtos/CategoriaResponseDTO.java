package br.com.serratec.dtos;

import br.com.serratec.entities.Categoria;

public class CategoriaResponseDTO {

	private String nome;
	private String descricao;

	public CategoriaResponseDTO(Categoria categoria) {
		nome = categoria.getNome();
		descricao = categoria.getDescricao();
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
