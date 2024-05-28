package br.com.serratec.entities;

import br.com.serratec.dtos.FuncionarioRequestDTO;
import br.com.serratec.enums.CargoEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Funcionario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String telefone;
	private String email;
	private String cpf;
	@OneToOne
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;
	private CargoEnum cargo;
	
	public Funcionario() {
		super();
	}
	
	
	public Funcionario(Long id, String nome, String telefone, String email, String cpf, Endereco endereco,
			CargoEnum cargo) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.cpf = cpf;
		this.endereco = endereco;
		this.cargo = cargo;
	}
	
	public Funcionario(FuncionarioRequestDTO funcionarioRequestDTO) {
		this.nome = funcionarioRequestDTO.getNome();
		this.telefone = funcionarioRequestDTO.getTelefone();
		this.email = funcionarioRequestDTO.getEmail();
		this.cpf = funcionarioRequestDTO.getCpf();
		this.endereco = funcionarioRequestDTO.getEndereco();
		cargo = funcionarioRequestDTO.getCargo();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Dados do Funcionario: \n [id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", cpf="
				+ cpf + ", endereco=" + endereco + ", cargo=" + cargo + "]";
	}

	
	
}
