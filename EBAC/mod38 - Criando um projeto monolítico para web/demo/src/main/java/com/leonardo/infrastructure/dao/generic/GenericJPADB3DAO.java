package com.leonardo.infrastructure.dao.generic;

import java.io.Serializable;

import com.leonardo.domain.Persistente;

public abstract class GenericJPADB3DAO<T extends Persistente, E extends Serializable> extends GenericJPADAO<T, E> {

    public GenericJPADB3DAO(Class<T> persistenteClass) {
        super(persistenteClass, "mysql");
    }

    // Implementação de métodos específicos para o banco de dados B3, se necessário
    // Pode incluir métodos adicionais ou sobrecarga de métodos da classe pai

}
