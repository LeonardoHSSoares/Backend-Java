package com.leonardo.dao.cliente;

import com.leonardo.dao.generic.GenericDAO;
import com.leonardo.domain.Cliente;

public class ClienteDAO extends GenericDAO<Cliente, Long> implements IClienteDAO {

	public ClienteDAO() {
		super(Cliente.class);
	}

}
