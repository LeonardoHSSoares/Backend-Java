package com.leonardo.dao.factory.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String urlPostgres = "jdbc:postgresql://localhost:5432/ebac";
    private static final String userPostgres = "postgres";

    private static Connection connection;

    private ConnectionFactory(Connection connection) {
        // Private constructor to prevent instantiation
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = initConnection();
        }
        return connection;
    }

    private static Connection initConnection() throws SQLException {
        try {
            return DriverManager.getConnection(urlPostgres, userPostgres, "admin");
        } catch (SQLException e) {
            throw new SQLException("Driver not found", e);
        }

    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException("Error closing connection", e);
            }
        }
    }

}
