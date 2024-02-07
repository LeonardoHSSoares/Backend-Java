package domain;

public class Administrativo extends Assistente{

    private String turno;

    private double adicionalNoturno;

    public Administrativo(String nome, double salario, long numMatricula,String turno, double adicionalNoturno) {
        super(nome, salario, numMatricula);
        this.turno = turno;
        this.adicionalNoturno = adicionalNoturno;
    }

    public double ganhoAnual() {
        double salarioAnual = getSalario() * 12;
        if (turno.equalsIgnoreCase("noite")) {
            salarioAnual += adicionalNoturno * 12;
        }
        return salarioAnual;
    }
    
    
}
