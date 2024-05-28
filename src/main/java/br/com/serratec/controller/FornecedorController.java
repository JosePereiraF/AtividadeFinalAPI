package br.com.serratec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.dtos.FornecedorRequestDTO;
import br.com.serratec.dtos.FornecedorResponseDTO;
import br.com.serratec.entities.Fornecedor;
import br.com.serratec.services.FornecedorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/fornecedores")
@Tag(name = "FORNECEDORES", description = "API de Fornecedores")
public class FornecedorController {

	@Autowired
	FornecedorService service;

	@GetMapping("/listarFornecedores")
	@Operation(summary = "Listar todos os Fornecedores ativos")
	@ApiResponse(responseCode = "200", description = "Sucesso", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = FornecedorResponseDTO.class))) })
	public List<FornecedorResponseDTO> listarFornecedores() {
		return service.listarFornecedores();
	}

	@GetMapping("/listarFornecedor/{id}")
	@Operation(summary = "Busca Fornecedor ativo pelo {id}")
	@ApiResponse(responseCode = "200", description = "Sucesso - Cliente encontrado.", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = FornecedorResponseDTO.class)) })
	public ResponseEntity<FornecedorResponseDTO> listarFornecedorePorId(@PathVariable Long id) {
		return ResponseEntity.ok(service.listarFornecedorPorId(id));
	}

	@PostMapping("/adicionarFornecedor")
	@Operation(summary = "Cadastrar Fornecedor", description = "Cadastra um novo Fornecedor usando os dados fornecidos no corpo da requisição, contanto que a categoria esteja cadastrada no banco.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Fornecedor cadastrado com sucesso", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = FornecedorResponseDTO.class)) }),
			@ApiResponse(responseCode = "400", description = "Dados inválidos", content = @Content),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content) })
	public ResponseEntity<FornecedorResponseDTO> adicionarFornecedor(
			@Valid @RequestBody FornecedorRequestDTO fornecedorRequestDTO) {
		return ResponseEntity.created(null).body(service.adicionarFornecedor(fornecedorRequestDTO));
	}

	@PutMapping("/atualizarFornecedor/{id}")
	@Operation(summary = "Atualizar Fornecedor", description = "Atualiza os dados de um Fornecedor existente pelo ID informado")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Cliente atualizado com sucesso", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = FornecedorResponseDTO.class)) }),
			@ApiResponse(responseCode = "400", description = "Dados inválidos", content = @Content),
			@ApiResponse(responseCode = "404", description = "Fornecedor não encontrado", content = @Content),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content) })
	public FornecedorResponseDTO atualizarFornecedor(@Valid @PathVariable Long id,
			@RequestBody FornecedorRequestDTO fornecedorRequestDTO) {
		return service.atualizarFornecedor(id, fornecedorRequestDTO);
	}

	@DeleteMapping("/excluirFornecedor/{id}")
	@Operation(summary = "Deletar Fornecedor", description = "Remove um fornecedor específico pelo ID.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "204", description = "Fornecedor removido com sucesso", content = @Content),
			@ApiResponse(responseCode = "404", description = "Fornecedor não encontrado", content = @Content),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content) })
	public ResponseEntity<Fornecedor> excluirFornecedor(@PathVariable Long id) {
		return service.excluirFornecedor(id);
	}

	@PutMapping("/deleteLogicoFornecedor/{id}")
	@Operation(summary = "Inativar Fornecedor - DELETE LÓGICO", description = "Atualiza o status 'Ativo' de um Fornecedor existente para 'FALSE'.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Fornecedor inativado com sucesso", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = FornecedorResponseDTO.class)) }),
			@ApiResponse(responseCode = "400", description = "Dados inválidos", content = @Content),
			@ApiResponse(responseCode = "404", description = "Fornecedor não encontrado", content = @Content),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content) })
	public String deleteLogicoFornecedor(@PathVariable Long id) {
		return service.deleteLogicoFornecedor(id);
	}
	
	@PutMapping("/reativarLogicoFornecedor/{id}")
	@Operation(summary = "Reativar Fornecedor - Dezfaz delete Lógico", description = "Atualiza o status 'Ativo' de um Fornecedor existente para 'TRUE'.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Fornecedor inativado com sucesso", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = FornecedorResponseDTO.class)) }),
			@ApiResponse(responseCode = "400", description = "Dados inválidos", content = @Content),
			@ApiResponse(responseCode = "404", description = "Fornecedor não encontrado", content = @Content),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content) })
	public String reativarLogicoFornecedor(@PathVariable Long id) {
		return service.reativarLogicoFornecedor(id);
	}
}
