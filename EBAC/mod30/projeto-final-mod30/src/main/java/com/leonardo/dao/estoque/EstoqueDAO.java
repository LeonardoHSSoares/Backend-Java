package com.leonardo.dao.estoque;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.leonardo.dao.generic.GenericDAO;
import com.leonardo.domain.estoque.Estoque;
import com.leonardo.exceptions.DAOException;
import com.leonardo.exceptions.TipoChaveNaoEncontradaException;

public class EstoqueDAO extends GenericDAO<Estoque, Long> implements IEstoqueDAO{

    @Override
    public Estoque buscarPorProduto(String codigoProduto) throws TipoChaveNaoEncontradaException, DAOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorProduto'");
    }

    @Override
    public Class<Estoque> getTipoClasse() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTipoClasse'");
    }

    @Override
    public void atualizarDados(Estoque entity, Estoque entityCadastrado) {
        entityCadastrado.setQuantidade(entity.getQuantidade());
    }

    @Override
    protected String getQueryInsercao() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getQueryInsercao'");
    }

    @Override
    protected String getQueryExclusao() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getQueryExclusao'");
    }

    @Override
    protected String getQueryAtualizacao() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getQueryAtualizacao'");
    }

    @Override
    protected void setParametrosQueryInsercao(PreparedStatement stmInsert, Estoque entity) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setParametrosQueryInsercao'");
    }

    @Override
    protected void setParametrosQueryExclusao(PreparedStatement stmDelete, Long valor) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setParametrosQueryExclusao'");
    }

    @Override
    protected void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Estoque entity) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setParametrosQueryAtualizacao'");
    }

    @Override
    protected void setParametrosQuerySelect(PreparedStatement stmUpdate, Long valor) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setParametrosQuerySelect'");
    }

}
