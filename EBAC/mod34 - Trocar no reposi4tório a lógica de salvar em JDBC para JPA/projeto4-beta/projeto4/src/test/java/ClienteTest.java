
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.leonardo.dao.GenericDAOImpl;
import com.leonardo.domain.Cliente;

public class ClienteTest {
    private GenericDAOImpl<Cliente> dao;

    @BeforeEach
    public void setUp() {
        dao = new GenericDAOImpl<>(Cliente.class);
    }

    @Test
    public void testCadastrarConsultarCliente() {
        Cliente cliente = new Cliente();
        cliente.setNome("Carlos Teste");
        cliente.setCpf("99999999999");
        cliente.setEndereco("Rua Teste");
        cliente.setTelefone("11999999998");

        dao.cadastrar(cliente);

        Cliente encontrado = dao.consultar(cliente.getId());
        assertNotNull(encontrado);
        assertEquals("Carlos Teste", encontrado.getNome());
    }

    @Test
    public void testAtualizarCliente() {
        Cliente cliente = new Cliente();
        cliente.setNome("Ana");
        cliente.setCpf("88888888888");
        cliente.setEndereco("Rua B");
        cliente.setTelefone("1188888888");

        dao.cadastrar(cliente);

        cliente.setNome("Ana Atualizada");
        dao.atualizar(cliente);

        Cliente atualizado = dao.consultar(cliente.getId());
        assertEquals("Ana Atualizada", atualizado.getNome());
    }
}
