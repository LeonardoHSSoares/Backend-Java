package EBAC.mod13.agregação;

public class Produto {
   
    private Long codigo;

    private String nome;

    private double preco;

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Double getPreco() {
        return preco;
    }

}
