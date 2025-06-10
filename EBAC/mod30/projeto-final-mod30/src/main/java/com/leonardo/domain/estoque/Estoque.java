package com.leonardo.domain.estoque;

import com.leonardo.dao.Persistence;
import com.leonardo.domain.produto.Produto;

import annotation.ColunaTabela;
import annotation.Tabela;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Leonardo Soares
 */
@Getter
@Setter
@Tabela("TB_ESTOQUE")
public class Estoque implements Persistence{

    @ColunaTabela(dbName = "id", setJavaName = "setId")
    private Long id;

    @ColunaTabela(dbName = "produto", setJavaName = "setProduto")
    private Produto produto;

    @ColunaTabela(dbName = "quantidade", setJavaName = "setQuantidade")
    private Integer quantidade;

    public Estoque() {}

    public Estoque(Produto produto, Integer quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }


}
