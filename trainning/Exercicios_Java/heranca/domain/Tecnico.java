package domain;

public class Tecnico extends Assistente{

    private double bonusSalarial;
    
    public Tecnico(String nome, double salario, long numMatricula, double bonusSalarial) {
        super(nome, salario, numMatricula);
        this.bonusSalarial = bonusSalarial;
    }

    public double ganhoAnual() {
        return (getSalario() + bonusSalarial) * 12;
    }


}
