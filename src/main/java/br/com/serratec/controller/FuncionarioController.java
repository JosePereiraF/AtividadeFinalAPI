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

import br.com.serratec.entities.Funcionario;
import br.com.serratec.services.FuncionarioService;


@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
@Autowired
private FuncionarioService service;
@GetMapping
public ResponseEntity<List<Funcionario>> listafuncionario(){
	return ResponseEntity.ok(service.listaFuncionarios());
	
}
@GetMapping("/{id}")
public ResponseEntity<Funcionario>buscarfuncionario(@PathVariable Long id){
		return ResponseEntity.ok(service.funcionarioPorId(id));
		
}
@PostMapping
public ResponseEntity<Funcionario>insetirfuncionario(@RequestBody Funcionario funcionario){
	return ResponseEntity.ok(service.inserirFuncionario(funcionario));
	
}
@PutMapping("/{id}")
public ResponseEntity<Funcionario>atualizarfuncionario(@RequestBody Funcionario funcinario,@PathVariable Long id){
	return ResponseEntity.ok(service.funcionarioatualizar(id, funcinario));

}
@DeleteMapping("/{id}")
public ResponseEntity<Void>excluirfuncionario(@PathVariable Long id){
	service.excluifuncionario(id);
	return ResponseEntity.noContent().build();

}


}
