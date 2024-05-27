package br.com.serratec.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.serratec.dtos.FornecedorRequestDTO;
import br.com.serratec.dtos.FornecedorResponseDTO;
import br.com.serratec.entities.Categoria;
import br.com.serratec.entities.Fornecedor;
import br.com.serratec.exception.ResourceNotFoundException;
import br.com.serratec.repositories.CategoriaRepository;
import br.com.serratec.repositories.FornecedorRepository;
import jakarta.transaction.Transactional;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository repository;

	@Autowired
	private CategoriaRepository catrepository;

	// retorna todos os fornecedores
	public List<FornecedorResponseDTO> listarFornecedores() {
		List<Fornecedor> fornecedores = repository.findByAtivoTrue();
		return fornecedores.stream().map((fornec) -> new FornecedorResponseDTO(fornec)).collect(Collectors.toList());
	}

	// retorna um fornecedor pelo id
	public FornecedorResponseDTO listarFornecedorPorId(Long id) {
		Optional<Fornecedor> fornecedor = repository.findByIdAndAtivoTrue(id);
		if (fornecedor.isPresent()) {
			return new FornecedorResponseDTO(fornecedor.get());
		}

		throw new ResourceNotFoundException("Fornecedor não Encontrado.");

	}

	// adiciona o Fornecedor contanto que exista a categoria na API
	public FornecedorResponseDTO adicionarFornecedor(FornecedorRequestDTO request) {
		Optional<Categoria> categoria = catrepository.findById(request.getCategoria().getId());
		if (categoria.isPresent()) {
			request.setCategoria(categoria.get());
			Fornecedor f = repository.save(new Fornecedor(request));
			return new FornecedorResponseDTO(f);
		}
		throw new ResourceNotFoundException("Não foi possível adicionar o Fornecedor. Categoria Inexiste.");
	}

	// atualiza os dados do Fornecedor presente na API
	public FornecedorResponseDTO atualizarFornecedor(Long id, FornecedorRequestDTO request) {
		Optional<Fornecedor> fornecedor = repository.findById(id);
		Optional<Categoria> categoria = catrepository.findById(request.getCategoria().getId());

		if (fornecedor.isPresent()) {
			Fornecedor f = new Fornecedor();
			if (categoria.isPresent()) {
				f.setNome(request.getNome());
				f.setTelefone(request.getTelefone());
				f.setEmail(request.getEmail());
				f.setCategoria(categoria.get());
				f.setId(id);
				repository.save(f);
				return new FornecedorResponseDTO(f);

			}

			f.setId(id);
			f.setCategoria(fornecedor.get().getCategoria());
			repository.save(f);
			return new FornecedorResponseDTO(f);
		}
		throw new ResourceNotFoundException("Não foi possível atualizar. Fornecedor não Encontrado.");
	}

	@Transactional
	// executa o Delete Lógico do Fornecedor
	public String deleteLogicoFornecedor(Long id) {
		Fornecedor fornecedor = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Impossível deletar. Fornecedor não encontrado"));
		fornecedor.setAtivo(false);
		repository.save(fornecedor);
		return "Fornecedor de id " + id + " foi inativado.";

	}

	// exclui o fornecedor do banco de dados da API
	public ResponseEntity<Fornecedor> excluirFornecedor(Long id) {
		try {
			repository.deleteById(id);
			return ResponseEntity.noContent().build();
		} catch (EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException("Não foi possível excluir. Fornecedor não encontrado.");
		}
	}

}
