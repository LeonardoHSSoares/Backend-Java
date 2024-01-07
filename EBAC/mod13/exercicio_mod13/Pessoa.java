package EBAC.mod13.exercicio_mod13;

public abstract class Pessoa {

    protected String nome;
    protected Integer idade;
    protected Double altura;

    public abstract String pegarIdentificador();

    public Pessoa(String nome, Integer idade, Double altura) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
    }


    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }
    
    public void setIdade(Integer idade) {
        this.idade = idade;
    }
    
    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    // Ignore o main pois, utilizei apenas para testar os objetos instanciados
    public static void main(String[] args) {
        
        Fisica pessoaFisica = new Fisica("Leonardo", 30, 1.69);
        Juridica pessoaJuridica = new Juridica("Soares", 31, 1.79);

        System.out.println("Pessoa "+pessoaFisica.getClass().getSimpleName());
        pessoaFisica.setCpf("333.444.555-00");
        System.out.println(pessoaFisica.nome);
        System.out.println("CPF: "+pessoaFisica.pegarIdentificador());

        System.out.println("Pessoa "+pessoaJuridica.getClass().getSimpleName());
        pessoaJuridica.setCnpj("33.344.455/0001-39");
        System.out.println(pessoaJuridica.nome);
        System.out.println("CNPJ: "+pessoaJuridica.pegarIdentificador());
       


        
       
       

        

    }
}
