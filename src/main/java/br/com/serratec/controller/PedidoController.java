package br.com.serratec.controller;

import br.com.serratec.dtos.*;
import br.com.serratec.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    
    @Autowired
    private PedidoService service;
    
    @GetMapping
    public ResponseEntity<List<PedidoResponseDTO>> listarPedidos(){
        return ResponseEntity.ok(service.listarPedidos());
    }
    
    @PostMapping("/adicionaPedido")
    public ResponseEntity<PedidoResponseDTO> adicionaPedido(@RequestBody PedidoRequestDTO pedidoRequestDTO) {
        PedidoResponseDTO pedidoResponseDTO = service.cadastrarPedido(pedidoRequestDTO);
        return ResponseEntity.created(null).body(pedidoResponseDTO);
        
    }
    
    
}
