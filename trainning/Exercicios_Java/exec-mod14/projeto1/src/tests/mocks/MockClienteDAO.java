package tests.mocks;

import org.mockito.Mockito;
import main.dao.IClienteDAO;
import main.domain.Cliente;

public class MockClienteDAO {

    public static IClienteDAO createMockIClienteDAO() {
        IClienteDAO clienteDAOMock = Mockito.mock(IClienteDAO.class);

        Mockito.doNothing().when(clienteDAOMock).excluir(Mockito.anyLong());
        Mockito.doNothing().when(clienteDAOMock).alterar(Mockito.any(Cliente.class));

        Mockito.when(clienteDAOMock.cadastrar(Mockito.any(Cliente.class))).thenReturn(true);
        Mockito.when(clienteDAOMock.consultar(Mockito.anyLong())).thenReturn(MockCliente.createMockCliente());
        Mockito.when(clienteDAOMock.buscarTodos()).thenReturn(java.util.Collections.singletonList(MockCliente.createMockCliente()));

        return clienteDAOMock;
    }
}