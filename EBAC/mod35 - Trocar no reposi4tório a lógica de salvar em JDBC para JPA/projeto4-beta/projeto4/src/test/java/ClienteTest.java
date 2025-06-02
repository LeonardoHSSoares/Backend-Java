
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.leonardo.dao.GenericDAOImpl;
import com.leonardo.domain.Cliente;

public class ClienteTest {

    private GenericDAOImpl<Cliente> clienteDAO;

    @BeforeEach
    public void setUp() {
        clienteDAO = new GenericDAOImpl<>(Cliente.class);
    }

    @Test
    public void cadastrarClienteTest() {
        Cliente cliente = new Cliente();
        cliente.setNome("Neo Soares");
        cliente.setCpf("99999999995");
        cliente.setEndereco("Rua Teste");
        cliente.setTelefone("11999999955");

        clienteDAO.cadastrar(cliente);

    }

    @Test
    public void atualizarClienteTest() {
        Cliente cliente = clienteDAO.consultar(1L);
        cliente.setCpf("12345678901");
        cliente.setNome("Leonardo Soares");
        cliente.setEndereco("Rua Atualizada");
        cliente.setTelefone("11999999997");
        assertNotNull(cliente);
        clienteDAO.atualizar(cliente);

        Cliente clienteAtualizado = clienteDAO.consultar(cliente.getId());
        assertEquals("Leonardo Soares", clienteAtualizado.getNome());
    }

    @Test
    public void consultarClienteTest() {
        Cliente cliente = clienteDAO.consultar(1L);
        assertNotNull(cliente);
        assertEquals("Leonardo Soares", cliente.getNome());
    }

    @Test
    public void excluirClienteTest() {
        Cliente cliente = new Cliente();
        cliente.setNome("Cliente para Exclusão");
        cliente.setCpf("98765432100");
        cliente.setEndereco("Rua Exclusão 3.0");
        cliente.setTelefone("11999999999");
        clienteDAO.cadastrar(cliente);
        assertNotNull(cliente);

        clienteDAO.excluir(cliente.getId());

        Cliente clienteExcluido = clienteDAO.consultar(cliente.getId());
        assertEquals(null, clienteExcluido);
    }

    @Test
    public void buscarTodosClientesTest() {
        List<Cliente> clientes = clienteDAO.buscarTodos();
        assertNotNull(clientes);
    }

}
