package EBAC.mod11.tarefa_colecoes.part2;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class SeparandoGenero {

    private List<String> nomes;
    private List<Character> generos;

    public SeparandoGenero() {
        nomes = new ArrayList<>();
        generos = new ArrayList<>();
    }
    public SeparandoGenero(String[] nomes,String[] generos) {
        this.nomes = nomes;
    }
    
    public void coletaNome() {
        Scanner leia = new Scanner(System.in);

        System.out.println("Digite o nome");
        String nome = leia.nextLine();
        String[] arrayNomes = nome.split(",");
        String primeiroNome = arrayNomes[0];
        String segundoNome = arrayNomes[1];
        
        System.out.println(primeiroNome);
        System.out.println(segundoNome);
    }
    public void exibeNomes() {
        for(String nome : nomes){
            System.out.println(nome);
        }
    }
    public void exibeGeneros() {
        for(Character genero : generos) {
            System.out.println(genero);
        }
    }
    
    public static void main(String[] args) {
        SeparandoGenero objMain = new SeparandoGenero();
        
        objMain.coletaNome();
        objMain.exibeNomes();
        
    }
}
