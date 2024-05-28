package br.com.serratec.dtos;

import org.hibernate.validator.constraints.br.CPF;

import br.com.serratec.customannotation.Telefone;
import br.com.serratec.entities.Endereco;
import br.com.serratec.enums.CargoEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class FuncionarioRequestDTO {
	
	@NotBlank
	private String nome;
    @Telefone
    private String telefone;
    @Email
    private String email;
    @CPF
    private String cpf;
    private Endereco endereco;
    private CargoEnum cargo;
    
  
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public CargoEnum getCargo() {
		return cargo;
	}
	public void setCargo(CargoEnum cargo) {
		this.cargo = cargo;
	}
    
    
}
