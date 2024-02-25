package app;

import java.util.Scanner;

/**
 * BuscaLinear
 */
public class BuscaLinear {

    
    public static void main(String[] args) {
       
        Integer[] vetor = {9,8,7,6,5,4,3,2,1,0};

        Integer alvo = coletaAlvo();

        int resultado = buscaLinear(vetor, alvo);

        imprimeRelatorio(vetor, resultado);
        
        
    }
    public static int buscaLinear(Integer[] vetor, int alvo) {

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == alvo) {
                return i;
            }
        }
        return -1;
    }
    public static void imprimeRelatorio(Integer[] vetor, int resultado) {
        if (resultado != -1) {
            System.out.println("Valor encontrado!");
            System.out.println("Endereço : ["+resultado+"] ");
            System.err.println("Conteúdo : "+vetor[resultado]+"");
        }
        else {
            System.out.println("Valor nao encontrado no vetor!");
        }

    }
    public static int coletaAlvo() {
        try (Scanner leia = new Scanner(System.in)) {
            System.out.println("Digite o valor procurado: ");
            if (leia.hasNextInt()) {
                int alvo = leia.nextInt();
                return alvo;
            }
            else {
                System.out.println("Precisa ser um numero inteiro positivo!");
            }
        }
        return -1;
    }
}