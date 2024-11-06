package tests.main.dao;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.dao.ClienteSetDAO;
import main.domain.Cliente;
import tests.mocks.MockCliente;

public class ClienteDAOTest {

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
        clienteDAO.excluir(12345678901L);
        assertNull(clienteDAO.consultar(12345678901L));
    }

    @Test
    public void testAlterarCliente() {
        cliente.setNome("João Silva");
        clienteDAO.alterar(cliente);
        Cliente clienteAlterado = clienteDAO.consultar(12345678901L);
        assertEquals("João Silva", clienteAlterado.getNome());
    }

    @Test
    public void testConsultarCliente() {
        Cliente clienteConsultado = clienteDAO.consultar(12345678901L);
        assertNotNull(clienteConsultado);
        assertEquals("João Silva", clienteConsultado.getNome());
    }

    @Test
    public void testBuscarTodosClientes() {
        Collection<Cliente> clientes = clienteDAO.buscarTodos();
        assertEquals(1, clientes.size());
    }

}
