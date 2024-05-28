package br.com.serratec.dtos;

import br.com.serratec.entities.Cliente;
import br.com.serratec.entities.Pedido;
import br.com.serratec.enums.StatusEnum;

import java.time.LocalDate;

public class PedidoResponseDTO {
    
    private Integer numeroDoPedido;
    private LocalDate dataPedido;
    private LocalDate dataEntrega;
    private StatusEnum status;
    private boolean ativo;
   

    private String nomeCliente;
    
    public PedidoResponseDTO(Pedido pedido) {
        numeroDoPedido = pedido.getNumeroDoPedido();
        dataPedido = pedido.getDataPedido();
        dataEntrega = pedido.getDataEntrega();
        status = pedido.getStatus();
        ativo = pedido.isAtivo();
        this.nomeCliente = pedido.getCliente().getNome();
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
    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
   
}
