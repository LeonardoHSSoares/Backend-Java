package com.leonardo.infrastructure.dao.jpa;

import com.leonardo.domain.jpa.ProdutoJPA;
import com.leonardo.gateway.jpa.IProdutoJPAGateway;
import com.leonardo.infrastructure.dao.generic.GenericJPADAO;

public class ProdutoJPADAO extends GenericJPADAO<ProdutoJPA, Long> implements IProdutoJPAGateway {

	public ProdutoJPADAO() {
		super(ProdutoJPA.class, "postgres");
	}

}
