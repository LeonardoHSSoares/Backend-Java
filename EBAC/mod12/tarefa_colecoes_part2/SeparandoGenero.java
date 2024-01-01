package EBAC.mod12.tarefa_colecoes_part2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SeparandoGenero {

    private List<String> nomesHomens;
    private List<String> nomesMulheres;
    int totalHomens = 0;
    int totalMulheres = 0;

    public SeparandoGenero() {
        nomesHomens = new ArrayList<>();
        nomesMulheres = new ArrayList<>();
    }

    public void coletaNome() {
        System.out.print("\033[H\033[2J");
        desenhaLinha();
        System.out.println("Digite o nome e o gênero separados por '-' ");
        System.out.println("Digite no formato 'Nome-Gênero', utilize 'm' para masculino ou 'f' para feminino. ");
        System.out.println("Digite 'sair' para encerrar");
        desenhaLinha();
        try (Scanner leia = new Scanner(System.in)) {
            while (true) {
                String entrada = leia.nextLine();
                String[] arrayNomes = entrada.split("-");

                if (entrada.equalsIgnoreCase("sair")) {
                    System.out.print("\033[H\033[2J");
                    System.out.println("Programa Finalizado!");
                    break;

                }
                if (arrayNomes.length != 2) {
                    System.out.println("Formato inválido. Por favor, digite no formato 'Nome-Gênero' ");
                    continue;
                }

                String nome = arrayNomes[0].trim();
                String genero = arrayNomes[1].trim().toLowerCase();
                divideGenero(nome, genero);
            }
        }
    }

    public void ordenaListas() {
        Collections.sort(nomesHomens);
        Collections.sort(nomesMulheres);
    }

    public void desenhaLinha() {
        for (int i = 0; i < 45; i++) {
            System.out.print("-");
        }
        System.out.print("\n");
    }

    public void exibeQntidadePessoas() {
        System.out.println("*********************************************");
        System.out.println("Total de pessoas cadastradas: " + (totalHomens + totalMulheres));
        System.out.println("*********************************************");
    }

    private void divideGenero(String nome, String genero) {
        if (genero.equals("m")) {
            nomesHomens.add(nome);
            totalHomens++;
        } else if (genero.equals("f")) {
            nomesMulheres.add(nome);
            totalMulheres++;
        } else {
            System.out.println("Gênero não reconhecido. Utilize 'm' para masculino ou 'f' para feminino.");
        }
    }

    public void imprimeTabela() {
        ordenaListas();
        System.out.println("*********************************************");
        System.out.printf("%-10s | Total: %s\n", "Tabela Homens", totalHomens);
        System.out.println("*********************************************");
        imprimeTabelaIndividual(nomesHomens, "Masculino");
        System.out.println("*********************************************");
        System.out.printf("%-10s | Total: %s\n", "Tabela Mulheres", totalMulheres);
        System.out.println("*********************************************");
        imprimeTabelaIndividual(nomesMulheres, "Feminino");
        desenhaLinha();
    }

    private void imprimeTabelaIndividual(List<String> nomes, String generoCompleto) {
        System.out.printf("%-30s | Gênero\n", "Nome");
        for (String nome : nomes) {
            desenhaLinha();
            System.out.printf("%-30s | %s\n", nome, generoCompleto);
        }
    }

    public static void main(String[] args) {
        SeparandoGenero objPrincipal = new SeparandoGenero();

        objPrincipal.coletaNome();
        objPrincipal.imprimeTabela();
        objPrincipal.exibeQntidadePessoas();
    }
}