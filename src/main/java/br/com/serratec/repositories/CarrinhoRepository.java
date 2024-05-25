package br.com.serratec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.entities.Carrinho;
import br.com.serratec.entities.ProdutoPedidoId;


public interface CarrinhoRepository extends JpaRepository<Carrinho, ProdutoPedidoId>{
}
