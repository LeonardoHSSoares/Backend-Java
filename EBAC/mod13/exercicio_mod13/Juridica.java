package EBAC.mod13.exercicio_mod13;

public class Juridica extends Pessoa {

    protected String cnpj;

    public Juridica(String nome, Integer idade, Double altura) {
        super(nome, idade, altura);
    }

    public String pegarIdentificador() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
}
