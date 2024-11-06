package tests.mocks;

import org.mockito.Mockito;
import main.dao.ClienteSetDAO;


public class MockClienteSetDAO {

    public static ClienteSetDAO createMockClienteMapDAO() {
        return Mockito.mock(ClienteSetDAO.class);
    }
}
