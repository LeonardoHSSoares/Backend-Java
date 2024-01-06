package EBAC.mod13.abstração;

/**
 * Classe abstrata Empregado
 */
public abstract class Empregado {
    
    private String nome;
    private String sobrenome;
    private String cpf;

    public String getNome() {
        return nome;
    }
    public String getSobrenome(){
        return sobrenome;
    }
    public String getCpf(){
        return cpf;
    }

    public Double vencimento() {
        
    }

}
