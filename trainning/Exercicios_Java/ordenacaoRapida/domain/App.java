package domain;

import java.util.Random;
import java.util.Scanner;

/**
 * App
 */
public class App {

    public static void main(String[] args) {

        System.out.println("Digite um valor inteiro positivo para ser o indice do seu vetor: ");

        int[] vetor = new int[coletaIndiceVetor()];

        preenche(vetor);
        System.out.println("Antes");
        imprimeVetor(vetor);

        ordena(vetor, 0, vetor.length - 1);

        System.out.println("Depois");
        imprimeVetor(vetor);

    }

    public static void imprimeVetor(int[] vetor) {
        for (int i : vetor) {
            System.out.print("[" + i + "] ");

        }
        System.out.println();
    }

    public static void ordena(int[] vetor, int menor, int maior) {
        if (menor < maior) {
            int pivo = divideVetor(vetor, menor, maior);
            ordena(vetor, menor, pivo - 1);
            ordena(vetor, pivo + 1, maior);
        }
    }

    public static int divideVetor(int[] vetor, int menor, int maior) {
        int pivo = vetor[maior];
        int i = menor - 1;
        for (int j = menor; j < maior; j++) {
            if (vetor[j] <= pivo) {
                i++;
                int temp = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = temp;
            }
        }
        int temp = vetor[i + 1];
        vetor[i + 1] = vetor[maior];
        vetor[maior] = temp;
        return i + 1;
    }

    public static int coletaIndiceVetor() {
        Scanner leia = new Scanner(System.in);
        int vetor = leia.nextInt();
        leia.close();
        return vetor;
        
    }
    public static int[] preenche(int[] vetor) {
        Random sorteia = new Random();
        for (int i : vetor) {
             vetor[i] = sorteia.nextInt(100);
        }
        return vetor;
    }
}
