package br.com.serratec.services;

import br.com.serratec.dtos.ClienteRequestDTO;
import br.com.serratec.dtos.ClienteResponseDTO;
import br.com.serratec.dtos.PedidoRequestDTO;
import br.com.serratec.dtos.PedidoResponseDTO;
import br.com.serratec.entities.Cliente;
import br.com.serratec.entities.Pedido;
import br.com.serratec.repositories.PeditoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {
    
    @Autowired
    private PeditoRepository repository;
    
    public List<PedidoResponseDTO> listarPedidos() {
        List<Pedido> pedido = repository.findAll();
        return pedido.stream().map((ped) -> new PedidoResponseDTO(ped))
                .collect(Collectors.toList());
    }
    
    public ResponseEntity<PedidoResponseDTO> listarPedidoPorId (Long id)
    {
        Pedido pedido;
        
        if(repository.existsById(id))
        {
            pedido = repository.findById(id).get();
            return  ResponseEntity.ok(new PedidoResponseDTO(pedido));
        }
        
        else
        {
            return ResponseEntity.notFound().build();
        }
    }
    
    public PedidoResponseDTO cadastrarPedido(PedidoRequestDTO pedidoRequestDTO){
        
        Pedido pedido = new Pedido(pedidoRequestDTO);
        Pedido pedidoSalvo = repository.save(pedido);
        System.out.println("pedidoRequestDTO = " + pedidoRequestDTO);
        System.out.println("pedido = " + pedido);
        System.out.println("pedidosalvo = " + pedidoSalvo);
        return  new PedidoResponseDTO(pedidoSalvo);
    }




}
