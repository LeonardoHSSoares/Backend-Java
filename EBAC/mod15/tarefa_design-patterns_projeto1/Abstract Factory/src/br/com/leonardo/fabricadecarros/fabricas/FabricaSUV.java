package br.com.leonardo.fabricadecarros.fabricas;

import br.com.leonardo.fabricadecarros.carros.ICarro;
import br.com.leonardo.fabricadecarros.carros.SUV;

public class FabricaSUV implements IFabricaDeCarros{

    @Override
    public ICarro criarCarro(String modelo, int ano) {
        return new SUV(modelo, ano);
    }

    
    
}
