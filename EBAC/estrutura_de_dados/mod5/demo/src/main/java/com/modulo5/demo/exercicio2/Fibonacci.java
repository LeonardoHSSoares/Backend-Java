package com.modulo5.demo.exercicio2;

/**
 * Classe para calcular a sequência de Fibonacci de forma recursiva.
 */
class Fibonacci {
    public int calcular(int n) {
        
        if (n < 0) throw new IllegalArgumentException("Entrada não pode ser negativa");

        if (n == 0) return 0;

        if (n == 1) return 1;

        return calcular(n - 1) + calcular(n - 2);
    }
}
