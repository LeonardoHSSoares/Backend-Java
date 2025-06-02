package com.leonardo.services.cliente;

import com.leonardo.dao.IClienteDAO;
import com.leonardo.domain.Cliente;
import com.leonardo.exceptions.DAOException;
import com.leonardo.exceptions.MaisDeUmRegistroException;
import com.leonardo.exceptions.TableException;
import com.leonardo.services.generic.GenericService;

/**
 * @author Leonardo Soares
 *
 * Classe ClienteServ que implementa a interface IClienteService.
 *
 * Esta classe é responsável por realizar operações de serviço para a entidade Cliente,
 * como consultar um cliente por ID.
 *
 * Ela estende a classe GenericService, que fornece implementações genéricas para serviços.
 */
public class ClienteServ extends GenericService<Cliente, Long> implements IClienteService {

    public ClienteServ(IClienteDAO clienteDAO) {
        super(clienteDAO);
    }

    @Override
    public Cliente consultarPorID(Long id) throws DAOException {
        try {
			return this.dao.consultarPorID(id);
		} catch (MaisDeUmRegistroException | TableException e) {
            throw new DAOException("Erro ao consultar cliente por ID: " + id, e);
		}
		
    }

    

}
