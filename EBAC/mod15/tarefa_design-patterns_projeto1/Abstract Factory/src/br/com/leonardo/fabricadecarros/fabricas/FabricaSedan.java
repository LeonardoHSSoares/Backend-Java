package br.com.leonardo.fabricadecarros.fabricas;

import br.com.leonardo.fabricadecarros.carros.ICarro;
import br.com.leonardo.fabricadecarros.carros.SUV;
import br.com.leonardo.fabricadecarros.carros.Sedan;

/**
 * FabricaSedan
 */
public class FabricaSedan implements IFabricaDeCarros{

    @Override
    public ICarro criarCarro(String modelo, int ano, String combustivel) {
        return new Sedan(modelo,ano,combustivel);
    }

    
}