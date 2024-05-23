package br.com.serratec.dtos;

import br.com.serratec.entities.Categoria;
import br.com.serratec.entities.Produto;

public class ProdutoRequestDTO {
    
    private String nome;
    private String descricao;
    private Double precoUnitario;
    private Categoria categoria;
    
    public ProdutoRequestDTO() {
    }
    
    public ProdutoRequestDTO(Produto produto) {
        nome = produto.getNome();
        descricao = produto.getDescricao();
        precoUnitario = produto.getPrecoUnitario();
        categoria = produto.getCategoria();
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
}
