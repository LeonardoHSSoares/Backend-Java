package EBAC.mod11.tarefa_colecoes.part1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ManipulandoNomes {

    private List<String> nomes;

    public ManipulandoNomes() {
        nomes = new ArrayList<>();
    }

    public static void main(String[] args) {

        ManipulandoNomes ordenaNomes = new ManipulandoNomes();
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
        desenhaLinha();
        System.out.println("Nomes adicionados depois da ordenação");
        ordenaNomes.exibeNomes();
        desenhaLinha();
    }

    public void coletaNomes() {
        Scanner leia = new Scanner(System.in);
        int contador = 1;
        while(true) {
            
            String nome = leia.nextLine();
            System.out.println("Digite o proximo nome da lista: ");
            if (nome.equalsIgnoreCase("sair")) {
                exibeNomes();
                break;
            }
            
            contador++
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
