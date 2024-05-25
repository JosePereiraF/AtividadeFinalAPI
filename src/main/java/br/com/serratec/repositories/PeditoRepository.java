package br.com.serratec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.entities.Pedido;

public interface PeditoRepository extends JpaRepository<Pedido, Long> {
	public Pedido findByNumeroDoPedido(Integer numeroDoPedido);
}
