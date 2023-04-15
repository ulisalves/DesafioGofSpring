package one.digitalinovation.lab.padroes.projeto.spring.service;

import one.digitalinovation.lab.padroes.projeto.spring.model.Cliente;

public interface ClienteService {
	
	Iterable<Cliente> buscarTodos();
	
	Cliente buscarPorId (Long id);
	
	void inserir (Cliente cliente);
	
	void atualizar (Long id, Cliente cliente);
	
	void deletar (Long id);
	
	

}
