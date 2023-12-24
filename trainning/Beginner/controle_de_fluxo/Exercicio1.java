package controle_de_fluxo;

import java.util.Scanner;

/**
 * 1. Ler um número inteiro e dizer se ele é par ou impar:
 */
public class Exercicio1 {

    public static void main(String[] args) {

        System.out.print("\033[H\033[2J");
        coletaNum();

    }

    public static void coletaNum() {

        Scanner leia = new Scanner(System.in);

        desenhaLinha();
        System.out.println("Digite um numero inteiro: ");
        desenhaLinha();
        int iNum = leia.nextInt();
        leia.close();
        System.out.print("\033[H\033[2J");

        verificaPar(iNum);
        verificaImpar(iNum);

    }

    public static void verificaPar(int i) {
        if (i % 2 == 0) {
            desenhaLinha();
            System.out.println("Numero " + i + " é PAR!");
            desenhaLinha();
        }
    }

    public static void verificaImpar(int i) {
        if (i % 3 == 0) {
            desenhaLinha();
            System.out.println("Numero " + i + " é IMPAR!");
            desenhaLinha();
        }
    }

    public static void desenhaLinha() {
        System.out.println("\n");
        for (int i = 0; i < 65; i++) {

            System.out.print("-");

        }
        System.out.println("\n");
    }
}
