package matrizes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Matrizes implements ManipuladorMatrizes {
    Random aleatorio = new Random();
    List<Integer> matrizMae;
    int tamanho;

    public Matrizes() {
        this.matrizMae = new ArrayList<>();
    }
    
    public Matrizes(List<Integer> matrizMae) {
        this.matrizMae = new ArrayList<>(matrizMae);
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public List<Integer> getMatrizMae() {
        return matrizMae;
    }

    public void setMatrizMae(List<Integer> matrizMae) {
        this.matrizMae = matrizMae;
    }

    public void preencheMatriz() {
        
        for (int i = 0; i < matrizMae.size(); i++) {
            Integer sortNumber = getAleatorio(aleatorio);
            matrizMae.set(i,sortNumber);
        }
    }

    public Integer getAleatorio(Random aleatorio) {
        return aleatorio.nextInt(getTamanho());
    }
}