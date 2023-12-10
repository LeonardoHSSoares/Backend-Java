package EBAC.mod7;

public class Carro {

    private String modelo;
    private int ano;
    private String cor;


    public Carro(String modelo, int ano, String cor) {
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
    }

    // Método para obter o modelo do carro
    public String getModelo() {
        return modelo;
    }

    // Método para obter o ano do carro
    public int getAno() {
        return ano;
    }

    // Método para obter a cor do carro
    public String getCor() {
        return cor;
    }

    // Método para exibir informações sobre o carro
    public void exibirInformacoes() {
        System.out.println("Carro: " + modelo + " | Ano: " + ano + " | Cor: " + cor);
    }

    // Método principal (para testar a classe Carro)
    public static void main(String[] args) {
        // Criando uma instância da classe Carro
        Carro meuCarro = new Carro("Fusca", 1970, "Azul");

        // Chamando o método para exibir informações sobre o carro
        meuCarro.exibirInformacoes();
    }
}
