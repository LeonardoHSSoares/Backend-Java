package com.leonardo.services.cliente;

import com.leonardo.domain.cliente.Cliente;
import com.leonardo.exceptions.DAOException;
import com.leonardo.services.generic.IGenericService;

/**
 * @author Leonardo Soares
 *
 * Interface IClienteService que estende a interface IGenericService.
 *
 * Esta interface é responsável por definir os métodos específicos para serviços relacionados à entidade Cliente.
 */

public interface IClienteService extends IGenericService<Cliente, Long> {

//	Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;
//
	Cliente buscarPorID(Long id) throws DAOException;
//
//	void excluir(Long cpf);
//
//	void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;

}
