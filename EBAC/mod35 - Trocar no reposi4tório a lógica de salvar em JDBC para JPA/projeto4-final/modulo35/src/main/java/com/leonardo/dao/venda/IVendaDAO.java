package com.leonardo.dao.venda;

import com.leonardo.dao.generic.IGenericDAO;
import com.leonardo.domain.venda.Venda;
import com.leonardo.exceptions.DAOException;
import com.leonardo.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author Leonardo Soares
 * Interface para operações de acesso a dados relacionadas a vendas.
 * Define métodos específicos para finalizar e cancelar vendas.
 */
public interface IVendaDAO extends IGenericDAO<Venda, String>{

    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
