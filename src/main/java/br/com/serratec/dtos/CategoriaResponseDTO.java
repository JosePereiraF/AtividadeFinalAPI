package br.com.serratec.dtos;

import java.util.List;

import br.com.serratec.entities.Categoria;
import br.com.serratec.entities.Produto;

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
