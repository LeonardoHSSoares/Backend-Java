package com.leonardo.dao.estoque;

import com.leonardo.dao.generic.IGenericDAO;
import com.leonardo.domain.estoque.Estoque;
import com.leonardo.exceptions.DAOException;
import com.leonardo.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author Leonardo Soares
 */
public interface IEstoqueDAO extends IGenericDAO<Estoque, Long>{

    Estoque buscarPorProduto(String codigoProduto) throws TipoChaveNaoEncontradaException, DAOException;

    void atualizarQuantidade(String codigoProduto, int novaQuantidade) throws DAOException;

}
