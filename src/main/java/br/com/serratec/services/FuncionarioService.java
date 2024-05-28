package br.com.serratec.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.configuration.MailConfig;
import br.com.serratec.dtos.FuncionarioRequestDTO;
import br.com.serratec.dtos.FuncionarioResponseDTO;
import br.com.serratec.entities.Funcionario;
import br.com.serratec.exception.ResourceNotFoundException;
import br.com.serratec.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository repository;
	
	@Autowired
	private MailConfig configEmail;
	
	
	public List<FuncionarioResponseDTO> listarFuncionarios(){
		List<Funcionario> funcionarios = repository.findAll();
		return funcionarios.stream().map((fun) -> new FuncionarioResponseDTO(fun)).collect(Collectors.toList());
	}
	
	public FuncionarioResponseDTO listarFuncionarioPorId(Long id) {
		Funcionario fun;
		
		if(repository.existsById(id)) {
			fun = repository.findById(id).get();
			return new FuncionarioResponseDTO(fun);
		}
		throw new ResourceNotFoundException("Funcionario não encontrado");
	}
	
	public FuncionarioResponseDTO cadastrarFuncionario(FuncionarioRequestDTO funcionarioRequestDTO) {
		Funcionario funcionario = new Funcionario(funcionarioRequestDTO);
		Funcionario funcionarioSalvo = repository.save(funcionario);
		configEmail.sendMail(funcionario.getEmail(),"Cadastro de Funcionario efetuado com Sucesso." ,funcionario.toString());
		return new FuncionarioResponseDTO(funcionarioSalvo);
	}
	
	public FuncionarioResponseDTO atualizarFuncionario(Long id, Funcionario funcionario) {
		Optional<Funcionario> fun = repository.findById(id);
		if(fun.isPresent()) {
			funcionario.setId(id);
			funcionario.setEndereco(fun.get().getEndereco());
			configEmail.sendMail(funcionario.getEmail(),"Cadastro de Funcionario atualizado com Sucesso." ,funcionario.toString());
			return new FuncionarioResponseDTO(repository.save(funcionario));
		}else {
			throw  new ResourceNotFoundException("Funcionario Inexistente.");
		}
	}

}
