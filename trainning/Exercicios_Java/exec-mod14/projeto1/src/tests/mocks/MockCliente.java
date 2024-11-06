package tests.mocks;

import org.mockito.Mockito;
import main.domain.Cliente;

public class MockCliente {

    public static Cliente createMockCliente() {
        Cliente clienteMock = Mockito.mock(Cliente.class);
        
        Mockito.when(clienteMock.getNome()).thenReturn("João Silva");
        Mockito.when(clienteMock.getCpf()).thenReturn(12345678901L);
        Mockito.when(clienteMock.getTel()).thenReturn(11987654321L);
        Mockito.when(clienteMock.getEndereco()).thenReturn("Rua A");
        Mockito.when(clienteMock.getNumCasa()).thenReturn(100);
        Mockito.when(clienteMock.getCidade()).thenReturn("São Paulo");
        Mockito.when(clienteMock.getEstado()).thenReturn("SP");
    
        return clienteMock;
    }
}
