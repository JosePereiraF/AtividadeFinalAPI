package br.com.serratec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.dtos.CarrinhoRequestDTO;
import br.com.serratec.dtos.CarrinhoResponseDTO;
import br.com.serratec.dtos.ProdutoResponseDTO;
import br.com.serratec.entities.Carrinho;
import br.com.serratec.entities.ProdutoPedidoId;
import br.com.serratec.services.CarrinhoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/carrinho")
@Tag(name = "CARRINHO", description = "API dos Carrinhos dos pedidos")
public class CarrinhoController {
	
	@Autowired
	private CarrinhoService service;
	
	@GetMapping
	@Operation(summary = "Listar Carrinhos")
    @ApiResponse(responseCode = "200", description = "Sucesso", content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = CarrinhoResponseDTO.class)))
    })
	public ResponseEntity<List<CarrinhoResponseDTO>> listaCarrinho(){
		return ResponseEntity.ok(service.listaCarrinho());
	}
	
	
	@GetMapping("/{id}")
	@Operation(summary = "Busca Carrinho pelo {id}")
    @ApiResponse(responseCode = "200", description = "Sucesso - Produto Encontrado.", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = CarrinhoResponseDTO.class))
    })
	public ResponseEntity<CarrinhoResponseDTO> buscarCarrinho(@PathVariable ProdutoPedidoId id){
		return ResponseEntity.ok(service.buscarCarrinho(id));
	}
	
	@PostMapping
	@Operation(summary = "Cadastrar Carrinho", description = "Cadastra um novo Carrinho usando os dados fornecidos no corpo da requisição.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Carrinho cadastrado com sucesso", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CarrinhoResponseDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Dados inválidos", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
	public ResponseEntity<CarrinhoResponseDTO> inserirCarrinho(@RequestBody CarrinhoRequestDTO carrinho){
		return ResponseEntity.created(null).body(service.inserirCarrinho(carrinho));
	}
	
	@PutMapping("/{id}")
	@Operation(summary = "Atualizar Carrinho", description = "Atualiza os dados de um carrinho existente pelo ID informado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categoria atualizada com sucesso", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ProdutoResponseDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Dados inválidos", content = @Content),
            @ApiResponse(responseCode = "404", description = "Categoria não encontrada", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
	public ResponseEntity<CarrinhoResponseDTO> atualizarCarrinho(@PathVariable ProdutoPedidoId id,@RequestBody Carrinho carrinho){
		return ResponseEntity.ok(service.atualizarCarrinho(carrinho, id)); 
	}
}
