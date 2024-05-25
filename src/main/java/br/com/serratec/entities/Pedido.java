package br.com.serratec.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.serratec.dtos.PedidoRequestDTO;
import br.com.serratec.enums.StatusEnum;
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
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer numeroDoPedido;
	private LocalDate dataPedido;
	private LocalDate dataEntrega;
	private StatusEnum status;
	private boolean ativo;
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	@OneToMany(mappedBy = "id.pedido", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Carrinho> carrinho = new HashSet<>();
	
	public Pedido() {}
   
	
	public Pedido(PedidoRequestDTO pedidoRequestDTO) {
		this.numeroDoPedido = pedidoRequestDTO.getNumeroDoPedido();
		this.dataPedido = pedidoRequestDTO.getDataPedido();
		this.dataEntrega = pedidoRequestDTO.getDataEntrega();;
		this.status = pedidoRequestDTO.getStatus();
		this.ativo = true;
		this.cliente = pedidoRequestDTO.getCliente();
	}
	
	
	public Set<Carrinho> getCarrinho() {
		return carrinho;
	}


	public void setCarrinho(Set<Carrinho> carrinho) {
		this.carrinho = carrinho;
	}


	public Integer getNumeroDoPedido() {
		return numeroDoPedido;
	}
	
	public void setNumeroDoPedido(Integer numeroDoPedido) {
		this.numeroDoPedido = numeroDoPedido;
	}
	
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


	@Override
	public String toString() {
		return "Pedido [id=" + id + ", numeroDoPedido=" + numeroDoPedido + ", dataPedido=" + dataPedido
				+ ", dataEntrega=" + dataEntrega + ", status=" + status + ", ativo=" + ativo + ", cliente=" + cliente
				+ ", carrinho=" + carrinho + "]";
	}
	
	
}
