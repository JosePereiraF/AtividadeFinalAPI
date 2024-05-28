package br.com.serratec.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	@ManyToOne
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;
	@JsonManagedReference
	@OneToMany(mappedBy = "cliente")
	private List<Pedido> pedidos;

	public Cliente() {

	}

	public Cliente(String nome, String telefone, String email, String cpf, Endereco endereco) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.cpf = cpf;
		this.endereco = endereco;
	}

	public Endereco getEndereco() {
		return endereco;
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

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "\nDados do Cliente: \nCliente: " + nome + "\nNúmero de Telefone:" + telefone + "\nEmail:" + email + "\nCPF:" + cpf;
	}
	
	
}
