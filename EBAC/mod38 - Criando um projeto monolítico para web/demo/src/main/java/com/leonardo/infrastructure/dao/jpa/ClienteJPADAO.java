package com.leonardo.infrastructure.dao.jpa;

import com.leonardo.domain.jpa.ClienteJPA;
import com.leonardo.gateway.jpa.IClienteJPAGateway;
import com.leonardo.infrastructure.dao.generic.GenericJPADB1DAO;

/**
 * @author Leonardo Soares
 * 
 * Classe ClienteJPADAO que estende GenericJPADAO para operações de CRUD
 * (Create, Read, Update, Delete) na entidade ClienteJPA.
 * 
 * Esta classe é responsável por realizar operações de persistência no banco de
 * dados usando JPA.
 */
public class ClienteJPADAO extends GenericJPADB1DAO<ClienteJPA, Long> implements IClienteJPAGateway<ClienteJPA> {

	public ClienteJPADAO() {
		super(ClienteJPA.class);
	}

}
