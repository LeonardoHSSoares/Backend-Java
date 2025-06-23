package com.leonardo.gateway;

import com.leonardo.domain.Cliente;

/**
 * @author Leonardo Soares
 *
 *     Interface IClienteGateway que estende IGenericDAO.
 *     Esta interface define as operações de acesso a dados específicas para a entidade Cliente.
 *     Ela herda os métodos genéricos de IGenericDAO, permitindo operações de CRUD
 *     (Create, Read, Update, Delete) para a entidade Cliente.
 *     A interface é parametrizada com Cliente como entidade e Long como tipo de chave primária
 *     para garantir a tipagem correta nas operações de banco de dados.
 */
public interface IClienteGateway extends IGenericGateway<Cliente, Long>{


}
