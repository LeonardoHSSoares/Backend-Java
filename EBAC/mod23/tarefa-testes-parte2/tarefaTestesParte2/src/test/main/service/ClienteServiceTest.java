package test.main.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.service.ClienteService;
import main.mocks.ClienteDAOMock;
import main.dao.ClienteDAO;
import main.dao.IClienteDAO;

public class ClienteServiceTest {

    private IClienteDAO clienteDAOMock;
    private IClienteDAO clienteDAO;

    @BeforeEach
    public void setup() {
        clienteDAOMock = new ClienteDAOMock();
        clienteDAO = new ClienteDAO();
    }

    @Test
    public void testeSalvar() {
        ClienteService service = new ClienteService(clienteDAOMock);
        String retorno = service.salvar();
        Assertions.assertEquals("Sucesso ao salvar", retorno);
    }

    @Test
    public void testeAtualizar() {
        ClienteService service = new ClienteService(clienteDAOMock);
        String retorno = service.atualizar();
        Assertions.assertEquals("Sucesso ao atualizar", retorno);
    }

    @Test
    public void testeExcluir() {
        ClienteService service = new ClienteService(clienteDAOMock);
        String retorno = service.excluir();
        Assertions.assertEquals("Sucesso ao excluir", retorno);
    }

    @Test
    public void testeConsultar() {
        ClienteService service = new ClienteService(clienteDAOMock);
        String retorno = service.consultar();
        Assertions.assertEquals("Sucesso ao consultar", retorno);
    }

    @Test
    public void esperadoErroNoSalvarTeste() {
        ClienteService service = new ClienteService(clienteDAO);
        UnsupportedOperationException exception = Assertions.assertThrows(
            UnsupportedOperationException.class,
            service::salvar
        );
        Assertions.assertEquals("Sem config à base de dados", exception.getMessage());
    }

    @Test
    public void esperadoErroNoAtualizarTeste() {
        ClienteService service = new ClienteService(clienteDAO);
        UnsupportedOperationException exception = Assertions.assertThrows(
            UnsupportedOperationException.class,
            service::atualizar
        );
        Assertions.assertEquals("Sem config à base de dados", exception.getMessage());
    }

    @Test
    public void esperadoErroNoExcluirTeste() {
        ClienteService service = new ClienteService(clienteDAO);
        UnsupportedOperationException exception = Assertions.assertThrows(
            UnsupportedOperationException.class,
            service::excluir
        );
        Assertions.assertEquals("Sem config à base de dados", exception.getMessage());
    }

    @Test
    public void esperadoErroNoConsultarTeste() {
        ClienteService service = new ClienteService(clienteDAO);
        UnsupportedOperationException exception = Assertions.assertThrows(
            UnsupportedOperationException.class,
            service::consultar
        );
        Assertions.assertEquals("Sem config à base de dados", exception.getMessage());
    }
}
