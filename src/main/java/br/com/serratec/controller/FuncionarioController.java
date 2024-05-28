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

import br.com.serratec.dtos.FuncionarioRequestDTO;
import br.com.serratec.dtos.FuncionarioResponseDTO;
import br.com.serratec.entities.Funcionario;
import br.com.serratec.services.FuncionarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/funcionarios")
@Tag(name = "FUNCIONARIOS", description = "API de Funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService service;
	
	@GetMapping("/listarFuncionarios")
	public List<FuncionarioResponseDTO> listarFuncionarios(){
		return service.listarFuncionarios();
	}
	
	@GetMapping("/listarFuncionarioPorId/{id}")
	public ResponseEntity<FuncionarioResponseDTO> listarFuncionarioPorId(@PathVariable Long id){
		return ResponseEntity.ok(service.listarFuncionarioPorId(id));
	}
	
	 @PostMapping("/cadastrar") 
	 public ResponseEntity<FuncionarioResponseDTO> cadastrarFuncionario(@Valid @RequestBody FuncionarioRequestDTO funcionarioRequestDTO){
		 return ResponseEntity.created(null).body(service.cadastrarFuncionario(funcionarioRequestDTO));
	 }
	 
	 @PutMapping("/atualizar/{id}")
	 public FuncionarioResponseDTO atualizarFuncionario(@Valid @PathVariable Long id, @RequestBody Funcionario funcionario) {
		 return service.atualizarFuncionario(id, funcionario);
	 }
	
}
