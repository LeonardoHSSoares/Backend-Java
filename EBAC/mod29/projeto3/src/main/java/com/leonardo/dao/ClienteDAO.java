package com.leonardo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.leonardo.domain.Cliente;
import com.leonardo.jdbc.ConnectionFactory;

public class ClienteDAO extends GenericDAO<Cliente> implements IClienteDAO {

    @Override
    public Integer cadastrar(Cliente cliente) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSQLInsert();
            stm = connection.prepareStatement(sql);
            adicionaParametrosInsert(stm, cliente);
            return stm.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, null);
        }

    }

    @Override
    public Integer atualizar(Cliente cliente) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSQLUpdate();
            stm = connection.prepareStatement(sql);
            adicionaParametrosUpdate(stm, cliente);
            return stm.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, null);
        }

    }

    
    @Override
    public Cliente buscarEntidade(Long id_cliente) throws Exception {

        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet resultSet = null;
        Cliente cliente = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSQLSelect();
            stm = connection.prepareStatement(sql);
            adicionaParametrosSelect(stm, id_cliente);
            resultSet = stm.executeQuery();

            if (resultSet.next()) {
                cliente = new Cliente();
                Long id = resultSet.getLong("id_cliente");
                String nome = resultSet.getString("nome");
                String cd = resultSet.getString("codigo");
                cliente.setId_cliente(id);
                cliente.setNome(nome);
                cliente.setCodigo(cd);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, resultSet);
        }
        return cliente;
    }


    @Override
    public List<Cliente> buscarTodos() throws Exception {
        List<Cliente> clientes = new ArrayList<>();
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stm = connection.prepareStatement(getSQLSelectAll());
        ResultSet resultSet = stm.executeQuery();
        try  {
            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setId_cliente(resultSet.getLong("id_cliente"));
                cliente.setNome(resultSet.getString("nome"));
                cliente.setCodigo(resultSet.getString("codigo"));
                clientes.add(cliente);
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar clientes", e);
        }finally {
            closeConnection(connection, stm, null);
        }

        return clientes;

    }

    @Override
    public Integer excluirEntidade(Cliente cliente) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSQLDelete();
            stm = connection.prepareStatement(sql);
            adicionaParametrosDelete(stm, cliente);
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
        sb.append("INSERT INTO tb_cliente (nome, codigo) ");
        sb.append("VALUES (?, ?)");
        return sb.toString();

    }

    @Override
    protected void adicionaParametrosInsert(PreparedStatement stm, Cliente entidade) throws SQLException {
        stm.setString(1, entidade.getNome());
        stm.setString(2, entidade.getCodigo());

    }

    @Override
    protected String getSQLSelect() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT id_cliente, nome, codigo FROM tb_cliente ");
        sb.append("WHERE id_cliente = ?");
        return sb.toString();
    }

    @Override
    protected void adicionaParametrosSelect(PreparedStatement stm, Long id_cliente) throws SQLException {
        if (id_cliente == null) {
            throw new SQLException("O ID do cliente não pode ser nulo.");
        }
        stm.setLong(1, id_cliente);
    
    }

    @Override
    protected String getSQLUpdate() {
        StringBuilder sb = new StringBuilder();
        sb.append("update tb_cliente ");
        sb.append("set nome = ?, codigo = ? ");
        sb.append("where id_cliente = ?");
        return sb.toString();
    }

    @Override
    protected void adicionaParametrosUpdate(PreparedStatement stm, Cliente entidade) throws SQLException {
        stm.setString(1, entidade.getNome());
        stm.setString(2, entidade.getCodigo());
        stm.setLong(3, entidade.getId_cliente());

    }

    @Override
    protected String getSQLDelete() {
        StringBuilder sb = new StringBuilder();
        sb.append("delete from tb_cliente ");
        sb.append("where id_cliente = ?");
        return sb.toString();

    }

    @Override
    protected void adicionaParametrosDelete(PreparedStatement stm, Cliente entidade) throws SQLException {
        stm.setLong(1, entidade.getId_cliente());

    }

    @Override
    protected String getSQLSelectAll() {
        StringBuilder sb = new StringBuilder();
        sb.append("select * from tb_cliente");
        return sb.toString();

    }

}
