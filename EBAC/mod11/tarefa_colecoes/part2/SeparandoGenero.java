package EBAC.mod11.tarefa_colecoes.part2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SeparandoGenero {

    private List<String> nomes;
    private Character[] generos;
    private List<String> nomesHomens;
    private List<String> nomesMulheres;
    int totalHomens = 0;
    int totalMulheres = 0;
    
    public SeparandoGenero() {
        nomes = new ArrayList<>();
        generos = new ArrayList<>();
        nomesHomens = new ArrayList<>();
        nomesMulheres = new ArrayList<>();
    
    }

    public void coletaNome() {
        System.out.println("Digite o nome e o gênero separados por '-': ");
        Scanner leia = new Scanner(System.in);
        
        while (true) {

        String entrada = leia.nextLine();
        String[] arrayNomes = entrada.split("-");
            if (entrada.equalsIgnoreCase("sair")) {
                System.out.println("Programa Finalizado!");
                break;
            }else{
            nomes.add(arrayNomes[0]);
            generos.add(arrayNomes[1]);
            divideGenero(arrayNomes[1]);
            }
        }
    }

    public void exibeNomes(String genero) {
        System.out.println("Nomes:");
        for(String nome : nomes) {
            System.out.println(nome+"\t\t"+genero);
            
        }
    }

    public void exibeQntidadePessoas() {
        System.out.println("Total de pessoas cadastradas: " + (totalHomens + totalMulheres));
        System.out.println("Total de Homens cadastrados: " + totalHomens);
        System.out.println("Total de Mulheres cadastradas: " + totalMulheres);
    }

    public void divideGenero(String genero) {
        if (genero.equalsIgnoreCase("m")) {

        } else if (genero.equalsIgnoreCase("f")) {
            
        }
    }
    public void imprimeTabela() {
        System.out.println("Tabela de Homens:");
        imprimeTabelaIndividual(nomesHomens, "Masculino");
        System.out.println("\nTabela de Mulheres:");
        imprimeTabelaIndividual(nomesMulheres, "Feminino");
    }

    private void imprimeTabelaIndividual(List<String> nomes, String genero) {
        System.out.println("---------------------------------");
        System.out.printf("%-20s | Gênero\n", "Nome");
        System.out.println("---------------------------------");
        for (String nome : nomes) {
            System.out.printf("%-20s | %s\n", nome, genero);
        }
        System.out.println("---------------------------------");
    }

    public static void main(String[] args) {
        SeparandoGenero objPrincipal = new SeparandoGenero();
        
        objPrincipal.coletaNome();
        objPrincipal.exibeNomes("");
        objPrincipal.exibeQntidadePessoas();
        
    }
}