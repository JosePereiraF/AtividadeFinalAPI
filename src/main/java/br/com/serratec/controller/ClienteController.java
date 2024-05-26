package br.com.serratec.controller;

import br.com.serratec.dtos.ClienteRequestDTO;
import br.com.serratec.dtos.ClienteResponseDTO;
import br.com.serratec.entities.Cliente;
import br.com.serratec.services.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@Tag(name = "CLIENTES", description = "API de Clientes")
public class ClienteController {
    
    @Autowired
    private ClienteService service;
    
    @GetMapping("/listarClientes")
    @Operation(summary = "Listar Clientes")
    @ApiResponse(responseCode = "200", description = "Sucesso", content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ClienteResponseDTO.class)))
    })
    public List<ClienteResponseDTO> listarClientes() {
        return service.listarClientes();
    }
    
    @Operation(summary = "Busca cliente pelo {id}")
    @ApiResponse(responseCode = "200", description = "Sucesso - Cliente encontrado.", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ClienteResponseDTO.class))
    })
    @GetMapping("/listarClientePorId/{id}")
    public ResponseEntity<ClienteResponseDTO> listarClientePorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.listarClientePorId(id));
    }
    
    @Operation(summary = "Cadastrar Cliente", description = "Cadastra um novo cliente usando os dados fornecidos no corpo da requisição e o CEP no caminho da URL")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cliente cadastrado com sucesso", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ClienteResponseDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Dados inválidos", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    @PostMapping("/cadastrar/{cep}")
    public ResponseEntity<ClienteResponseDTO> cadastrarCliente(@Valid @RequestBody ClienteRequestDTO clienteRequestDTO, @PathVariable String cep) {
        return ResponseEntity.created(null).body(service.cadastrarCliente(cep, clienteRequestDTO));
        
    }
    
    @PutMapping("/atualizar/{id}")
    @Operation(summary = "Atualizar Cliente", description = "Atualiza os dados de um cliente existente pelo ID informado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente atualizado com sucesso", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ClienteResponseDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Dados inválidos", content = @Content),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    public ClienteResponseDTO atualizarCliente(@Valid @PathVariable Long id, @RequestBody Cliente cliente) {
        return service.atualizarCliente(id, cliente);
    }
}
