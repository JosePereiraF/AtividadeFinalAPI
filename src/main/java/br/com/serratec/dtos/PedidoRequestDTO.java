package br.com.serratec.dtos;

import br.com.serratec.entities.Cliente;
import br.com.serratec.entities.Pedido;
import br.com.serratec.enums.StatusEnum;

import java.time.LocalDate;

public class PedidoRequestDTO {
    
    private Integer numeroDoPedido;
    private LocalDate dataPedido;
    private LocalDate dataEntrega;
    private StatusEnum status;
    private boolean ativo;
    private Cliente cliente;
    
    public PedidoRequestDTO() {
    }
    
    public PedidoRequestDTO(Pedido pedido) {
        numeroDoPedido = pedido.getNumeroDoPedido();
        dataPedido = pedido.getDataPedido();
        dataEntrega = pedido.getDataEntrega();
        status = pedido.getStatus();
        ativo = pedido.isAtivo();
        cliente = pedido.getCliente();
    }
    
    public Integer getNumeroDoPedido() {
        return numeroDoPedido;
    }
    
    public void setNumeroDoPedido(Integer numeroDoPedido) {
        this.numeroDoPedido = numeroDoPedido;
    }
    
    public LocalDate getDataPedido() {
        return dataPedido;
    }
    
    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }
    
    public LocalDate getDataEntrega() {
        return dataEntrega;
    }
    
    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
    
    public StatusEnum getStatus() {
        return status;
    }
    
    public void setStatus(StatusEnum status) {
        this.status = status;
    }
    
    public boolean isAtivo() {
        return ativo;
    }
    
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    @Override
    public String toString() {
        return "PedidoRequestDTO{" +
                "numeroDoPedido=" + numeroDoPedido +
                ", dataPedido=" + dataPedido +
                ", dataEntrega=" + dataEntrega +
                ", status=" + status +
                ", ativo=" + ativo +
                ", cliente=" + cliente +
                '}';
    }
}


