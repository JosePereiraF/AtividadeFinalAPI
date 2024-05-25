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

import br.com.serratec.dtos.CategoriaRequestDTO;
import br.com.serratec.dtos.CategoriaResponseDTO;
import br.com.serratec.services.CategoriaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService service;

	@GetMapping("/listarCategorias")
	public List<CategoriaResponseDTO> listarCategorias() {
		return service.listarCategorias();
	}
	
	@GetMapping("/listarCategoriaPorId/{id}")
	public ResponseEntity<CategoriaResponseDTO> listarCategoriaPorId(@PathVariable Long id)
	{
		return ResponseEntity.ok(service.listarCategoriaPorId(id));
		
		
	}
	
	@PostMapping("/adicionarCategoria")
	public ResponseEntity<CategoriaResponseDTO> adicionarCategoria(@Valid @RequestBody CategoriaRequestDTO novaCategoria) {
		CategoriaResponseDTO cat = service.adicionarCategoria(novaCategoria);
		return ResponseEntity.created(null).body(cat);

	}
	
	@PutMapping("/atualizarCategoria/{id}")
	public ResponseEntity<CategoriaResponseDTO> atualizarCategoria ( @PathVariable Long id, @RequestBody CategoriaRequestDTO catAtualizada)
	{
		return ResponseEntity.ok(service.atualizarCategoria(id, catAtualizada));
		
	}

}
