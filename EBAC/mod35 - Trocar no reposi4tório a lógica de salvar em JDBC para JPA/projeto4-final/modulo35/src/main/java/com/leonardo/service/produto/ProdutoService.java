package com.leonardo.service.produto;

import com.leonardo.dao.produto.IProdutoDAO;
import com.leonardo.domain.produto.Produto;
import com.leonardo.service.generic.GenericService;

/**
 * @author Leonardo Soares
 *
 *
 */
public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

    public ProdutoService(IProdutoDAO produtoDAO) {
        super(produtoDAO);
    }



}
