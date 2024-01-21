package br.com.leonardo.fabricadecarros.fabricas;

import br.com.leonardo.fabricadecarros.carros.Hatch;
import br.com.leonardo.fabricadecarros.carros.ICarro;

public class FabricaHatch implements IFabricaDeCarros{

    public ICarro criarCarro(String modelo, int ano, String combustivel) {
        return new Hatch(modelo, ano, combustivel);
    }
    
}
