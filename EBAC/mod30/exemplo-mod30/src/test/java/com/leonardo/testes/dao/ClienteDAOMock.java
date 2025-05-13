package com.leonardo.testes.dao;

import java.util.Collection;

import com.leonardo.dao.IClienteDAO;
import com.leonardo.domain.Cliente;
import com.leonardo.exceptions.TipoChaveNaoEncontradaException;

public class ClienteDAOMock implements IClienteDAO {

    @Override
	public Boolean cadastrar(Cliente entity) throws TipoChaveNaoEncontradaException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void excluir(Long valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Cliente entity) throws TipoChaveNaoEncontradaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente consultar(Long valor) {
		Cliente cliente = new Cliente();
		cliente.setCpf(valor);
		return cliente;
	}

	@Override
	public Collection<Cliente> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}
}
