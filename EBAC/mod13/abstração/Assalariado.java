package EBAC.mod13.abstração;

/**
 * Classe concreta Assalariado que extende a classe abstrata Empregado
 */
public class Assalariado extends Empregado {

    private Double salario;

    public Double vencimento() {
        return salario;
    }
}
