package com.leonardo.service;

import java.io.Serializable;
import java.util.Collection;

import com.leonardo.exceptions.DAOException;
import com.leonardo.exceptions.MaisDeUmRegistroException;
import com.leonardo.exceptions.TableException;
import com.leonardo.exceptions.TipoChaveNaoEncontradaException;
import com.leonardo.gateway.IGenericGateway;
import com.leonardo.infrastructure.dao.Persistente;


/**
 * @author Leonardo Soares
 *
 * Classe abstrata GenericService que implementa a interface IGenericService.
 *
 * Esta classe é responsável por fornecer implementações genéricas para serviços,
 * como cadastrar, excluir, alterar e buscar entidades.
 *
 * Ela utiliza um DAO genérico (IGenericDAO) para realizar as operações de persistência.
 */
public abstract class GenericService<T extends Persistente, E extends Serializable> 
	implements IGenericService<T, E> {
	
	protected IGenericGateway<T,E> dao;
	
	public GenericService(IGenericGateway<T,E> dao) {
		this.dao = dao;
	}

	@Override
	public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
		return this.dao.cadastrar(entity);
	}

	@Override
	public void excluir(E valor) throws DAOException {
		this.dao.excluir(valor);
	}

	@Override
	public void alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
		this.dao.alterar(entity);
	}

	@Override
	public T consultar(E valor) throws DAOException {
		try {
			return this.dao.consultar(valor);
		} catch (MaisDeUmRegistroException | TableException e) {
                    // Log the exception or handle it as needed

		}
		return null;
	}

	@Override
	public Collection<T> buscarTodos() throws DAOException {
		return this.dao.buscarTodos();
	}

}
