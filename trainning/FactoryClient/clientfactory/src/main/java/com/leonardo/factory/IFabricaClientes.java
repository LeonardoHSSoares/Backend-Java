package com.leonardo.factory;

import com.leonardo.domain.ICliente;

public interface IFabricaClientes {

    /**
     * Método que cria um cliente
     * 
     * @param nome
     * @param cpf
     * @param email
     * @param telefone
     * @param endereco
     * @return ICliente
     */
    ICliente novoCliente(String nome, String cpf, String email, Integer telefone, String endereco);
    
}
