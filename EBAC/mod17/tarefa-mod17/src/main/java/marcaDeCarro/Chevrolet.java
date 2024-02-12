package src.main.java.marcaDeCarro;

import src.main.java.domain.ICarro;

public class Chevrolet extends Marca<String>{

    public Chevrolet(Class<? extends ICarro<String>> tipoCarro) {
        super(tipoCarro);
    }

    @Override
    public String criarCarro(String modelo) {
        return "Chevrolet " + modelo;
    }

}
