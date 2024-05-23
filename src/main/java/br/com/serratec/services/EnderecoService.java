package br.com.serratec.services;



import br.com.serratec.dtos.EnderecoResponseDTO;
import br.com.serratec.entities.Endereco;
import br.com.serratec.exception.ResourceNotFoundException;
import br.com.serratec.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository repository;
    
    public EnderecoResponseDTO buscar(String cep){
        Optional<Endereco> endereco = Optional.ofNullable(repository.findByCep(cep));
        if(endereco.isPresent()){
            return new EnderecoResponseDTO(endereco.get());
            
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
    
    public EnderecoResponseDTO inserir(Endereco endereco){
        return new EnderecoResponseDTO(repository.save(endereco));
    }
    
}
