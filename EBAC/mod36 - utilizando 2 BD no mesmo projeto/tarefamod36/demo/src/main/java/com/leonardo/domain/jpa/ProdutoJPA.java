package com.leonardo.domain.jpa;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.leonardo.domain.Persistente;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Leonardo Soares
 *
 * Classe ProdutoJPA que representa um produto no sistema.
 * Esta classe é mapeada para a tabela TB_PRODUTO no banco de dados.
 */
@Getter
@Setter
@Entity
@Table(name = "TB_PRODUTO")
public class ProdutoJPA implements Persistente{

    @Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="prod_seq")
	@SequenceGenerator(name="prod_seq", sequenceName="sq_produto", initialValue = 1, allocationSize = 1)
	private Long id;

	@Column(name = "codigo", nullable = false, length = 10, unique = true)
	private String codigo;
	
	@Column(name = "NOME", nullable = false, length = 50)
	private String nome;
	
	@Column(name = "DESCRICAO", nullable = false, length = 50)
	private String descricao;
	
	@Column(name = "valor", nullable = false)
	private BigDecimal valor;

    @Column(name = "quantidade_estoque", nullable = false)
    private Integer quantidadeEstoque;
	
}
