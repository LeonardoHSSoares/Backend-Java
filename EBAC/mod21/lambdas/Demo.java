package lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;


public class Demo {
    @SuppressWarnings("unchecked")
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

        System.out.println("Lista Pessoas");
        user.imprimirLista(listaTotal);

        System.out.println("Lista Mulheres");
        Stream<Pessoa> mulheres = listaTotal.stream()
            .filter(pessoa -> pessoa.getGenero().equals("Feminino"));
           
        
    }
}