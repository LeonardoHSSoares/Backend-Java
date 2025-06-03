package com.leonardo.dao.generic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Leonardo Soares
 *         Classe SingletonMap que implementa o padrão de projeto Singleton.
 *         * Esta classe é responsável por gerenciar uma instância única de um
 *         mapa
 *         que contém todos os registros da aplicação, simulando um banco de
 *         dados.
 *         * O SingletonMap é utilizado para garantir que haja apenas uma
 *         instância
 *         dessa classe em toda a aplicação, evitando a criação de múltiplas
 *         instâncias
 *         e garantindo o acesso controlado aos dados armazenados.
 *         * A classe contém um mapa que associa classes a outros mapas,
 *         permitindo
 *         armazenar e recuperar registros de diferentes tipos de entidades.
 *         * O método getInstance() é utilizado para obter a instância única do
 *         SingletonMap,
 *         garantindo que, se a instância ainda não foi criada, ela será
 *         inicializada
 *         apenas uma vez. Isso é útil para gerenciar o estado da aplicação e
 *         evitar
 *         problemas de concorrência em ambientes multi-threaded.
 */

public class SingletonMap {

    private static SingletonMap singletonMap;

    /**
     * Contém todos os registros da aplicação.
     * Simula o banco de dados
     */
    protected Map<Class<?>, Map<?, ?>> map;

    private SingletonMap() {
        map = new HashMap<>();
    }

    /**
     * Método que garante o retorno de apenas uma instância desse objeto
     *
     * @return SingletonMap
     */
    public static SingletonMap getInstance() {
        if (singletonMap == null) {
            singletonMap = new SingletonMap();
        }
        return singletonMap;
    }

    public Map<Class<?>, Map<?, ?>> getMap() {
        return this.map;
    }
}
