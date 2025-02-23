package com.leonardo.domain;

public class Produto {

    private Long id_produto;
    private String nome;
    private String descricao;
    private Double preco;

    public Produto() {

    }

    public Produto(Long id_produto) {
        this.id_produto = id_produto;
    }

    public Produto(String nome, Double preco, String descricao) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Produto { ID = " +getId_produto()+ ", Nome = " +getNome()+ " , Preço = " +getPreco()+ ", Descrição = "+getDescricao()+" }";
    }

    public Long getId_produto() {
        return id_produto;
    }

    public void setId_produto(Long id_produto) {
        this.id_produto = id_produto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
