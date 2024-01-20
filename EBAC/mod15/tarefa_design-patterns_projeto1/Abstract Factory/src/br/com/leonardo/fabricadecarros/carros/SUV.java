package br.com.leonardo.fabricadecarros.carros;

public class SUV implements ICarro{
    
    private String modelo;
    private int ano;
    
    public SUV(String modelo, int ano) {
        this.modelo = modelo;
        this.ano = ano;
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
    @Override
    public void exibirInfo() {
      
        System.out.println("Tipo: "+getClass().getSimpleName());
        System.out.println(String.format("modelo: %s",modelo));
        System.out.println(String.format("ano: %s",ano));
    }

}
