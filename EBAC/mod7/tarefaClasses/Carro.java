package EBAC.mod7.tarefaClasses;

/**
 * @author leonardo
 */
// Definindo a classe Carro
public class Carro {
    
    // Propriedades (variáveis de instância)
    private String marca;
    private String modelo;
    private int ano;

    // Construtor da classe Carro
    public Carro(String marca,String modelo,int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    // Método para exibir informações sobre o carro
    public void exibirInformacoes() {
        System.out.println("Carro: | Modelo: " + modelo + " | Marca: " + marca + " | Ano: " + ano);
    }

}