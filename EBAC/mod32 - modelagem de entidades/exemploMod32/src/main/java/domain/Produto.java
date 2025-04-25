package main.java.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_produto")
public class Produto {

    @Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="produto_seq")
	@SequenceGenerator(name="produto_seq", sequenceName="sq_produto", allocationSize=1)
    private Long id;

    @Column(name = "NOME", length = 50, nullable = false)
    private String nome;

    @Column(name = "DESCRICAO", length = 200)
    private String descricao;
    
    @Column(name = "PRECO", nullable = false)
    private Double preco;

    public Produto() {
    }

    public Produto(Long id, String nome, String descricao, Double preco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String toString() {
        return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco + "]";
    }

}
