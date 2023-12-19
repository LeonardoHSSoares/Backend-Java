package EBAC.mod9.tarefa_Wrapper;

import java.util.Scanner;

//classe Unboxing com casting implicito
public class Unboxing {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        
        System.out.println("Digite um numero para guardar:");
        Integer numero = leia.nextInt();
        leia.close();
        System.out.print("\033[H\033[2J");
        
        System.out.println("Este numero "+numero+" esta guardado numa variavel tipo Wrapper");

        //casting implicito.
        int numero2 = numero;
        System.out.println("Este numero "+numero2+" esta guardado numa variavel tipo primitivo");



    }
}
