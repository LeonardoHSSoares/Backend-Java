package com.leonardo.factory;

import com.leonardo.domain.Cliente;
import com.leonardo.domain.ICliente;

public class FabricaClientes implements IFabricaClientes {

    @Override
    public ICliente novoCliente(String nome, String cpf, String email, Integer telefone, String endereco) {
        return new Cliente(nome, cpf, email, telefone, endereco);
    }

}
