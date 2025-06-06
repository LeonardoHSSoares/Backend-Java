package com.leonardo.services.produto;

import com.leonardo.dao.produto.IProdutoDAO;
import com.leonardo.domain.produto.Produto;
import com.leonardo.services.generic.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

    public ProdutoService(IProdutoDAO produtoDAO) {
        super(produtoDAO);
    }


}
