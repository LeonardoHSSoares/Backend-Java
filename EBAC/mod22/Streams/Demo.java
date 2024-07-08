package Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        IUsuario user = new Pessoa();
        List<Pessoa> listaTotal = new ArrayList<>();
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite nome e genero separados por (,) Ex. leonardo henrique,m ");
        System.out.println("Caso deseje finalizar a lista, digite 'fim' ");

        while (true) {
            String entrada = ler.nextLine();
            if (entrada.equalsIgnoreCase("fim")) {
                break;
            }
            Pessoa pessoaComDados = user.coletaDados(entrada);
            listaTotal.add(pessoaComDados);
        }

        ler.close();

        ListaPessoas listaFinal = new ListaPessoas(listaTotal);
        listaFinal.imprimirLista(listaTotal);
    }
}