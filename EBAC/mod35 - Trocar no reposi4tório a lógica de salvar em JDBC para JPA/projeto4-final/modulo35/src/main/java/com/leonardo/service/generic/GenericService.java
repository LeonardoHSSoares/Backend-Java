package com.leonardo.service.generic;

import java.io.Serializable;
import java.util.Collection;

import com.leonardo.dao.Persistence;
import com.leonardo.dao.generic.IGenericDAO;
import com.leonardo.exceptions.DAOException;
import com.leonardo.exceptions.MaisDeUmRegistroException;
import com.leonardo.exceptions.TableException;
import com.leonardo.exceptions.TipoChaveNaoEncontradaException;

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
public abstract class GenericService<T extends Persistence, E extends Serializable> 
	implements IGenericService<T, E> {
	
	protected IGenericDAO<T,E> dao;
	
	public GenericService(IGenericDAO<T,E> dao) {
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
