package com.leonardo.testes.dao;

import java.util.Collection;

import com.leonardo.dao.IProdutoDAO;
import com.leonardo.domain.Produto;
import com.leonardo.exceptions.TipoChaveNaoEncontradaException;

public class ProdutoDAOMock implements IProdutoDAO {

    @Override
    public Boolean cadastrar(Produto entity) throws TipoChaveNaoEncontradaException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cadastrar'");
    }

    @Override
    public void excluir(String valor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'excluir'");
    }

    @Override
    public void alterar(Produto entity) throws TipoChaveNaoEncontradaException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alterar'");
    }

    @Override
    public Produto consultar(String valor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'consultar'");
    }

    @Override
    public Collection<Produto> buscarTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarTodos'");
    }


    
}
