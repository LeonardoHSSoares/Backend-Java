package main.java.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_Produto")
public class Produto {

    public Produto() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "produto_seq")
    @SequenceGenerator(name = "produto_seq", sequenceName = "sq_produto", initialValue = 1, allocationSize = 1)
    private Long id;

    @Collumn(name = "NOME", length = 100, nullable = false)
    private String nome;

    @Collumn(name = "PRECO" ,nullable = false)
    private Double preco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
