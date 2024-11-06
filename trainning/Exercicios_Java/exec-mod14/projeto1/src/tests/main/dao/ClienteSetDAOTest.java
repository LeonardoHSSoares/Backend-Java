package tests.main.dao;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.dao.ClienteSetDAO;
import main.domain.Cliente;
import tests.mocks.MockCliente;

public class ClienteSetDAOTest {

    private ClienteSetDAO clienteDAO;
    private Cliente cliente;

    @BeforeEach
    public void setup() {
        clienteDAO = new ClienteSetDAO();
        cliente = MockCliente.createMockCliente();
        clienteDAO.cadastrar(cliente);
    }

    @Test
    public void testCadastrarCliente() {
        Cliente novoCliente = new Cliente("Maria Souza", 98765432101L, 11912345678L, "Rua B", 200, "Rio de Janeiro", "RJ");
        assertTrue(clienteDAO.cadastrar(novoCliente));
    }

    @Test
    public void testExcluirCliente() {
        clienteDAO.excluir(cliente.getCpf());
        assertNull(clienteDAO.consultar(cliente.getCpf()));
    }

    @Test
    public void testAlterarCliente() {
    cliente.setNome("Maria da Silva");
    clienteDAO.alterar(cliente); 
    Cliente clienteAlterado = clienteDAO.consultar(cliente.getCpf());
    assertEquals("Maria da Silva", clienteAlterado.getNome());
}

    @Test
    public void testConsultarCliente() {
        Cliente clienteConsultado = clienteDAO.consultar(cliente.getCpf());
        assertNotNull(clienteConsultado);
        assertEquals(cliente.getNome(), clienteConsultado.getNome());
    }

    @Test
    public void testBuscarTodosClientes() {
        assertEquals(1, clienteDAO.buscarTodos().size());
    }
}
