package EBAC.mod13.herança.abstração;

/**
 * Classe concreta Comissionado que extende a classe abstrata Empregado
 */
public class Comissionado extends Empregado{

    private Double totalVenda;
    private Double taxaComissao;
    
    public Double vencimento() {
        return totalVenda*taxaComissao;
    }
    
    public Double getTotalVendas() {
        return totalVenda;
    } 

    public Double getTaxaComissao() {
        return taxaComissao;
    }
    public void setTotalVenda(Double totalVenda) {
        this.totalVenda = totalVenda;
    }
    public void setTaxaComissao(Double taxaComissao) {
        this.taxaComissao = taxaComissao;
    }
}
