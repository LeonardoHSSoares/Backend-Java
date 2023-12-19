package EBAC.mod9.tarefa_Wrapper;

import java.util.Scanner;

//classe Boxing com casting implicito
public class Boxing {
    
    public static void main(String args[]) {
        Scanner leia = new Scanner(System.in);

        System.out.println("Digite um numero inteiro para guardar: ");
        int numero = leia.nextInt();
        leia.close();
        System.out.print("\033[H\033[2J");

        System.out.println("Este numero "+numero+" esta numa variavel do tipo primitivo");
        //casting implicito
        Integer numero2 = numero;
        System.out.println("Este numero "+numero2+" esta numa variavel do tipo Wrapper");
        
    }

}
