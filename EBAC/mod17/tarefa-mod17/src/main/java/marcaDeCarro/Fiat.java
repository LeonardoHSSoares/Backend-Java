package src.main.java.marcaDeCarro;

import src.main.java.domain.ICarro;


public class Fiat extends Marca<String> {

    private String modelo;
    
    public Fiat(Class<? extends ICarro<String>> tipoCarro) {
        super(tipoCarro);
    }
   
    @Override
    public String criarCarro(String modelo) {
        return "Fiat " + modelo;
    }
}