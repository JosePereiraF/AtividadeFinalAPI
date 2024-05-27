package br.com.serratec.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.serratec.dtos.FornecedorRequestDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Fornecedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String telefone;
	private String email;
	private Boolean ativo;

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;
	
	public Fornecedor() {
		ativo = true;
	}
	
	public Fornecedor (FornecedorRequestDTO fornecedorRequestDTO)
	{
		nome = fornecedorRequestDTO.getNome();
		telefone = fornecedorRequestDTO.getTelefone();
		email = fornecedorRequestDTO.getEmail();
		categoria = fornecedorRequestDTO.getCategoria();
		ativo = true;
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

	public Categoria getCategoria() {
		return categoria;
	}

	public Boolean getAtivo() {
		return ativo;
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

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	

}
