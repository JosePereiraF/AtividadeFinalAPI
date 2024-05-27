package br.com.serratec.dtos;

import br.com.serratec.entities.Categoria;
import br.com.serratec.entities.Fornecedor;

public class FornecedorResponseDTO {

	private String nome;
	private String telefone;
	private String email;
	
	private Categoria categoria;
	
	public FornecedorResponseDTO (Fornecedor fornecedor)
	{
		nome = fornecedor.getNome();
		telefone = fornecedor.getTelefone();
		email = fornecedor.getEmail();
		categoria = fornecedor.getCategoria();
	}

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
