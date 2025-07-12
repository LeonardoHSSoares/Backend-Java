package com.leonardo.domain.jpa;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.leonardo.domain.Persistente;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Leonardo Soares
 *
 * Classe ProdutoQuantidadeJPA que representa a quantidade de um produto em uma venda.
 * Esta classe é mapeada para a tabela TB_PRODUTO_QUANTIDADE no banco de dados.
 */
@Getter
@Setter
@Entity
@Table(name = "TB_PRODUTO_QUANTIDADE")
public class ProdutoQuantidadeJPA implements Persistente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prod_qtd_seq")
    @SequenceGenerator(name = "prod_qtd_seq", sequenceName = "sq_prod_qtd", initialValue = 1, allocationSize = 1)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private ProdutoJPA produto;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    @Column(name = "valor_total", nullable = false)
    private BigDecimal valorTotal;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_venda_fk", foreignKey = @ForeignKey(name = "fk_prod_qtd_venda"), referencedColumnName = "id", nullable = false)
    private VendaJPA venda;

    public ProdutoQuantidadeJPA() {
        this.quantidade = 0;
        this.valorTotal = BigDecimal.ZERO;
    }

    public void adicionar(Integer quantidade) {
        this.quantidade += quantidade;
        BigDecimal novoValor = this.produto.getValor().multiply(BigDecimal.valueOf(quantidade));
        BigDecimal novoTotal = this.valorTotal.add(novoValor);
        this.valorTotal = novoTotal;
    }

    public void remover(Integer quantidade) {
        this.quantidade -= quantidade;
        BigDecimal novoValor = this.produto.getValor().multiply(BigDecimal.valueOf(quantidade));
        this.valorTotal = this.valorTotal.subtract(novoValor);
    }

}
