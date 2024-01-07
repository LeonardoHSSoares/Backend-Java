package EBAC.mod13.abstração;

/**
 * Classe concreta Comissionado que extende a classe abstrata Empregado
 */
public class Comissionado extends Empregado{

    private Double totalVenda;
    private Double taxaComissao;
    
    public Double vencimento() {
        return totalVenda*taxaComissao;
    }
}
