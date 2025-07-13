package com.leonardo.infrastructure.dao.jpa;

import com.leonardo.domain.jpa.ClienteJPA;
import com.leonardo.gateway.jpa.IClienteJPAGateway;
import com.leonardo.infrastructure.dao.generic.GenericJPADB2DAO;

public class ClienteJPADB2DAO extends GenericJPADB2DAO<ClienteJPA, Long> implements IClienteJPAGateway<ClienteJPA> {

    public ClienteJPADB2DAO() {
        super(ClienteJPA.class);
    }

    // Implementação de métodos específicos para o banco de dados DB2, se necessário
    // Pode incluir métodos adicionais ou sobrecarga de métodos da classe pai

}
