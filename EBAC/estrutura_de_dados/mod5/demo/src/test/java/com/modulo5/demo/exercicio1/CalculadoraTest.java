package com.modulo5.demo.exercicio1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class CalculadoraTest {
    
    private final Calculadora calculadora = new Calculadora();
    
    @Test
    void testAdicionar() {
        assertEquals(5, calculadora.adicionar(2, 3));
        assertEquals(-1, calculadora.adicionar(2, -3));
    }
    
    @Test
    void testSubtrair() {
        assertEquals(1, calculadora.subtrair(3, 2));
        assertEquals(-5, calculadora.subtrair(-2, 3));
    }
    
    @Test
    void testMultiplicar() {
        assertEquals(6, calculadora.multiplicar(2, 3));
        assertEquals(-6, calculadora.multiplicar(2, -3));
    }
    
    @Test
    void testDividir() {
        assertEquals(2, calculadora.dividir(6, 3));
        assertThrows(ArithmeticException.class, () -> calculadora.dividir(6, 0));
    }
}
