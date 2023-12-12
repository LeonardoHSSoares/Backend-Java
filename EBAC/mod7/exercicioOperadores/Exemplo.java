package EBAC.mod7.exercicioOperadores;

public class Exemplo {
    
    private int a = 5;
    private int b = 6;

    public static void main(String[] args) {
        soma();
        subtrair();
        dividir();
        multiplicar();
    }

    private static void soma() {
        int soma = a + b;
    }
    private static int subtrair() {
        int subtracao = a - b;
        return subtracao;
    }
    private static float dividir() {
        float divisao = a / b;
        return divisao;
    }
    private static int multiplicar() {
        int divisao = a * b;
        return divisao;

    }
    
}
