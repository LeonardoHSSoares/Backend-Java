package com.leonardo.mock;

import java.util.Collection;

import com.leonardo.domain.Cliente;
import com.leonardo.exceptions.DAOException;
import com.leonardo.exceptions.MaisDeUmRegistroException;
import com.leonardo.exceptions.TableException;
import com.leonardo.exceptions.TipoChaveNaoEncontradaException;
import com.leonardo.gateway.IClienteGateway;


public class ClienteDAOMock implements IClienteGateway{

    @Override
    public Boolean cadastrar(Cliente entity) throws TipoChaveNaoEncontradaException, DAOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cadastrar'");
    }

    @Override
    public void excluir(Long valor) throws DAOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'excluir'");
    }

    @Override
    public void alterar(Cliente entity) throws TipoChaveNaoEncontradaException, DAOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alterar'");
    }

    @Override
    public Cliente consultar(Long valor) throws MaisDeUmRegistroException, TableException, DAOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'consultar'");
    }

    @Override
    public Collection<Cliente> buscarTodos() throws DAOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarTodos'");
    }

}
