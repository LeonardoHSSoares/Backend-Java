package test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import test.main.service.ClienteServiceTest;
import test.main.service.ContratoServiceTest;


@Suite
@SelectClasses({
    ClienteServiceTest.class,
    ContratoServiceTest.class
})
public class AllTests {

}
