package com.leonardo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.leonardo.domain.Produto;
import com.leonardo.jdbc.ConnectionFactory;

public class ProdutoDAO extends GenericDAO<Produto> implements IProdutoDAO {

    @Override
    public Integer cadastrar(Produto entidade) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSQLInsert();
            stm = connection.prepareStatement(sql);
            adicionaParametrosInsert(stm, entidade);
            return stm.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, null);
        }

    }

    @Override
    public Integer atualizar(Produto entidade) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSQLUpdate();
            stm = connection.prepareStatement(sql);
            adicionaParametrosUpdate(stm, entidade);
            return stm.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, null);
        }
    }

    @Override
    public Produto buscarEntidade(Long id_produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet resultSet = null;
        Produto produto = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSQLSelect();
            stm = connection.prepareStatement(sql);
            adicionaParametrosSelect(stm, id_produto);
            resultSet = stm.executeQuery();

            if (resultSet.next()) {
                produto = new Produto();
                produto.setId_produto(resultSet.getLong("id_produto"));
                produto.setNome(resultSet.getString("nome"));
                produto.setPreco(resultSet.getDouble("preco"));
                produto.setDescricao(resultSet.getString("descricao"));
            }

        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, resultSet);
        }
        return produto;
    }

    @Override
    public List<Produto> buscarTodos() throws Exception {
        List<Produto> produtos = new ArrayList<>();
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stm = connection.prepareStatement(getSQLSelectAll());
        ResultSet resultSet = stm.executeQuery();
        try {
            while (resultSet.next()) {
                Produto produto = new Produto();
                produto.setId_produto(resultSet.getLong("id_produto"));
                produto.setNome(resultSet.getString("nome"));
                produto.setPreco(resultSet.getDouble("preco"));
                produto.setDescricao(resultSet.getString("descricao"));
                produtos.add(produto);
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar clientes", e);
        } finally {
            closeConnection(connection, stm, null);
        }

        return produtos;

    }

    @Override
    public Integer excluirEntidade(Produto entidade) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSQLDelete();
            stm = connection.prepareStatement(sql);
            adicionaParametrosDelete(stm, entidade);
            return stm.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, null);
        }

    }

    @Override
    protected String getSQLInsert() {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO tb_produto (nome, descricao, preco) ");
        sb.append("VALUES (?, ?, ?)");
        return sb.toString();
    }

    @Override
    protected void adicionaParametrosInsert(PreparedStatement stm, Produto produto) throws SQLException {
        stm.setString(1, produto.getNome());
        stm.setString(2, produto.getDescricao());
        stm.setDouble(3, produto.getPreco());
    }

    @Override
    protected String getSQLSelect() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT id_produto, nome, descricao, preco FROM tb_produto ");
        sb.append("WHERE id_produto = ?");
        return sb.toString();
    }

    @Override
    protected void adicionaParametrosSelect(PreparedStatement stm, Long id_produto) throws SQLException {
        stm.setLong(1, id_produto);
    }

    @Override
    protected String getSQLUpdate() {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE tb_produto SET nome = ?, descricao = ?, preco = ? ");
        sb.append("WHERE id_produto = ?");
        return sb.toString();
    }

    @Override
    protected void adicionaParametrosUpdate(PreparedStatement stm, Produto produto) throws SQLException {
        stm.setString(1, produto.getNome());
        stm.setString(2, produto.getDescricao());
        stm.setDouble(3, produto.getPreco());
        stm.setLong(4, produto.getId_produto());
    }

    @Override
    protected String getSQLDelete() {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM tb_produto ");
        sb.append("WHERE id_produto = ?");
        return sb.toString();
    }

    @Override
    protected void adicionaParametrosDelete(PreparedStatement stm, Produto produto) throws SQLException {
        stm.setLong(1, produto.getId_produto());
    }

    @Override
    protected String getSQLSelectAll() {
        return "SELECT * FROM tb_produto";
    }

}
