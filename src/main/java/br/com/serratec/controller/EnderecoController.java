package br.com.serratec.controller;

import br.com.serratec.dtos.EnderecoResponseDTO;
import br.com.serratec.dtos.ProdutoResponseDTO;
import br.com.serratec.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
    
    @Autowired
    private EnderecoService service;
    
    @GetMapping
    public ResponseEntity<List<EnderecoResponseDTO>> listarEnderecos(){
        return ResponseEntity.ok(service.listarEnderecos());
    }
    
    @GetMapping("{cep}")
    public ResponseEntity<EnderecoResponseDTO>burcarCep(@PathVariable String cep){
        EnderecoResponseDTO dto = service.buscar(cep);
        if(dto==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }
    
}
