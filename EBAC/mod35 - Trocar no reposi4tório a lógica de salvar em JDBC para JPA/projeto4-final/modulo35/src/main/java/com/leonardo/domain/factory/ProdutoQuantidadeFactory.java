package com.leonardo.domain.factory;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.leonardo.domain.ProdutoQuantidade;
import com.leonardo.domain.produto.Produto;

/**
 * @author Leonardo Soares
 *         Fábrica para criar objetos ProdutoQuantidade a partir de um
 *         ResultSet.
 *         Esta classe é responsável por converter os dados de um ResultSet
 */
public class ProdutoQuantidadeFactory {

    public static ProdutoQuantidade convert(ResultSet rs) throws SQLException {
        Produto prod = ProdutoFactory.convert(rs);
        ProdutoQuantidade prodQ = new ProdutoQuantidade();
        prodQ.setProduto(prod);
        prodQ.setId(rs.getLong("ID"));
        prodQ.setQuantidade(rs.getInt("QUANTIDADE"));
        prodQ.setValorTotal(rs.getBigDecimal("VALOR_TOTAL"));
        return prodQ;
    }
}
