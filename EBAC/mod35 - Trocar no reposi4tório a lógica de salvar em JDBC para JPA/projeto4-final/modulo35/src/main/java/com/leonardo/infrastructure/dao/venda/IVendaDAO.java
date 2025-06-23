package com.leonardo.infrastructure.dao.venda;

import com.leonardo.domain.venda.Venda;
import com.leonardo.exceptions.DAOException;
import com.leonardo.exceptions.TipoChaveNaoEncontradaException;
import com.leonardo.gateway.IGenericGateway;

/**
 * @author Leonardo Soares
 * Interface para operações de acesso a dados relacionadas a vendas.
 * Define métodos específicos para finalizar e cancelar vendas.
 */
public interface IVendaDAO extends IGenericGateway<Venda, String>{

    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
