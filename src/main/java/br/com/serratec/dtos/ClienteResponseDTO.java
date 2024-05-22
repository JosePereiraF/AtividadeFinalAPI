package br.com.serratec.dtos;

import br.com.serratec.entities.Cliente;
import br.com.serratec.entities.Endereco;

public class ClienteResponseDTO {
	
	private String nome;
	private String telefone;
	private String email;
	private String cpf;
	private Endereco endereco;
	
	public ClienteResponseDTO() {
		
	}
	
	public ClienteResponseDTO(Cliente cliente)
	{
		nome = cliente.getNome();
		telefone = cliente.getTelefone();
		email = cliente.getEmail();
		cpf = cliente.getCpf();
		endereco = cliente.getEndereco();
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
	public String getCpf() {
		return cpf;
	}
	public Endereco getEndereco() {
		return endereco;
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
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	

}
