package br.com.leonardo.fabricadecarros.fabricas;

import br.com.leonardo.fabricadecarros.carros.ICarro;
import br.com.leonardo.fabricadecarros.carros.SUV;

/**
 * FabricaSedan
 */
public class FabricaSedan implements IFabricaDeCarros{

    @Override
    public ICarro criarCarro() {
        return new SUV("CR-V", 2022);
    }

    
}