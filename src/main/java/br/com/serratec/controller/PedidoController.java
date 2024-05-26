package br.com.serratec.controller;

import br.com.serratec.dtos.*;
import br.com.serratec.services.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
@Tag(name = "PEDIDOS", description = "API de pedidos")
public class PedidoController {
    
    @Autowired
    private PedidoService service;
    
    @GetMapping
    @Operation(summary = "Listar Pedidos")
    @ApiResponse(responseCode = "200", description = "Sucesso", content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PedidoResponseDTO.class)))
    })
    public ResponseEntity<List<PedidoResponseDTO>> listarPedidos(){
        return ResponseEntity.ok(service.listarPedidos());
    }
    
    @PostMapping("/adicionaPedido")
    @Operation(summary = "Cadastrar Pedido", description = "Cadastra um novo pedido usando os dados fornecidos no corpo da requisição.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Pedido cadastrado com sucesso", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CategoriaResponseDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Dados inválidos", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ResponseEntity<PedidoResponseDTO> adicionaPedido(@RequestBody PedidoRequestDTO pedidoRequestDTO) {
        PedidoResponseDTO pedidoResponseDTO = service.cadastrarPedido(pedidoRequestDTO);
        return ResponseEntity.created(null).body(pedidoResponseDTO);
        
    }
    
    
}
