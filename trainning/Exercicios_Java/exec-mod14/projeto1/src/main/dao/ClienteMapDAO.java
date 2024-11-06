package main.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import main.domain.Cliente;

public class ClienteMapDAO implements IClienteDAO{

    private final Map<Long, Cliente> map;

    public ClienteMapDAO() {
        this.map = new HashMap<>();
    }

    @Override
    public Boolean cadastrar(Cliente cliente) {
       if(this.map.containsKey(cliente.getCpf())){
            return false;
       }
       this.map.put(cliente.getCpf(), cliente);
       return true;
    }

    @Override
    public void excluir(Long cpf) {
        Cliente clienteCadastrado = this.map.get(cpf);
        if (clienteCadastrado != null) {
            this.map.remove(clienteCadastrado.getCpf(),clienteCadastrado);
        }
    }

    @Override
    public void alterar(Cliente cliente) {
        Cliente clienteCadastrado = this.map.get(cliente.getCpf());
        if (clienteCadastrado != null) {
            clienteCadastrado.setNome(cliente.getNome());
        }
    }

    @Override
    public Cliente consultar(Long cpf) {
        return this.map.get(cpf);
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return this.map.values();
    }
    
}
