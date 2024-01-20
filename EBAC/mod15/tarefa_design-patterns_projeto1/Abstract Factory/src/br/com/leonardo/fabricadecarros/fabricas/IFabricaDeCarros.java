package br.com.leonardo.fabricadecarros.fabricas;

import br.com.leonardo.fabricadecarros.carros.ICarro;

public interface IFabricaDeCarros {
    ICarro criarCarro(String modelo,int ano);
}
