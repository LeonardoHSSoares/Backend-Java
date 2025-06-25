package com.leonardo.service.jpa;

import java.io.Serializable;
import java.util.Collection;

import com.leonardo.exceptions.DAOException;
import com.leonardo.exceptions.MaisDeUmRegistroException;
import com.leonardo.exceptions.TableException;
import com.leonardo.exceptions.TipoChaveNaoEncontradaException;
import com.leonardo.gateway.jpa.IGenericJPAGateway;
import com.leonardo.infrastructure.dao.Persistente;

public abstract class GenericJPAService<T extends Persistente, E extends Serializable>
        implements IGenericJPAService<T, E> {

    protected IGenericJPAGateway<T, E> dao;

    public GenericJPAService(IGenericJPAGateway<T, E> dao) {
		this.dao = dao;
	}

    @Override
    public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        return this.dao.cadastrar(entity);
    }

    @Override
    public void excluir(T entity) throws DAOException {
        this.dao.excluir(entity);
    }

    @Override
    public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        return this.dao.alterar(entity);
    }

    @Override
    public T consultar(E valor) throws MaisDeUmRegistroException, TableException, DAOException {
        return this.dao.consultar(valor);
    }

    @Override
    public Collection<T> buscarTodos() throws DAOException {
        return this.dao.buscarTodos();
    }

}
