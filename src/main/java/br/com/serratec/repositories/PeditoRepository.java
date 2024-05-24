package br.com.serratec.repositories;

import br.com.serratec.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeditoRepository extends JpaRepository<Pedido, Long> {

}
