package com.leonardo.services;

import com.leonardo.dao.IProdutoDAO;
import com.leonardo.domain.Produto;
import com.leonardo.services.generic.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}

}
