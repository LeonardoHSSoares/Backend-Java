package com.leonardo.service.cliente;

import com.leonardo.domain.Cliente;
import com.leonardo.exceptions.DAOException;
import com.leonardo.exceptions.MaisDeUmRegistroException;
import com.leonardo.exceptions.TableException;
import com.leonardo.gateway.IClienteGateway;
import com.leonardo.service.GenericService;


/**
 * @author Leonardo Soares
 *
 * Classe ClienteServ que implementa a interface IClienteService.
 *
 * Esta classe é responsável por realizar operações de serviço para a entidade Cliente,
 * como consultar um cliente por ID.
 *
 * Ela estende a classe GenericService, que fornece implementações genéricas para serviços.
 */
public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {

	public ClienteService(IClienteGateway clienteDAO) {
		super(clienteDAO);
	}

	// @Override
	// public Boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradaException
	// {
	// return clienteDAO.cadastrar(cliente);
	// }

	@Override
	public Cliente buscarPorID(Long id) throws DAOException {
		try {
			return this.dao.consultar(id);
		} catch (MaisDeUmRegistroException | TableException e) {

		}
		return null;
	}

	// @Override
	// public void excluir(Long cpf) {
	// clienteDAO.excluir(cpf);
	// }
	//
	// @Override
	// public void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException{
	// clienteDAO.alterar(cliente);
	// }

}
