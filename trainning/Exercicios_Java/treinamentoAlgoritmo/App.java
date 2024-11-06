
import matrizes.Matrizes;

import java.util.ArrayList;
import java.util.List;

import matrizes.ManipuladorMatrizes;

public class App {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        int tamanho = 10;
        List<Integer> matrizMae = new ArrayList<>(tamanho);
        
        Matrizes matriz1 = new Matrizes(matrizMae);
        matriz1.setTamanho(tamanho);
        
        matriz1.apply(10+10);
    }
}
