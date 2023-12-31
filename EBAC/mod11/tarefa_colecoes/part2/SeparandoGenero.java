package EBAC.mod11.tarefa_colecoes.part2;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class SeparandoGenero {

    private List<String> nomes;
    private List<String> generos;
    private Integer qntdHomem;
    private Integer qntdMulher;
    private int[] nome;

    public Integer getQntdHomem() {
        return qntdHomem;
    }

    public void setQntdHomem(Integer qntdHomem) {
        this.qntdHomem = qntdHomem;
    }

    public Integer getQntdMulher() {
        return qntdMulher;
    }

    public void setQntdMulher(Integer qntdMulher) {
        this.qntdMulher = qntdMulher;
    }

    public SeparandoGenero() {
        nomes = new ArrayList<>();
        generos = new ArrayList<>();
    }

    public void coletaNome() {
        System.out.println("Digite o nome e o gênero separados por '-': ");

        while (true) {
            Scanner leia = new Scanner(System.in);

            String entrada = leia.nextLine();
            String[] arrayNomes = entrada.split("-");

            for (String nome : nomes) {
                nome = arrayNomes[0];
                nomes.add(nome);
            }

                if (arrayNomes[1].equalsIgnoreCase("m")) {
                    int total = getQntdHomem();
                    total++;
                    setQntdHomem(total);
                } else if (arrayNomes[1].equalsIgnoreCase("f")) {
                    int total = getQntdMulher();
                    total++;
                    setQntdMulher(total);
                }
        }
    }

    public void exibeNomes() {
        System.out.println("Nomes:");
        for (String nome : nomes) {
            System.out.println(nome);
        }
    }

    public void exibeGeneros() {
        System.out.println("Gêneros:");
        for (String genero : generos) {
            System.out.println(genero);
        }

        int total = getQntdHomem() + getQntdMulher();
        System.out.println("Total de pessoas cadastradas: " + total);
        System.out.println("Total de Homens cadastrados: " + getQntdHomem());
        System.out.println("Total de Mulheres cadastradas: " + getQntdMulher());
    }

    public void divideGenero() {

    }

    public static void main(String[] args) {
        SeparandoGenero objPrincipal = new SeparandoGenero();

        objPrincipal.coletaNome();
        objPrincipal.exibeNomes();
        objPrincipal.exibeGeneros();

    }
}