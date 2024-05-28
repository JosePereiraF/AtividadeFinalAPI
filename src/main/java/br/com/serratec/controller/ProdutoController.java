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

import br.com.serratec.dtos.ProdutoRequestDTO;
import br.com.serratec.dtos.ProdutoResponseDTO;
import br.com.serratec.entities.Produto;
import br.com.serratec.services.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
@Tag(name = "PRODUTOS", description = "API de produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;
	
	
	@GetMapping
	@Operation(summary = "Listar Produtos")
    @ApiResponse(responseCode = "200", description = "Sucesso", content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ProdutoResponseDTO.class)))
    })
	public ResponseEntity<List<ProdutoResponseDTO>> listarProdutos (){
		 return ResponseEntity.ok(service.listaProdutos());
	}
	
	@GetMapping("/{id}")
	@Operation(summary = "Busca produto pelo {id}")
    @ApiResponse(responseCode = "200", description = "Sucesso - Produto Encontrado.", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ProdutoResponseDTO.class))
    })
	public ResponseEntity<ProdutoResponseDTO> mostrarProduto (@PathVariable Long id){
		return ResponseEntity.ok(service.produtoPorId(id));
	}
	
	@PostMapping
	@Operation(summary = "Cadastrar Produto", description = "Cadastra um novo produto usando os dados fornecidos no corpo da requisição.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Produto cadastrado com sucesso", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ProdutoResponseDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Dados inválidos", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
	public ResponseEntity<ProdutoResponseDTO> produtoInserir (@Valid @RequestBody ProdutoRequestDTO produto){
		return ResponseEntity.created(null).body(service.inserirProduto(produto));
	}
	
	@PutMapping
	@Operation(summary = "Atualizar Produto", description = "Atualiza os dados de um produto existente pelo ID informado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categoria atualizada com sucesso", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ProdutoResponseDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Dados inválidos", content = @Content),
            @ApiResponse(responseCode = "404", description = "Categoria não encontrada", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
	public ResponseEntity<Produto> produtoatualizar(@PathVariable Long id, Produto produto){
	return ResponseEntity.ok(service.produtoatualizar(id,produto));

}
}

