package com.leonardo.service.produto;

import com.leonardo.domain.Produto;
import com.leonardo.gateway.IProdutoGateway;
import com.leonardo.service.GenericService;

/**
 * @author Leonardo Soares
 *
 *
 */
public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

    public ProdutoService(IProdutoGateway produtoDAO) {
        super(produtoDAO);
    }



}
