package tests.main;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import tests.main.dao.ClienteDAOTest;
import tests.main.dao.ClienteMapDAOTest;
import tests.main.dao.ClienteSetDAOTest;
import tests.main.domain.ClienteTest;

@Suite
@SelectClasses({
        ClienteDAOTest.class,
        ClienteTest.class,
        ClienteMapDAOTest.class,
        ClienteSetDAOTest.class
})
public class AllTests {

}
