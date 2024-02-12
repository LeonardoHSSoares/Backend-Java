package src.main.java.marcaDeCarro;

import src.main.java.domain.ICarro;

public class Ford extends Marca<String>{
    private String modelo;

    public Ford(Class<? extends ICarro<String>> tipoCarro) {
        super(tipoCarro);
    }

    @Override
    public String criarCarro(String modelo) {
        return "Ford " + modelo;
    }
}
