/*
 * Os exercícios do módulo envolvem a criação de algoritmos recursivos e com programação dinâmica.
 * 
O primeiro exercício faz uso de recursão para calcular o fatorial de um número, com exemplos práticos.

O fatorial é definido como a multiplicação sequencial de números inteiros, e seu crescimento é exponencial com o aumento da entrada.

É fundamental implementar uma condição de parada em funções recursivas para evitar consumo excessivo de memória.

No segundo exercício, os alunos devem calcular o fatorial usando programação dinâmica, abordagens top-down e bottom-up.

A programação dinâmica ajuda a otimizar o problema, evitando o recálculo de números fatoriais anteriores.

O terceiro exercício requer que os alunos comparem a complexidade de tempo da solução de Fibonacci nos métodos recursivo e de programação dinâmica.
 */

public class Fatorial {
    
    // Método recursivo simples
    public static long fatorialRecursivo(int n) {
        if (n == 0 || n == 1) return 1;
        return n * fatorialRecursivo(n - 1);
    }
    
    // Programação dinâmica - abordagem top-down (memoization)
    public static long fatorialTopDown(int n, long[] memo) {
        if (n == 0 || n == 1) return 1;
        if (memo[n] != 0) return memo[n];
        return memo[n] = n * fatorialTopDown(n - 1, memo);
    }
    
    // Programação dinâmica - abordagem bottom-up (tabulação)
    public static long fatorialBottomUp(int n) {
        long[] dp = new long[n + 1];
        dp[0] = dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            dp[i] = i * dp[i - 1];
        }
        
        return dp[n];
    }
    
    public static void main(String[] args) {
        int n = 10;
        
        System.out.println("Fatorial Recursivo: " + fatorialRecursivo(n));
        System.out.println("Fatorial Top-Down: " + fatorialTopDown(n, new long[n + 1]));
        System.out.println("Fatorial Bottom-Up: " + fatorialBottomUp(n));
    }
}

