package EBAC.mod13.exercicio_mod13;

public class Fisica extends Pessoa{

    protected String cpf;

    public Fisica(String nome, Integer idade, Double altura) {
        super(nome,idade,altura);
    }

    public String pegarIdentificador() {
        return cpf;
    }

    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
