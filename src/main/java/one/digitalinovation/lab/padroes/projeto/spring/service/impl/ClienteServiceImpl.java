package one.digitalinovation.lab.padroes.projeto.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinovation.lab.padroes.projeto.spring.model.Cliente;
import one.digitalinovation.lab.padroes.projeto.spring.model.ClienteRepository;
import one.digitalinovation.lab.padroes.projeto.spring.model.Endereco;
import one.digitalinovation.lab.padroes.projeto.spring.model.EnderecoRepository;
import one.digitalinovation.lab.padroes.projeto.spring.service.ClienteService;
import one.digitalinovation.lab.padroes.projeto.spring.service.ViaCepService;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	//Singleton: Injetar os componentes do Spring com @Autowired
	
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ViaCepService viaCepService;
	
	//Strategy: implementar os métodos definidos na interface 
	//Facade: abstrair integrações com subsistemas		

	@Override
	public Iterable<Cliente> buscarTodos() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente buscarPorId(Long id) {
		 Optional <Cliente> cliente = clienteRepository.findById(id);
		return cliente.get();
	}

	@Override
	public void inserir(Cliente cliente) {
		salvarClienteComCep(cliente);
	}

	@Override
	public void atualizar(Long id, Cliente cliente) {
		// Buscar cliente por id
		 Optional <Cliente> clienteBd = clienteRepository.findById(id);
		 if (clienteBd.isPresent()) {
			 salvarClienteComCep(cliente);
		 }
		
	}
	
	@Override
	public void deletar(Long id) {
		// Deletar Cliente por id
		clienteRepository.deleteById(id);
		
	}
	
	private void salvarClienteComCep(Cliente cliente) {
		//Verificar se o endereço do cliente já existe pelo cep
		String cep = cliente.getEndereço().getCep();	
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
			//caso não existe integrar com o ViaCep e persistir o retorno
			Endereco novoEndereco = viaCepService.consultarCep(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});
		cliente.setEndereço(endereco);
		//Inserir cliente
		clienteRepository.save(cliente);
	}

}
