package com.leonardo.dao;

import com.leonardo.dao.generic.IGenericDAO;
import com.leonardo.domain.Venda;
import com.leonardo.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, String> {

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException;
}
