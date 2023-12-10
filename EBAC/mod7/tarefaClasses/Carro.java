package EBAC.mod7.tarefaClasses;

/**
 * @author leonardo
 */
public class Carro {
    private String marca;
    private String modelo;
    private int ano;

    public Carro(String marca,String modelo,int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    public void exibirInformacoes() {
        System.out.println("Carro: | Modelo: " + modelo + " | Marca: " + marca + " | Ano: " + ano);
    }

}