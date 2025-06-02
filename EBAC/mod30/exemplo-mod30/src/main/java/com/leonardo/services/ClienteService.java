package com.leonardo.services;


import com.leonardo.dao.IClienteDAO;
import com.leonardo.domain.Cliente;
import com.leonardo.services.generic.GenericService;

public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {
	
	
	public ClienteService(IClienteDAO clienteDAO) {
		super(clienteDAO);
	}

//	@Override
//	public Boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradaException {
//		return clienteDAO.cadastrar(cliente);
//	}

	@Override
	public Cliente buscarPorCPF(Long cpf) {
		return this.dao.consultar(cpf);
	}

//	@Override
//	public void excluir(Long cpf) {
//		clienteDAO.excluir(cpf);
//	}
//
//	@Override
//	public void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException{
//		clienteDAO.alterar(cliente);
//	}

}