package EBAC.mod13.abstração;

/**
 * Classe concreta Horista que extende a classe abstrata Empregado
 */
public class Horista extends Empregado{
    
    private Double precoHora;
    private Double horasTrabalhadas;

    public Double vencimento()  {
        return precoHora*horasTrabalhadas;
    }

    public Double getprecoHora() {
        return precoHora;
    }
    
}
