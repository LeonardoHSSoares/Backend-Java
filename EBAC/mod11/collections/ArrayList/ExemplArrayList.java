package EBAC.mod11.collections.ArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ArrayList
 */
public class ExemplArrayList {

    

public static void main(String[] args) {

    exemploListStringSimples();
    exemploListIntegerSimples();
    

}
    private static void exemploListStringSimples() {

    System.out.println("****Exemplo lista String simples ******");
    List<String> listaNome = new ArrayList<>();

    listaNome.add("Leonardo Soares");
    listaNome.add("Veronica Soares");
    listaNome.add("Sophia Silva");
    System.out.println(listaNome);


    System.out.println("****Exemplo lista String simples ordenada crescente******");
    Collections.sort(listaNome);
    System.out.println(listaNome);
    }
    private static void exemploListIntegerSimples() {
        
        System.out.println("****Exemplo lista Integer simples ******");
        List<Integer> listaIdade = new ArrayList<>();

        listaIdade.add(30);
        listaIdade.add(36);
        listaIdade.add(10);

        System.out.println(listaIdade);

        System.out.println("****Exemplo lista Integer simples ordenada crescente******");
        Collections.sort(listaIdade);
        System.out.println(listaIdade);
        

    }
}
