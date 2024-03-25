package Queue_Deque;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * ExemploQueue
 */
public class ExemploQueue {

    public static void main(String[] args) {
        Boolean sair = true;
        Queue<Pessoa> filaPessoas = new PriorityQueue<Pessoa>();
        
        while (sair) {
            
            coletaNome();
        }
    }
    
    public static String coletaNome() {
        Scanner read = new Scanner(System.in);
        System.out.println("Digite um nome: ");
        String nome = read.nextLine();
        read.close();

        return "";
    }
}