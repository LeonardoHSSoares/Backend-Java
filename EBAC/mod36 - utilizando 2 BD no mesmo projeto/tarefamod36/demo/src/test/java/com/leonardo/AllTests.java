package com.leonardo;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import com.leonardo.dao.ClienteDAOTest;
import com.leonardo.dao.ProdutoDAOTest;
import com.leonardo.dao.VendaDAOTest;

@Suite
@SelectClasses({
    ClienteDAOTest.class,
    ProdutoDAOTest.class,
    VendaDAOTest.class
})
public class AllTests { 
    // This class remains empty, it is used only as a holder for the above annotations
    // It will run all tests in ClienteDAOTest and ProdutoDAOTest classes
}