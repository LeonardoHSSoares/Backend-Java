package com.leonardo.gateway.jpa;

import com.leonardo.domain.jpa.ProdutoJPA;
import com.leonardo.gateway.generic.IGenericJPAGateway;


public interface IProdutoJPAGateway extends IGenericJPAGateway<ProdutoJPA, Long> {
    // Esta interface pode ser estendida para incluir métodos específicos relacionados a Produto, se necessário.

}
