package EBAC.mod8.tarefaCalculoMedia;

import java.util.Scanner;

public class CalculaMedia1{

    public static void main(String[] args) {

        Scanner leia = new Scanner(System.in);

        System.out.print("\033[H\033[2J");

        desenhaLinha();
        System.out.println("Digite a primeira nota: ");
        double nota1 = leia.nextFloat();

        desenhaLinha();
        System.out.println("Digite a segunda nota: ");
        double nota2 = leia.nextFloat();

        desenhaLinha();
        System.out.println("Digite a terceira nota: ");
        double nota3 = leia.nextFloat();

        desenhaLinha();
        System.out.println("Digite a quarta nota: ");
        double nota4 = leia.nextFloat();

        leia.close();

        double media = (nota1 + nota2 + nota3 + nota4) / 4;

        System.out.print("\033[H\033[2J");
        desenhaLinha();
        System.out.println("A Média entre as notas é: " + media);
        desenhaLinha();

    }

    public static void desenhaLinha() {

        for (int i = 0; i < 30; i++) {

            System.out.print("-");

        }
        System.out.print("\n");
    }

}
