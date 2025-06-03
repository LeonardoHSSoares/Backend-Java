package com.leonardo;

import com.leonardo.dao.ClienteDAOTest;
import com.leonardo.dao.ProdutoDAOTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    ClienteDAOTest.class,
    ProdutoDAOTest.class
})
public class AllTests { 
    // This class remains empty, it is used only as a holder for the above annotations
    // It will run all tests in ClienteDAOTest and ProdutoDAOTest classes
}