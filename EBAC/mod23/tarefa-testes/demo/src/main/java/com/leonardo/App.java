package com.leonardo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        IUsuario usuario = new Pessoa();
        List<Pessoa> listaTotal = new ArrayList<>();

        System.out.println("Digite nome e genero separados por (,) Ex. leonardo henrique,m ");
        System.out.println("Caso deseje finalizar a lista, digite 'fim' ");

        while (true) {

            String entrada = ler.nextLine();

                if (entrada.equalsIgnoreCase("fim")) {
                    break;
                }

            Pessoa pessoaComDados = usuario.coletaDados(entrada);
            listaTotal.add(pessoaComDados);
            
        }
        ler.close();
        System.out.print("\033[H\033[2J");

        System.out.println("Lista Total Pessoas");
        Stream<Pessoa> listaStream = listaTotal.stream()
            .sorted(Comparator.comparing(Pessoa::getNome));
        listaStream.forEach(pessoa -> System.out.println(pessoa.toString()));

        System.out.println();
        System.out.println("Lista Mulheres");
        Stream<Pessoa> mulheres = listaTotal.stream()
            .filter(pessoa -> pessoa.getGenero().equals("Feminino"))
            .sorted(Comparator.comparing(Pessoa::getNome));
        mulheres.forEach(pessoa -> System.out.println(pessoa.toString())
        );        
    }
}
