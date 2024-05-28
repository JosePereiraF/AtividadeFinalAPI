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
	private Imagem imagem;
	private String processador;
	private String chipset;
	private String armazenamento;
	private String tamTela;
	private String camera;
	private String ram;
	private Double precoUnitario;
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;
	@OneToMany(mappedBy = "id.produto", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Carrinho> carrinho = new HashSet<>();

	public Produto() {
	}

	public Produto(ProdutoRequestDTO produto) {
		nome = produto.getNome();
		this.processador = produto.getProcessador();
        this.chipset = produto.getChipset();
        this.armazenamento = produto.getArmazenamento();
        this.tamTela = produto.getTamTela();
        this.camera = produto.getCamera();
		this.precoUnitario = produto.getPrecoUnitario();
		this.categoria = produto.getCategoria();
		this.ram = produto.getRam();
		this.imagem = produto.getImg();
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

	public void setPrecoUnitario(Double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getProcessador() {
		return processador;
	}

	public void setProcessador(String processador) {
		this.processador = processador;
	}

	public String getChipset() {
		return chipset;
	}

	public void setChipset(String chipset) {
		this.chipset = chipset;
	}

	public String getArmazenamento() {
		return armazenamento;
	}

	public void setArmazenamento(String armazenamento) {
		this.armazenamento = armazenamento;
	}

	public String getTamTela() {
		return tamTela;
	}

	public void setTamTela(String tamTela) {
		this.tamTela = tamTela;
	}

	public String getCamera() {
		return camera;
	}

	public void setCamera(String camera) {
		this.camera = camera;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public Imagem getImagem() {
		return imagem;
	}

	public void setImagem(Imagem imagem) {
		this.imagem = imagem;
	}
	

	
}
