package tests.mocks;

import org.mockito.Mockito;
import main.dao.ClienteMapDAO;

public class MockClienteMapDAO {

    public static ClienteMapDAO createMockClienteMapDAO() {
        return Mockito.mock(ClienteMapDAO.class);
    }
}
