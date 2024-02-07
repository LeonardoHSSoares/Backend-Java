package domain;

public class Funcionario {
    
    private String nome;
    private double salario;
    
    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void addAumento(double valor) {
        salario += valor;
    }
    public double ganhoAnual() {
        return getSalario() * 12;
    }
    public void exibeDados() {
        System.out.println(getClass().getSimpleName()+": "+getNome());
        System.out.println("Salario: "+getSalario());

    }


}
