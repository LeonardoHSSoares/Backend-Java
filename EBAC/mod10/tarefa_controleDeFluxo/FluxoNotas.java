package EBAC.mod10.tarefa_controleDeFluxo;

import java.util.Scanner;

public class FluxoNotas {

    /**
     * @param args
     */
    public static void main(String[] args) {

        double[] notas = new double[4];
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
        System.out.print("\033[H\033[2J");
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
        double media = 0;

        for (double nota : notas) {
            soma += nota;

            media = soma / notas.length;

        }
        if (media >= 7) {
            System.out.println("Aluno APROVADO!");
            System.out.println("Média Aritmetica: " + media);
        } else if (media < 7 && media >= 5) {
            System.out.println("Aluno de RECUPERAÇÃO!");
            System.out.println("Média Aritmetica: " + media);
        } else {
            System.out.println("Aluno de REPROVADO!");
            System.out.println("Média Aritmetica: " + media);

        }
    }
}
