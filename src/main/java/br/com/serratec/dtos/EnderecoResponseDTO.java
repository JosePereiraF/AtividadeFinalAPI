package br.com.serratec.dtos;

import br.com.serratec.entities.Endereco;

public class EnderecoResponseDTO {
    private String cep;
    private String logradouro;
    private String complemento;
    private String localidade;
    private String uf;
    private Integer igbe;
    
    public EnderecoResponseDTO(Endereco endereco) {
        cep = endereco.getCep();
        logradouro = endereco.getLogradouro();
        complemento = endereco.getComplemento();
        localidade = endereco.getLocalidade();
        uf = endereco.getUf();
        igbe = endereco.getIgbe();
    }
    
    public String getCep() {
        return cep;
    }
    
    public void setCep(String cep) {
        this.cep = cep;
    }
    
    public String getLogradouro() {
        return logradouro;
    }
    
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    
    public String getComplemento() {
        return complemento;
    }
    
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
    public String getLocalidade() {
        return localidade;
    }
    
    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }
    
    public String getUf() {
        return uf;
    }
    
    public void setUf(String uf) {
        this.uf = uf;
    }
    
    public Integer getIgbe() {
        return igbe;
    }
    
    public void setIgbe(Integer igbe) {
        this.igbe = igbe;
    }
}
