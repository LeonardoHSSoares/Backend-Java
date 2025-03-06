package com.modulo5.demo.exercicio2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 * Testes unitários para a sequência de Fibonacci.
 */
class FibonacciTest {
    private final Fibonacci fibonacci = new Fibonacci();

    @Test
    void testFibonacciBase() {
        assertEquals(0, fibonacci.calcular(0));
        assertEquals(1, fibonacci.calcular(1));
    }
    
    @Test
    void testFibonacciNormal() {
        assertEquals(8, fibonacci.calcular(6));
        assertEquals(21, fibonacci.calcular(8));
    }
    
    @Test
    void testFibonacciNegativo() {
        assertThrows(IllegalArgumentException.class, () -> fibonacci.calcular(-1));
    }
}
