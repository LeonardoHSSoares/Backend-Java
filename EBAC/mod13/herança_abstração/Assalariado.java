package EBAC.mod13.herança_abstração;

/**
 * Classe concreta Assalariado que extende a classe abstrata Empregado
 */
public class Assalariado extends Empregado {

    private Double salario;

    public Double vencimento() {
        return salario;
    }
    public Double getSalario(){
        return salario;
    }
    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
