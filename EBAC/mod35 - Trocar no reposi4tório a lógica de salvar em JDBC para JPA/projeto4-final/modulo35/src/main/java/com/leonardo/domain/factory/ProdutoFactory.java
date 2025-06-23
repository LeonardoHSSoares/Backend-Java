package com.leonardo.domain.factory;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.leonardo.domain.Produto;

/**
 * @author Leonardo Soares
 *
 */
public class ProdutoFactory {

    public static Produto convert(ResultSet rs) throws SQLException {
        Produto prod = new Produto();
        prod.setId(rs.getLong("ID_PRODUTO"));
        prod.setCodigo(rs.getString("CODIGO"));
        prod.setNome(rs.getString("NOME"));
        prod.setDescricao(rs.getString("DESCRICAO"));
        prod.setPreco(rs.getBigDecimal("VALOR"));
        prod.setQuantidadeEstoque(rs.getInt("QUANTIDADE_ESTOQUE"));
        return prod;
    }
}
