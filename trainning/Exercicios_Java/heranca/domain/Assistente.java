package domain;

public class Assistente extends Funcionario{

    private long numMatricula;

    public Assistente(String nome, double salario, long numMatricula) {
        super(nome, salario);
        this.numMatricula = numMatricula;
    }

    public long getNumMatricula() {
        return numMatricula;
    }

    public void setNumMatricula(long numMatricula) {
        this.numMatricula = numMatricula;
    }

    public void exibeDados() {
        
        System.out.println("Assistente");
        System.out.println("N. Matricula: "+getNumMatricula());
        System.out.println("Nome: "+getNome());
        System.out.println("Salario mensal: "+getSalario());
    }
}
