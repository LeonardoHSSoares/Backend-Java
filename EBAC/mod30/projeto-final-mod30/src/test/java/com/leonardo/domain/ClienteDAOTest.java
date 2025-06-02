package com.leonardo.domain;

import java.util.Collection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import com.leonardo.dao.ClienteDAO;
import com.leonardo.dao.IClienteDAO;
import com.leonardo.exceptions.DAOException;
import com.leonardo.exceptions.MaisDeUmRegistroException;
import com.leonardo.exceptions.TableException;
import com.leonardo.exceptions.TipoChaveNaoEncontradaException;

public class ClienteDAOTest {

    private IClienteDAO clienteDao;

	public ClienteDAOTest() {
		clienteDao = new ClienteDAO();
	}
	
	@AfterAll
	public void end() throws DAOException {
		Collection<Cliente> list = clienteDao.buscarTodos();
		list.forEach(cli -> {
			try {
				clienteDao.excluir(cli.getCpf());
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

    @Test
	public void cadastrarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		Cliente cliente = new Cliente();
		cliente.setCpf(56565656565L);
		cliente.setNome("Leonardo");
		cliente.setCidade("São Paulo");
		cliente.setEndereco("Rua A");
		cliente.setEstado("SP");
		cliente.setNumero(10);
		cliente.setTelefone(1199999999L);
        cliente.setEmail("leonardo@gmail.com");
		Boolean retorno = clienteDao.cadastrar(cliente);

        // Verifica se o cliente foi cadastrado corretamente
		assert retorno;
        
		
		Cliente clienteConsultado = clienteDao.consultarPorID(cliente.getId());
		assert clienteConsultado != null;

		clienteDao.excluir(cliente.getCpf());
        // Verifica se o cliente foi excluído corretamente
        assert clienteDao.consultarPorID(cliente.getId()) == null;
        
	}
}
