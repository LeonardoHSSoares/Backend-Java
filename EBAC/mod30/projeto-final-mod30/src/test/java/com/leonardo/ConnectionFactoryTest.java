package com.leonardo;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.gen5.api.Test;
import com.leonardo.dao.factory.jdbc.ConnectionFactory;

public class ConnectionFactoryTest {

    @Test
    public void testConnection() throws SQLException {

        try (Connection connection = ConnectionFactory.getConnection()) {

            assert connection != null;
            assert !connection.isClosed();

            System.out.println("Conexão estabelecida com sucesso!");

        } catch (SQLException e) {

            throw new SQLException("Erro ao estabelecer conexão: " + e.getMessage(), e);

        } finally {

            ConnectionFactory.closeConnection();

            assert ConnectionFactory.getConnection().isClosed();
            assert ConnectionFactory.getConnection() == null;

            System.out.println("Conexão fechada.");

        }
    }

    @Test
    public void testConnectionWithException() {

        try {
            ConnectionFactory.getConnection();
            assert false : "Expected SQLException was not thrown";
        } catch (SQLException e) {
            assert e.getMessage().contains("Connection error") : "Unexpected exception message: " + e.getMessage();
            System.out.println("Erro ao estabelecer conexão: " + e.getMessage());
        }
    }

}
