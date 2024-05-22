package br.com.serratec.entities;

import br.com.serratec.enums.EstadoEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cep;
	private EstadoEnum uf;
	private String localidade;
	private String bairro;
	private String logradouro;
	private String numero;
	private String complemento;
	
	public Endereco () {}

	public Long getId() {
		return id;
	}

	public String getCep() {
		return cep;
	}

	public EstadoEnum getUf() {
		return uf;
	}

	public String getLocalidade() {
		return localidade;
	}

	public String getBairro() {
		return bairro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void setUf(EstadoEnum uf) {
		this.uf = uf;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	
	

}
