package com.leonardo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class GenericDAO<T> {

    protected abstract String getSQLInsert();

    protected abstract void adicionaParametrosInsert(PreparedStatement stm, T entidade) throws SQLException;

    protected abstract String getSQLSelect();

    protected abstract void adicionaParametrosSelect(PreparedStatement stm, Long id_cliente) throws SQLException;

    protected abstract String getSQLUpdate();

    protected abstract void adicionaParametrosUpdate(PreparedStatement stm, T entidade) throws SQLException;

    protected abstract String getSQLDelete();

    protected abstract void adicionaParametrosDelete(PreparedStatement stm, T entidade) throws SQLException;

    protected abstract String getSQLSelectAll();

    protected void closeConnection(Connection connection, PreparedStatement stm, ResultSet rs) {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
        }
    }

}
