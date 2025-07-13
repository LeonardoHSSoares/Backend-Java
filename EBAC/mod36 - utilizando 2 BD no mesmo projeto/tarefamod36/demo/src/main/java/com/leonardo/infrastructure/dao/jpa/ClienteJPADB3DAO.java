package com.leonardo.infrastructure.dao.jpa;

import com.leonardo.domain.jpa.ClienteJPA2;
import com.leonardo.gateway.jpa.IClienteJPAGateway;
import com.leonardo.infrastructure.dao.generic.GenericJPADB3DAO;

public class ClienteJPADB3DAO extends GenericJPADB3DAO<ClienteJPA2, Long> implements IClienteJPAGateway<ClienteJPA2> {

    public ClienteJPADB3DAO() {
        super(ClienteJPA2.class);
    }

    // Implementação de métodos específicos para o banco de dados B3, se necessário
    // Pode incluir métodos adicionais ou sobrecarga de métodos da classe pai

}
