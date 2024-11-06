package test.main.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.service.ContratoService;
import main.mocks.ClienteDAOMock;
import main.dao.ClienteDAO;
import main.dao.IClienteDAO;
import main.service.IContratoService;

public class ContratoServiceTest {

    private IClienteDAO clienteDAOMock;
    private IClienteDAO clienteDAO;

    @BeforeEach
    public void setup() {
        clienteDAOMock = new ClienteDAOMock();
        clienteDAO = new ClienteDAO();
    }

    @Test
    public void testeSalvar() {
        IContratoService service = new ContratoService(clienteDAOMock);
        String retorno = service.salvar();
        Assertions.assertEquals("Sucesso ao salvar", retorno);
    }

    @Test
    public void testeAtualizar() {
        IContratoService service = new ContratoService(clienteDAOMock);
        String retorno = service.atualizar();
        Assertions.assertEquals("Sucesso ao atualizar", retorno);
    }

    @Test
    public void testeExcluir() {
        IContratoService service = new ContratoService(clienteDAOMock);
        String retorno = service.excluir();
        Assertions.assertEquals("Sucesso ao excluir", retorno);
    }

    @Test
    public void testeConsultar() {
        IContratoService service = new ContratoService(clienteDAOMock);
        String retorno = service.consultar();
        Assertions.assertEquals("Sucesso ao consultar", retorno);
    }

    @Test
    public void esperadoErroNoSalvarTeste() {
        IContratoService service = new ContratoService(clienteDAO);
        UnsupportedOperationException exception = Assertions.assertThrows(
            UnsupportedOperationException.class,
            service::salvar
        );
        Assertions.assertEquals("Sem config à base de dados", exception.getMessage());
    }

    @Test
    public void esperadoErroNoAtualizarTeste() {
        IContratoService service = new ContratoService(clienteDAO);
        UnsupportedOperationException exception = Assertions.assertThrows(
            UnsupportedOperationException.class,
            service::atualizar
        );
        Assertions.assertEquals("Sem config à base de dados", exception.getMessage());
    }

    @Test
    public void esperadoErroNoExcluirTeste() {
        IContratoService service = new ContratoService(clienteDAO);
        UnsupportedOperationException exception = Assertions.assertThrows(
            UnsupportedOperationException.class,
            service::excluir
        );
        Assertions.assertEquals("Sem config à base de dados", exception.getMessage());
    }

    @Test
    public void esperadoErroNoConsultarTeste() {
        IContratoService service = new ContratoService(clienteDAO);
        UnsupportedOperationException exception = Assertions.assertThrows(
            UnsupportedOperationException.class,
            service::consultar
        );
        Assertions.assertEquals("Sem config à base de dados", exception.getMessage());
    }
}