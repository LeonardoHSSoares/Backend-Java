package com.leonardo.domain;

import java.math.BigDecimal;

import com.leonardo.annotation.ColunaTabela;
import com.leonardo.annotation.Tabela;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Leonardo Soares
 *
 */

@Getter
@Setter
@Tabela("TB_PRODUTO_QUANTIDADE")
public class ProdutoQuantidade {

    @ColunaTabela(dbName = "id", setJavaName = "setId")
	private Long id;

	@ColunaTabela(dbName = "id", setJavaName = "setId")
	private Produto produto;
	
	@ColunaTabela(dbName = "quantidade", setJavaName = "setQuantidade")
	private Integer quantidade;
	
	@ColunaTabela(dbName = "valor_total", setJavaName = "setValorTotal")
	private BigDecimal valorTotal;

	
	public ProdutoQuantidade() {
		this.quantidade = 0;
		this.valorTotal = BigDecimal.ZERO;
	}

	public void adicionar(Integer quantidade) {
		this.quantidade += quantidade;
		BigDecimal novoValor = this.produto.getPreco().multiply(BigDecimal.valueOf(quantidade));
		BigDecimal novoTotal = this.valorTotal.add(novoValor);
		this.valorTotal = novoTotal;
	}
	
	public void remover(Integer quantidade) {
		this.quantidade -= quantidade;
		BigDecimal novoValor = this.produto.getPreco().multiply(BigDecimal.valueOf(quantidade));
		this.valorTotal = this.valorTotal.subtract(novoValor);
	}
	
}
