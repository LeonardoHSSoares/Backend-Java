package com.leonardo;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.leonardo.dao.factory.jdbc.ConnectionFactory;

public class ConnectionFactoryTest {

    @AfterEach
    public void tearDown() {
        try {
            Connection connection = ConnectionFactory.getConnection();
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while closing the connection: " + e.getMessage());
        }
    }

    @Test
    public void testConnection(){

        try {
            Connection connection = ConnectionFactory.getConnection();
            if (connection != null && !connection.isClosed()) {
                assert !connection.isClosed() : "Connection should be open";
                System.out.println("Connection successful!");
            } else {
                assert false : "Connection should not be null or closed";
                System.out.println("Connection failed!");
            }
        } catch (SQLException e) {

            System.out.println("An error occurred while trying to connect: " + e.getMessage());

        }

    }


}
