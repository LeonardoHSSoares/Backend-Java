package com.leonardo.services.cliente;

import com.leonardo.domain.Cliente;
import com.leonardo.exceptions.DAOException;
import com.leonardo.services.generic.IGenericService;

public interface IClienteService extends IGenericService<Cliente, Long> {

    /**
     * @author Leonardo Soares
     * 
     * Busca um cliente pelo ID.
     *
     * @param id o ID do cliente a ser buscado
     * @return o cliente encontrado
     * @throws DAOException se ocorrer um erro ao acessar os dados
     */
    @Override
    Cliente consultarPorID(Long id) throws DAOException;


}
