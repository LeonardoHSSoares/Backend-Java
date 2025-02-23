package com.leonardo.domain;

import java.sql.Connection;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.leonardo.dao.ClienteDAO;
import com.leonardo.jdbc.ConnectionFactory;

public class ClienteTest {

    private ClienteDAO clienteDAO;
    private Connection connection;

    @BeforeEach
    public void setUp() throws Exception {
        connection = ConnectionFactory.getConnection();
        clienteDAO = new ClienteDAO();
    }

    @AfterEach
    public void tearDown() throws Exception {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    @Test
    public void testCadastrarCliente() throws Exception {
        Cliente cliente = new Cliente("Leonardo Soares", "123456789");
        int resultado = clienteDAO.cadastrar(cliente);
        assertEquals(1, resultado, "Erro ao cadastrar cliente.");

    }

    @Test
    public void testAtualizarCliente() throws Exception {
        Cliente cliente = new Cliente("Carlos Silva", "987654321");
        clienteDAO.cadastrar(cliente);
        cliente.setNome("Carlos Santos");
        cliente.setCodigo("111222333");
        int resultado = clienteDAO.atualizar(cliente);

        assertEquals(1, resultado, "Erro ao atualizar cliente.");
    }

    @Test
    public void testBuscarCliente() throws Exception {
        Cliente cliente = new Cliente("Mariana Lima", "444555666");
        clienteDAO.cadastrar(cliente);

        Cliente clienteBuscado = clienteDAO.buscarEntidade(cliente.getId_cliente());
        assertNotNull(clienteBuscado, "Cliente não encontrado.");
        assertEquals(cliente.getNome(), clienteBuscado.getNome());
    }

    @Test
    public void testBuscarTodosClientes() throws Exception {
        Cliente cliente1 = new Cliente("Ana Souza", "777888999");
        Cliente cliente2 = new Cliente("Bruno Costa", "555666777");

        clienteDAO.cadastrar(cliente1);
        clienteDAO.cadastrar(cliente2);

        assertTrue(clienteDAO.buscarTodos().size() > 0, "Erro ao buscar todos os clientes.");
    }

    @Test
    public void testExcluirCliente() throws Exception {
        Cliente cliente = new Cliente("Paulo Henrique", "999888777");
        clienteDAO.cadastrar(cliente);
        int resultado = clienteDAO.excluirEntidade(cliente);
        assertEquals(1, resultado, "Erro ao excluir cliente.");
    }
}
