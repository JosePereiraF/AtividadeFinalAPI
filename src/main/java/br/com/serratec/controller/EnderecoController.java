package br.com.serratec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.dtos.EnderecoResponseDTO;
import br.com.serratec.entities.Endereco;
import br.com.serratec.services.EnderecoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/enderecos")
@Tag(name = "ENDEREÇOS", description = "API de endereços")
public class EnderecoController {
    
    @Autowired
    private EnderecoService service;
    
    @GetMapping
    @Operation(summary = "Listar endereços")
    @ApiResponse(responseCode = "200", description = "Sucesso", content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = EnderecoResponseDTO.class)))
    })
    public ResponseEntity<List<EnderecoResponseDTO>> listarEnderecos(){
        return ResponseEntity.ok(service.listarEnderecos());
    }
    
    @GetMapping("{cep}")
    @Operation(summary = "Busca endereço pelo {cep} através do API externa do ViaCep.")
    @ApiResponse(responseCode = "200", description = "Sucesso - Endereço Encontrado.", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = EnderecoResponseDTO.class))
    })
    public ResponseEntity<Endereco>burcarCep(@PathVariable String cep){
        Endereco dto = service.buscar(cep);
        if(dto==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }
    
}
