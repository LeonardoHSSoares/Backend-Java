package src.main.java.marcaDeCarro;

import src.main.java.domain.ICarro;

public class Renault extends Marca<String> {

    public Renault(Class<? extends ICarro<String>> tipoCarro) {
        super(tipoCarro);
    }

    @Override
    public String criarCarro(String modelo) {
        return "Renault " + modelo;
    }

}
