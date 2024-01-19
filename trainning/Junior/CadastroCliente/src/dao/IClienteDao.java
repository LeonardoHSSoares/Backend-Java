package dao;

import java.util.Collection;
import java.util.List;

import domain.Cliente;


public interface IClienteDao {

    private Boolean cadastrar(Cliente cliente);

    private void excluir(String nome);

    private void alterar(Cliente cliente);

    private Cliente consultar(Long id);

    private Collection<Cliente> buscarTodos();


}
