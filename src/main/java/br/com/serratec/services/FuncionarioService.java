package br.com.serratec.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.entities.Funcionario;
import br.com.serratec.exception.ResourceNotFoundException;
import br.com.serratec.repositories.FuncionarioRepository;
@Service
public class FuncionarioService{
 @Autowired
 private FuncionarioRepository repository;
    public List<Funcionario> listaFuncionarios(){
        return repository.findAll();
    }

    public Funcionario funcionarioPorId(Long id){
        Optional<Funcionario> funcionario = repository.findById(id);
        if(funcionario.isPresent()) {

            return funcionario.get();
        }
        throw new ResourceNotFoundException("Funcionario não encontrado");

    }

    public Funcionario inserirFuncionario(Funcionario funcionario) {
     System.out.println(funcionario.toString());
     return repository.save(funcionario);
    }

    public Funcionario funcionarioatualizar(Long id,Funcionario funcionario) {
        Optional<Funcionario> funcionario1 = repository.findById(id);


        if (funcionario1.isPresent()) {
                funcionario.setId(id);
                return repository.save(funcionario);
        }
        throw new ResourceNotFoundException("Funcionario não encontrado");
    }

    public void excluifuncionario(Long id) {
        Optional<Funcionario> funcionario1 = repository.findById(id);
        if(funcionario1.isEmpty()){
            
            throw new ResourceNotFoundException("Funcionario não encontrado");
        }
        repository.deleteById(id);
    }
}