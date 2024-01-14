package dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import domain.Cliente;

public class ClienteMapDAO implements IClienteDAO{

    private Map<Long,Cliente> map;

    public ClienteMapDAO() {
        this.map = new HashMap<>();
    }

    @Override
    public Boolean cadastrar(Cliente cliente) {
        if (this.map.containsKey(cliente.getId())) {
            return false;
        }
        this.map.put(cliente.getId(), cliente);
        return true;
    }

    @Override
    public void alterar(Cliente cliente) {
        Cliente clienteCadastrado = this.map.get(cliente.getId());
        if (clienteCadastrado != null) {
            clienteCadastrado.setNome(cliente.getNome());
        }
    }

    @Override
    public void excluir(Long id) {
        Cliente clienteCadastrado = this.map.get(id);
        if (clienteCadastrado != null) {
            this.map.remove(clienteCadastrado.getId(), clienteCadastrado);
        }
    }

    @Override
    public Cliente consultar(Long id) {
        return this.map.get(id);
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return this.map.values();
        
    }

}
