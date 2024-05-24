package br.com.serratec.services;



import br.com.serratec.dtos.EnderecoResponseDTO;
import br.com.serratec.dtos.ProdutoResponseDTO;
import br.com.serratec.entities.Endereco;
import br.com.serratec.exception.ResourceNotFoundException;
import br.com.serratec.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository repository;
    
    public Endereco buscar(String cep){
        Optional<Endereco> endereco = Optional.ofNullable(repository.findByCep(cep));
        if(endereco.isPresent()){
            return endereco.get();
            
        }else {
            RestTemplate rs = new RestTemplate();
            String url = "http://viacep.com.br/ws/" + cep + "/json";
            Optional<Endereco> enderecoViaCep = Optional.ofNullable(rs.getForObject(url, Endereco.class));
            if (enderecoViaCep.get().getCep() != null){
                String cepSemTraco = enderecoViaCep.get().getCep().replaceAll("-","");
                enderecoViaCep.get().setCep(cepSemTraco);
                return inserir(enderecoViaCep.get());
            }else {
                throw new ResourceNotFoundException("Cep não encontrado !");
            }
            
        }
    }
    
    public Endereco inserir(Endereco endereco){
        return repository.save(endereco);
    }
    
    public List<EnderecoResponseDTO> listarEnderecos(){
        return repository.findAll().stream().map(end-> new EnderecoResponseDTO(end)).collect(Collectors.toList());
    }
    
}
