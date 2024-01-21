package br.com.leonardo.fabricadecarros.fabricas;

import br.com.leonardo.fabricadecarros.carros.ICarro;
import br.com.leonardo.fabricadecarros.carros.Passeio;

public class FabricaPasseio implements IFabricaDeCarros{

    @Override
    public ICarro criarCarro(String modelo, int ano, String combustivel) {
        return new Passeio(modelo, ano, combustivel);
    }
    
}
