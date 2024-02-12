package src.main.java.marcaDeCarro;

import java.util.ArrayList;
import java.util.List;

import src.main.java.domain.ICarro;

public class Marca<T> implements ICarro<T> {
    private Class<? extends ICarro<T>> tipoCarro;
    private List<String> modelos;

    public Marca(Class<? extends ICarro<T>> tipoCarro) {
        this.tipoCarro = tipoCarro;
        this.modelos = new ArrayList<>();
    }

    @Override
    public T criarCarro(String modelo) {
        try {
            return tipoCarro.getDeclaredConstructor(String.class).newInstance(modelo).criarCarro(modelo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<String> getModelos() {
        return modelos;
    }

    public void adicionarModelo(String modelo) {
        modelos.add(modelo);
    }

    public String getMarca() {
        return tipoCarro.getSimpleName();
    }
}
