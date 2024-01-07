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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // metodo abstrato que será usado em todas as classes concretas (precisa ser declarada dentro da classe concreta).
    public abstract Double vencimento();
    

    // funcao geraRelatorio recebe a classe Abstrata como parametro para utilizar cada objeto instanciado
    public void geraRelatorio(Empregado empregado) {
        if (empregado instanceof Horista) {
            Horista horista = (Horista) empregado;  
            System.out.println("Classe: "+getClass().getSimpleName()); 
            horista.imprimeNome();
            horista.imprimeSobrenome();
            horista.imprimeCpf();           
        }

        if (empregado instanceof Assalariado) {
            Assalariado assalariado = (Assalariado) empregado;
            System.out.println("Classe: "+getClass().getSimpleName()); 
            assalariado.imprimeNome();
            assalariado.imprimeSobrenome();
            assalariado.imprimeCpf();
        }

        if (empregado instanceof Comissionado) {
            Comissionado comissionado = (Comissionado) empregado;
            System.out.println("Classe: "+getClass().getSimpleName()); 
            comissionado.imprimeNome();
            comissionado.imprimeSobrenome();        
            comissionado.imprimeCpf();
        }
    }
    //metodos genericos que imprime as regras de negocios
    public void imprimeNome() {
        System.out.println("Nome: "+this.nome);
    }

    public void imprimeSobrenome() {
        System.out.println("Sobrenome: "+this.sobrenome);
    }

    public void imprimeCpf() {
        System.out.println("CPF:"+this.cpf);
        
    }
}
