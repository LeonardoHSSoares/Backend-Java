package br.com.leonardo.fabricadecarros.carros;

public class Esportivo implements ICarro{

    private String modelo;
    private int ano;
    private String combustivel;

    public Esportivo(String modelo, int ano, String combustivel) {
        this.modelo = modelo;
        this.ano = ano;
        this.combustivel = combustivel;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    @Override
    public void exibirInfo() {
        System.out.println("\n");
        System.out.println("Tipo: "+getClass().getSimpleName());
        System.out.println(String.format("modelo: %s",modelo));
        System.out.println(String.format("combustivel: %s",combustivel));
        System.out.println(String.format("ano: %s",ano));
        System.out.println("\n");

    }
    
}
