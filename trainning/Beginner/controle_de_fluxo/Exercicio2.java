package controle_de_fluxo;

import java.util.Scanner;

/*
*   2. Ler um número inteiro e imprimir se ele é par e divisível por três
 */
public class Exercicio2 {
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
        verfica(iNum);
        
        

    }
    public static void verfica(int i) {
        if (i % 2 == 0 && i % 3 == 0) {
            desenhaLinha();
            System.out.println(i+" PAR! e Divisivel por 3");
            desenhaLinha();
        }
        else if(i % 2 == 0 && i % 3 != 0){
            desenhaLinha();
            System.out.println(i+" PAR! mas nao divisivel por 3");
            desenhaLinha();
        }
        else if (i % 2 != 0 && i % 3 == 0) {
            desenhaLinha();
            System.out.println(i+" NÃO é par mas é divisivel por 3");
            desenhaLinha();
        }
        else {
            desenhaLinha();
            System.out.println("NÃO é PAR e Não é divisivel por 3");
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
