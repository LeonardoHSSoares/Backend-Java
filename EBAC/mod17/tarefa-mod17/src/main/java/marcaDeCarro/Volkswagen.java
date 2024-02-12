package src.main.java.marcaDeCarro;

import src.main.java.domain.ICarro;

public class Volkswagen extends Marca<String>{
    private String modelo;

    public Volkswagen(Class<? extends ICarro<String>> tipoCarro) {
        super(tipoCarro);
    }

    @Override
    public String criarCarro(String modelo) {
        return "Volkswagen " + modelo;
    }
}
