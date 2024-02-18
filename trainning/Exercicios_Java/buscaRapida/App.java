import java.util.Random;

public class App {

    public static void main(String[] args) {
        Random sorteia = new Random();
        int[] vetor = new int[sorteia.nextInt(10)];

        sortVetor(vetor);

        System.out.println("Vetor antes da ordenação: ");
        imprimeArray(vetor);

        ordena(vetor, 0, vetor.length - 1);

        System.out.println("\nVetor depois da ordenação: ");
        imprimeArray(vetor);
    }

    public static void ordena(int[] vetor, int menor, int maior) {
        if (menor < maior) {
            int pivoIndex = divideVetor(vetor, menor, maior);
            ordena(vetor, menor, pivoIndex - 1);
            ordena(vetor, pivoIndex + 1, maior);
        }
    }

    public static int divideVetor(int[] vetor, int menor, int maior) {
        int pivoIndex = vetor[maior];
        int i = menor - 1;
        for (int j = menor; j < maior; j++) {
            if (vetor[j] <= pivoIndex) {
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

    public static void imprimeArray(int[] vetor) {
        for (int elemento : vetor) {
            System.out.print("[" + elemento + "] ");
        }
    }

    public static void sortVetor(int[] vetor) {
        Random sorteia = new Random();
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = sorteia.nextInt(100);
        }
    }
}