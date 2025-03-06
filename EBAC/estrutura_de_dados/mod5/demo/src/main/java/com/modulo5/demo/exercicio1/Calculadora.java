package com.modulo5.demo.exercicio1;

/**
 * Classe Calculadora para realizar operações matemáticas básicas.
 */
class Calculadora {
    /**
     * Adiciona dois números inteiros.
     */
    int adicionar(int a, int b) {
        return a + b;
    }

    /**
     * Subtrai o segundo número do primeiro.
     */
    int subtrair(int a, int b) {
        return a - b;
    }

    /**
     * Multiplica dois números inteiros.
     */
    int multiplicar(int a, int b) {
        return a * b;
    }

    /**
     * Divide o primeiro número pelo segundo, lançando exceção se b for 0.
     */
    int dividir(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Divisão por zero não permitida");
        }
        return a / b;
    }
}