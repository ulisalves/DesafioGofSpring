package one.digitalinovation.lab.padroes.projeto.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import one.digitalinovation.lab.padroes.projeto.spring.model.Cliente;
import one.digitalinovation.lab.padroes.projeto.spring.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	//
	//
	//		

	@Override
	public Iterable<Cliente> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserir(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Long id, Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(Long id) {
		// TODO Auto-generated method stub
		
	}

}
