package br.com.leonardo.fabricadecarros.fabricas;

import br.com.leonardo.fabricadecarros.carros.Esportivo;
import br.com.leonardo.fabricadecarros.carros.ICarro;

public class FabricaEsportivo implements IFabricaDeCarros{

    public ICarro criarCarro(String modelo, int ano, String combustivel) {
        return new Esportivo(modelo, ano, combustivel);
    }
    
}
