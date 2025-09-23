package com.leonardo.service.cliente;

import com.leonardo.domain.Cliente;
import com.leonardo.exceptions.DAOException;
import com.leonardo.service.generic.IGenericService;

public interface IClienteService extends IGenericService<Cliente, Long> {

	Cliente buscarPorCPF(Long cpf) throws DAOException;

}