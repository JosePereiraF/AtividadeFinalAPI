package br.com.serratec.dtos;

import br.com.serratec.customannotation.Telefone;
import br.com.serratec.entities.Categoria;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class FornecedorRequestDTO {
	@NotBlank
	private String nome;
	@Telefone
	private String telefone;
	@Email
	private String email;
	@NotNull 
	private Categoria categoria;

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
