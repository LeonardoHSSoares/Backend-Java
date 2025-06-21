package com.leonardo.domain.produto;

import java.math.BigDecimal;

import com.leonardo.dao.Persistence;

import annotation.ColunaTabela;
import annotation.Tabela;
import annotation.TipoChave;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Leonardo Soares
 *
 *         Classe Produto que representa a entidade Produto no sistema.
 *
 *         Esta classe contém os atributos e métodos necessários para manipular
 *         os dados
 *         de um produto, como id, código, nome, descrição, preço e quantidade
 *         em estoque.
 */
@Getter
@Setter
@Tabela("TB_PRODUTO")
public class Produto implements Persistence{

    @ColunaTabela(dbName = "id", setJavaName = "setId")
    private Long id;

    @TipoChave("getCodigo")
    @ColunaTabela(dbName = "codigo", setJavaName = "setCodigo")
    private String codigo;

    @ColunaTabela(dbName = "nome", setJavaName = "setNome")
    private String nome;

    @ColunaTabela(dbName = "descricao", setJavaName = "setDescricao")
    private String descricao;

    @ColunaTabela(dbName = "preco", setJavaName = "setPreco")
    private BigDecimal preco;

    @ColunaTabela(dbName = "quantidade_estoque", setJavaName = "setQuantidadeEstoque")
    private Integer quantidadeEstoque;
}
