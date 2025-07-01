package com.leonardo.gateway;

import com.leonardo.domain.Produto;


/**
 * @author Leonardo Soares
 *
 *     Interface IProdutoGateway que estende IGenericDAO.
 *     Esta interface define as operações de acesso a dados específicas para a entidade Produto.
 *     Ela herda os métodos genéricos de IGenericDAO, permitindo operações de CRUD
 *     (Create, Read, Update, Delete) para a entidade Produto.
 *     A interface é parametrizada com Produto como entidade e Long como tipo de chave primária
 *     para garantir a tipagem correta nas operações de banco de dados.
 */
public interface IProdutoGateway extends IGenericGateway<Produto, String> {


}
