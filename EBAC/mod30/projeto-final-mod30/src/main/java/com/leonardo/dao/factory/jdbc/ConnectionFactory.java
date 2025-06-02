package com.leonardo.dao.factory.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Leonardo Soares
 *
 *         Classe responsável por gerenciar a conexão com o banco de dados
 *         PostgreSQL.
 *         Utiliza o padrão Singleton para garantir que apenas uma conexão seja
 *         criada durante a execução da aplicação.
 */

public class ConnectionFactory {

    private static final String URL = "jdbc:postgresql://localhost:5432/ebac";
    private static final String USER = "postgres";

    private static Connection connection;

    private ConnectionFactory(Connection connection) {
        // Construtor privado para evitar instância externa
    }

    public static Connection getConnection() throws SQLException {
        // Se a conexão for nula ou estiver fechada, inicialize uma nova conexão.
        if (connection == null || connection.isClosed()) {
            connection = initConnection();
        }

        // Retorna a conexão ativa.
        return connection;
    }

    private static Connection initConnection() throws SQLException {
        try {
            return DriverManager.getConnection(URL, USER, "admin");
        } catch (SQLException e) {
            throw new SQLException("Driver not found", e);
        }

    }

    public static void closeConnection(Connection connection, PreparedStatement stm, ResultSet rs) {
    try {
        if (rs != null) rs.close();
        if (stm != null) stm.close();
        if (connection != null) connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

}
