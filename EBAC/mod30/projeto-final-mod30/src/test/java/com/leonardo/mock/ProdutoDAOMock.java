package com.leonardo.mock;

import java.util.Collection;

import com.leonardo.dao.produto.IProdutoDAO;
import com.leonardo.domain.produto.Produto;
import com.leonardo.exceptions.DAOException;
import com.leonardo.exceptions.MaisDeUmRegistroException;
import com.leonardo.exceptions.TableException;
import com.leonardo.exceptions.TipoChaveNaoEncontradaException;

public class ProdutoDAOMock implements IProdutoDAO{

    @Override
    public Boolean cadastrar(Produto entity) throws TipoChaveNaoEncontradaException, DAOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cadastrar'");
    }

    @Override
    public void excluir(String valor) throws DAOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'excluir'");
    }

    @Override
    public void alterar(Produto entity) throws TipoChaveNaoEncontradaException, DAOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alterar'");
    }

    @Override
    public Produto consultar(String valor) throws MaisDeUmRegistroException, TableException, DAOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'consultar'");
    }

    @Override
    public Collection<Produto> buscarTodos() throws DAOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarTodos'");
    }

    @Override
    public void adicionarOuAtualizarEstoque(Produto produto, int quantidade) throws DAOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'adicionarOuAtualizarEstoque'");
    }

}
