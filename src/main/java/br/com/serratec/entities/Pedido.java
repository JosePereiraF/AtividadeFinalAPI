package br.com.serratec.entities;

import java.time.LocalDate;

import br.com.serratec.enums.StatusEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate dataPedido;
	private LocalDate dataEntrega;
	private StatusEnum status;
	private boolean ativo;
	private Cliente cliente;
	
	public Pedido() {}

	public Long getId() {
		return id;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
