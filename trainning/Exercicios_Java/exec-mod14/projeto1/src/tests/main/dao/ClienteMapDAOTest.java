package tests.main.dao;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.dao.ClienteMapDAO;
import main.domain.Cliente;
import tests.mocks.MockCliente;

public class ClienteMapDAOTest {

    private ClienteMapDAO clienteDAO;
    private Cliente cliente;

    @BeforeEach
    public void setup() {
        clienteDAO = new ClienteMapDAO();
        cliente = MockCliente.createMockCliente();
        clienteDAO.cadastrar(cliente);
    }

    @Test
    public void testCadastrarCliente() {

        Cliente novoCliente = new Cliente("Maria Souza", 98765432101L, 11912345678L, "Rua B", 200, "Rio de Janeiro",
                "RJ");
        assertTrue(clienteDAO.cadastrar(novoCliente));
    }

    @Test
    public void testExcluirCliente() {
        clienteDAO.excluir(cliente.getCpf());
        assertNull(clienteDAO.consultar(cliente.getCpf()));
    }

    @Test
    public void testAlterarCliente() {
        cliente.setNome("João da Silva");
        clienteDAO.alterar(cliente); // Atualiza o cliente no DAO com base no CPF
        Cliente clienteAlterado = clienteDAO.consultar(cliente.getCpf()); // Consulta para verificar
        assertEquals("João da Silva", clienteAlterado.getNome()); // Confirma a atualização
    }

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