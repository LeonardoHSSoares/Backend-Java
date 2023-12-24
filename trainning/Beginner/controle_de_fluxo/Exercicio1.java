package controle_de_fluxo;

import java.util.Scanner;

public class Exercicio1 {

    public static void main(String[] args) {

        coletaNum();

    }

    public static void coletaNum() {

        Scanner leia = new Scanner(System.in);

        System.out.println("Digite um numero inteiro: ");
        int iNum = leia.nextInt();

        leia.close();
        desenhaLinha();
        System.out.println("Numero antes da conversão: " + iNum);
        desenhaLinha();

    }

    public static void desenhaLinha() {

        for (int i = 0; i < 65; i++) {
            System.out.print("-");

        }
    }
}
