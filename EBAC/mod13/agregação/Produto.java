package EBAC.mod13.agregação;

import java.util.List;


public class Produto {
   
    private Long codigo;

    private String nome;

    private double preco;

    private List<Produto> produtos;

    public Long getCodigo() {
        return codigo;
    }

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
    public List<Produto> getProdutos() {
        return produtos;
    }
    public void adicionaProduto(Produto produto) {
        this.produtos.add(produto);
    }

    public void vendido() {
        System.out.println("Vendido!");
    }

}
