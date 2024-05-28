package br.com.serratec.dtos;

import br.com.serratec.entities.Categoria;
import br.com.serratec.entities.Imagem;
import br.com.serratec.entities.Produto;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProdutoRequestDTO {
    @NotBlank
    private String nome;
    @NotNull
    private Imagem img;
    @NotBlank
    private String processador;
    @NotBlank
	private String chipset;
    @NotBlank
	private String armazenamento;
    @NotBlank
	private String tamTela;
    @NotBlank
	private String camera;
    @NotBlank
    private String ram;
    @DecimalMin(value = "0.10")//testar se iss funciona
    @NotNull
    private Double precoUnitario;
    @NotNull
    private Categoria categoria;
    
    public ProdutoRequestDTO() {
    }
    
    public ProdutoRequestDTO(Produto produto) {
        this.nome = produto.getNome();
        this.processador = produto.getProcessador();
        this.chipset = produto.getChipset();
        this.armazenamento = produto.getArmazenamento();
        this.tamTela = produto.getTamTela();
        this.camera = produto.getCamera();
        this.precoUnitario = produto.getPrecoUnitario();
        this.categoria = produto.getCategoria();
        this.ram = produto.getRam();
        this.img = produto.getImagem();
        
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
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

	public Double getPrecoUnitario() {
        return precoUnitario;
    }
    
    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
    
    public Categoria getCategoria() {
        return categoria;
    }
    
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

	public Imagem getImg() {
		return img;
	}

	public void setImg(Imagem img) {
		this.img = img;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}
    
}
