package dao;

import java.util.Collection;

import domain.Cliente;

public interface IClienteDAO {

    public Boolean cadastrar(Cliente cliente);

    public void alterar(Cliente cliente);

    public void excluir(Long id);

    public Cliente consultar(Long id);

    public Collection<Cliente> buscarTodos();

}
