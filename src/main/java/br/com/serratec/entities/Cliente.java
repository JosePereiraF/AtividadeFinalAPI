package br.com.serratec.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String telefone;
	private String email;
	private String cpf;
	@JsonManagedReference
	@OneToMany(mappedBy = "cliente")
	private List<Pedido> pedidos;

	public Cliente() {
	
	}
	

	public Cliente(String nome, String telefone, String email, String cpf) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.cpf = cpf;
	}


	public Long getId() {
		return id;
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

	public void setId(Long id) {
		this.id = id;
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

}
