package br.com.serratec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.serratec.dtos.CategoriaRequestDTO;
import br.com.serratec.dtos.CategoriaResponseDTO;
import br.com.serratec.dtos.ClienteResponseDTO;
import br.com.serratec.services.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
@RestController
@RequestMapping("/categorias")
@Tag(name = "CATEGORIAS", description = "API de categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService service;

	@GetMapping("/listarCategorias")
	@Operation(summary = "Listar categorias")
    @ApiResponse(responseCode = "200", description = "Sucesso", content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = CategoriaResponseDTO.class)))
    })
	public List<CategoriaResponseDTO> listarCategorias() {
		return service.listarCategorias();
	}
	
	@GetMapping("/listarCategoriaPorId/{id}")
	@Operation(summary = "Busca categoria pelo {id}")
    @ApiResponse(responseCode = "200", description = "Sucesso - Categoria Encontrada.", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = CategoriaResponseDTO.class))
    })
	public ResponseEntity<CategoriaResponseDTO> listarCategoriaPorId(@PathVariable Long id)
	{
		return ResponseEntity.ok(service.listarCategoriaPorId(id));
		
		
	}
	
	@PostMapping("/adicionarCategoria")
	@Operation(summary = "Cadastrar Categoria", description = "Cadastra uma nova categoria usando os dados fornecidos no corpo da requisição.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Categoria cadastrada com sucesso", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CategoriaResponseDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Dados inválidos", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
	public ResponseEntity<CategoriaResponseDTO> adicionarCategoria(@Valid @RequestBody CategoriaRequestDTO novaCategoria) {
		CategoriaResponseDTO cat = service.adicionarCategoria(novaCategoria);
		return ResponseEntity.created(null).body(cat);

	}
	
	@PutMapping("/atualizarCategoria/{id}")
	@Operation(summary = "Atualizar Categoria", description = "Atualiza os dados de uma Categoria existente pelo ID informado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categoria atualizada com sucesso", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ClienteResponseDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Dados inválidos", content = @Content),
            @ApiResponse(responseCode = "404", description = "Categoria não encontrada", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
	public ResponseEntity<CategoriaResponseDTO> atualizarCategoria ( @PathVariable Long id, @RequestBody CategoriaRequestDTO catAtualizada)
	{
		return ResponseEntity.ok(service.atualizarCategoria(id, catAtualizada));
		
	}

}
