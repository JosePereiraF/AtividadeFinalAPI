package br.com.serratec.dtos;

import br.com.serratec.entities.Fornecedor;

public class FornecedorResponseDTO {

	private String nome;
	private String telefone;
	private String email;
	
	private String nomeCategoria;
	
	public FornecedorResponseDTO (Fornecedor fornecedor)
	{
		nome = fornecedor.getNome();
		telefone = fornecedor.getTelefone();
		email = fornecedor.getEmail();
		nomeCategoria = fornecedor.getCategoria().getNome();
		
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

	public String getNomeCategoria() {
		return nomeCategoria;
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


	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	
	
	
}
