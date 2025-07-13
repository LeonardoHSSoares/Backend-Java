package com.leonardo;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import com.leonardo.jpa.ClienteJPADAO2BancosTest;
import com.leonardo.jpa.ClienteJPADAO3BancosTest;
import com.leonardo.jpa.ClienteJPADAOTest;


@Suite
@SelectClasses({
    ClienteJPADAOTest.class,
    ClienteJPADAO2BancosTest.class,
    ClienteJPADAO3BancosTest.class
})
public class AllTests { 
    // This class remains empty, it is used only as a holder for the above annotations
    // It will run all tests in ClienteDAOTest and ProdutoDAOTest classes
}