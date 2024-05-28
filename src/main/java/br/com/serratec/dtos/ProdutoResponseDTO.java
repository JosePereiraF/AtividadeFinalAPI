package br.com.serratec.dtos;

import br.com.serratec.entities.Imagem;
import br.com.serratec.entities.Produto;

public class ProdutoResponseDTO {
	private Long id;
	private String nome;
	private Imagem img;
	private String processador;
	private String chipset;
	private String armazenamento;
	private String tamTela;
	private String camera;
	private Double precoUnitario;
	private String nomeCategoria;
	private String ram;

	public ProdutoResponseDTO(Produto produto) {
		super();
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.processador = produto.getProcessador();
		this.chipset = produto.getChipset();
		this.armazenamento = produto.getArmazenamento();
		this.tamTela = produto.getTamTela();
		this.camera = produto.getCamera();
		this.precoUnitario = produto.getPrecoUnitario();
		this.nomeCategoria = produto.getCategoria().getNome();
		this.ram = produto.getRam();
		this.img = produto.getImagem();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(Double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
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

	public Imagem getImg() {
		return img;
	}

	public void setImg(Imagem img) {
		this.img = img;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	


}
