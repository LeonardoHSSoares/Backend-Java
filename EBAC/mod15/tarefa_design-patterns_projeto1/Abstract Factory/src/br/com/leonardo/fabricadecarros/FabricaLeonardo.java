package br.com.leonardo.fabricadecarros;

import br.com.leonardo.fabricadecarros.carros.ICarro;
import br.com.leonardo.fabricadecarros.carros.Passeio;
import br.com.leonardo.fabricadecarros.carros.Sedan;
import br.com.leonardo.fabricadecarros.fabricas.FabricaEsportivo;
import br.com.leonardo.fabricadecarros.fabricas.FabricaHatch;
import br.com.leonardo.fabricadecarros.fabricas.FabricaPasseio;
import br.com.leonardo.fabricadecarros.fabricas.FabricaSUV;
import br.com.leonardo.fabricadecarros.fabricas.FabricaSedan;
import br.com.leonardo.fabricadecarros.fabricas.IFabricaDeCarros;

public class FabricaLeonardo {
    public static void main(String[] args) {
        IFabricaDeCarros leonardoPasseio = new FabricaPasseio();
        ICarro palio = leonardoPasseio.criarCarro("Palio", 1995, "Gasolina");
        palio.exibirInfo();

        IFabricaDeCarros leonardoEsportivo = new FabricaEsportivo();
        ICarro pulseT270 = leonardoEsportivo.criarCarro("Pulse Abarth", 2022, "Flex");
        pulseT270.exibirInfo();

        IFabricaDeCarros leonardoSUV = new FabricaSUV();
        ICarro fastBackAT6 = leonardoSUV.criarCarro("Argo Fastback", 2023, "Flex");
        fastBackAT6.exibirInfo();

        IFabricaDeCarros leonardoSedan = new FabricaSedan();
        ICarro firefly = leonardoSedan.criarCarro("Argo Sedan", 2023, "Flex");
        firefly.exibirInfo();

        IFabricaDeCarros leonardoHatch = new FabricaHatch();
        ICarro hatchCarro = leonardoHatch.criarCarro("Mobi", 2022, "Gasolina");
        hatchCarro.exibirInfo();
        


        

    }
}
