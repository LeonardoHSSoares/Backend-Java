package EBAC.mod8.tarefaCalculoMedia;

import java.util.Scanner;

/**
 * @author Leonardo
 * 
 */
public class CalculaMedia2{
   
    int cont = 1;

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        calculaMedia();

    }

    public static void calculaMedia() {
        
        double[] notas = new double[3];
        int cont = 1;

        Scanner leia = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            System.out.print("\033[H\033[2J");
            desenhaLinha();
            System.out.println("Digite a " + cont + "ª nota: ");
            notas[i] = leia.nextFloat();
            desenhaLinha();
            cont++;
        }

        leia.close();
        geraRelatorio(notas);
    }

    public static void desenhaLinha() {
        for (int i = 0; i < 35; i++) {
            System.out.print("-");
        }
        System.out.print("\n");
    }

    public static void geraRelatorio(double[] notas) {
        double soma = 0;

        for (double nota : notas) {
            soma += nota;
        }

        double media = soma / notas.length;

        System.out.println("A Média Aritmética ficou em: " + media);
    }
}

