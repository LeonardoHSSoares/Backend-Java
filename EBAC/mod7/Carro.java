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

    public String getModelo() {

        return modelo;
    }

    public int getAno() {

        return ano;
    }

    public String getCor() {

        return cor;
    }

    public void exibirInformacoes() {
        System.out.println("Carro: " + modelo);
        System.out.println("Ano: " + ano);
        System.out.println("Cor: " + cor);
    }

}
