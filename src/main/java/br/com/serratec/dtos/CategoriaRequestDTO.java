package br.com.serratec.dtos;

import jakarta.validation.constraints.NotBlank;

public class CategoriaRequestDTO {
	
	@NotBlank
	private String nome;
	@NotBlank
	private String descricao;
	
	public CategoriaRequestDTO() 
	{
		
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
