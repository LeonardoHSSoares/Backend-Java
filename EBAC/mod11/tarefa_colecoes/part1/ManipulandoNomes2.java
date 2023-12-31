package EBAC.mod11.tarefa_colecoes.part1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ManipulandoNomes2 {

    private List<String> nomes;
    private String[] nomes2;

    public ManipulandoNomes2() {
        nomes = new ArrayList<>();
        nomes2 = new String[2];
    }

    public static void main(String[] args) {

        ManipulandoNomes2 ordenaNomes = new ManipulandoNomes2();
        System.out.print("\033[H\033[2J");
        desenhaLinha();
        System.out.print("Digite um nome para adiciona-lo à lista ou\n");
        System.out.println("Digite 'sair' para finalizar e imprimir a lista nomes: ");
        desenhaLinha();
        ordenaNomes.coletaNomes();
        desenhaLinha();
        System.out.println("Nomes adicionados antes da ordenação");
        ordenaNomes.exibeNomes();
        desenhaLinha();
        
        ordenaNomes.ordenaNomes();
        System.out.println("Nomes adicionados depois da ordenação");
        ordenaNomes.exibeNomes();
        desenhaLinha();
    }

    public void coletaNomes() {
        Scanner leia = new Scanner(System.in);
        int contador = 1;
        while(true) {
            
            System.out.println(String.format("Digite o %sº Nome:", contador));
            String nome = leia.nextLine();
            if (nome.equalsIgnoreCase("sair")) {
                System.out.print("\033[H\033[2J");
                desenhaLinha();
                System.out.println("Sistema encerrado!");
                break;
            }
            contador++;
            nomes.add(nome);
        }
    }

    public void ordenaNomes() {
        Collections.sort(nomes);
    }

    public void exibeNomes() {
        for (String nome : nomes) {
            System.out.println(nome);
        }
    }
    public static void desenhaLinha() {
        for (int i = 0; i < 60 ; i++) {
            System.out.print("-");
        }
        System.out.print("\n");
    }
}
