package br.com.serratec.dtos;

import br.com.serratec.entities.Endereco;
import br.com.serratec.entities.Funcionario;
import br.com.serratec.enums.CargoEnum;

public class FuncionarioResponseDTO {
	
	
	private String nome;
	private String telefone;
	private String email;
	private String cpf;
	private Endereco endereco;
	private CargoEnum cargo;
	
	public FuncionarioResponseDTO() {
		
	}
	
	public FuncionarioResponseDTO(Funcionario funcionario) {
		super();
		
		nome = funcionario.getNome();
		telefone = funcionario.getTelefone();
		email = funcionario.getEmail();
		cpf = funcionario.getCpf();
		endereco = funcionario.getEndereco();
		cargo = funcionario.getCargo();
	}
	
	

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
