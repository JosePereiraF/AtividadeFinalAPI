package br.com.serratec.entities;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.serratec.dtos.ProdutoRequestDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;
	private Double precoUnitario;
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;
	@OneToMany(mappedBy = "id.produto", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Carrinho> carrinho = new HashSet<>();
	
	public Produto() {}
	



	public Produto(ProdutoRequestDTO produto) {
		nome = produto.getNome();
		descricao = produto.getDescricao();
		precoUnitario = produto.getPrecoUnitario();
		categoria = produto.getCategoria();
	}
	

	public Set<Carrinho> getCarrinho() {
		return carrinho;
	}




	public void setCarrinho(Set<Carrinho> carrinho) {
		this.carrinho = carrinho;
	}




	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public Double getPrecoUnitario() {
		return precoUnitario;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setPrecoUnitario(Double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}




	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", precoUnitario=" + precoUnitario
				+ ", categoria=" + categoria + ", carrinho=" + carrinho + "]";
	}
	
	

}
