package com.leonardo.dao.estoque;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.leonardo.dao.generic.GenericDAO;
import com.leonardo.domain.estoque.Estoque;
import com.leonardo.domain.produto.Produto;
import com.leonardo.exceptions.DAOException;
import com.leonardo.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author Leonardo Soares
 */
public class EstoqueDAO extends GenericDAO<Estoque, Long> implements IEstoqueDAO {

    @Override
    public Estoque buscarPorProduto(String codigoProduto) throws TipoChaveNaoEncontradaException, DAOException {
        String sql = "SELECT * FROM TB_ESTOQUE WHERE produto = ?";
        try (Connection conn = getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setString(1, codigoProduto);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    Estoque estoque = new Estoque();
                    estoque.setId(rs.getLong("id"));
                    Produto produto = new Produto();
                    produto.setCodigo(codigoProduto);
                    estoque.setProduto(produto);
                    estoque.setQuantidade(rs.getInt("quantidade"));
                    return estoque;
                }
            }
        } catch (SQLException e) {
            throw new DAOException("Erro ao buscar estoque por produto", e);
        }
        return null;
    }

    @Override
    public Class<Estoque> getTipoClasse() {
        return Estoque.class;
    }

    @Override
    public void atualizarDados(Estoque entity, Estoque entityCadastrado) {
        entityCadastrado.setQuantidade(entity.getQuantidade());
    }

    @Override
    protected String getQueryInsercao() {
        return "INSERT INTO TB_ESTOQUE (id, produto, quantidade) VALUES (?, ?, ?)";
    }

    @Override
    protected String getQueryExclusao() {
        return "DELETE FROM TB_ESTOQUE WHERE id = ?";
    }

    @Override
    protected String getQueryAtualizacao() {
        return "UPDATE TB_ESTOQUE SET quantidade = ? WHERE produto = ?";
    }

    @Override
    protected void setParametrosQueryInsercao(PreparedStatement stmInsert, Estoque entity) throws SQLException {
        stmInsert.setLong(1, entity.getId());
        stmInsert.setString(2, entity.getProduto().getCodigo());
        stmInsert.setInt(3, entity.getQuantidade());
    }

    @Override
    protected void setParametrosQueryExclusao(PreparedStatement stmDelete, Long valor) throws SQLException {
        stmDelete.setLong(1, valor);
    }

    @Override
    protected void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Estoque entity) throws SQLException {
        stmUpdate.setInt(1, entity.getQuantidade());
        stmUpdate.setString(2, entity.getProduto().getCodigo());
    }

    @Override
    protected void setParametrosQuerySelect(PreparedStatement stmSelect, Long valor) throws SQLException {
        stmSelect.setLong(1, valor);
    }

    @Override
    public void atualizarQuantidade(String codigoProduto, int novaQuantidade) throws DAOException {
        String sql = "UPDATE TB_ESTOQUE SET quantidade = ? WHERE produto = ?";
        try (Connection conn = getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {
            stm.setInt(1, novaQuantidade);
            stm.setString(2, codigoProduto);
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erro ao atualizar quantidade do estoque", e);
        }
    }

}
