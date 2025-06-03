package com.leonardo.domain;

import java.util.Collection;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.leonardo.dao.cliente.ClienteDAO;
import com.leonardo.dao.cliente.IClienteDAO;
import com.leonardo.domain.cliente.Cliente;
import com.leonardo.exceptions.DAOException;
import com.leonardo.exceptions.MaisDeUmRegistroException;
import com.leonardo.exceptions.TableException;
import com.leonardo.exceptions.TipoChaveNaoEncontradaException;

public class ClienteDAOTest {

    private IClienteDAO clienteDao;

	public ClienteDAOTest() {
		clienteDao = new ClienteDAO();
	}
	
	// @AfterEach
	// public void end() throws DAOException {
	// 	Collection<Cliente> list = clienteDao.buscarTodos();
	// 	list.forEach(cli -> {
	// 		try {
	// 			clienteDao.excluir(cli.getCpf());
	// 		} catch (DAOException e) {
	// 			// TODO Auto-generated catch block
	// 			e.printStackTrace();
	// 		}
	// 	});
	// }
	
	@Test
	public void pesquisarCliente() throws MaisDeUmRegistroException, TableException, TipoChaveNaoEncontradaException, DAOException {

		Collection<Cliente> list = clienteDao.buscarTodos();
		assertTrue(list != null);

		Cliente cliente = new Cliente();
		cliente.setCpf(12312312312L);
		cliente.setNome("Leonardo Soares");
		cliente.setCidade("São Paulo");
		cliente.setEnd("End");
		cliente.setEstado("SP");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		clienteDao.cadastrar(cliente);
		
		Cliente clienteConsultado = clienteDao.consultar(cliente.getId());
		Assertions.assertNotNull(clienteConsultado);
		
		clienteDao.excluir(cliente.getId());
	}
	
	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {

		Cliente cliente = new Cliente();
		cliente.setCpf(56565656566L);
		cliente.setNome("Veronica Soares");
		cliente.setCidade("São Paulo");
		cliente.setEnd("Rua Exemplo B");
		cliente.setEstado("SP");
		cliente.setNumero(13);
		cliente.setTel(1188888888L);
		cliente.setEmail("leonardo@gmail.com");
		
		Boolean retorno = clienteDao.cadastrar(cliente);
		Assertions.assertTrue(retorno);
		
		// Cliente clienteConsultado = clienteDao.consultar(cliente.getId());
		// Assertions.assertNotNull(clienteConsultado);
		
		// clienteDao.excluir(cliente.getId());
	}
	
	
	@Test
	public void excluirCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {

		Cliente cliente = new Cliente();
		// cliente.setId(5L);
		cliente.setCpf(56565656565L);
		cliente.setNome("Leonardo Soares");
		cliente.setCidade("São Paulo");
		cliente.setEnd("End");
		cliente.setEstado("SP");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		Boolean retorno = clienteDao.cadastrar(cliente);
		Assertions.assertTrue(retorno);
		
		Cliente clienteConsultado = clienteDao.consultar(cliente.getId());
		clienteDao.excluir(clienteConsultado.getId());
		Assertions.assertNotNull(clienteConsultado);
		
		clienteDao.excluir(cliente.getId());
		clienteConsultado = clienteDao.consultar(cliente.getId());
		Assertions.assertNull(clienteConsultado);
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		Cliente cliente = new Cliente();
		cliente.setCpf(56565656565L);
		cliente.setNome("Leonardo Soares");
		cliente.setCidade("São Paulo");
		cliente.setEnd("End");
		cliente.setEstado("SP");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		Boolean retorno = clienteDao.cadastrar(cliente);
		Assertions.assertTrue(retorno);
		
		Cliente clienteConsultado = clienteDao.consultar(cliente.getId());
		Assertions.assertNotNull(clienteConsultado);
		
		clienteConsultado.setNome("Leonardo Soares");
		clienteDao.alterar(clienteConsultado);
		
		Cliente clienteAlterado = clienteDao.consultar(clienteConsultado.getId());
		Assertions.assertNotNull(clienteAlterado);
		Assertions.assertEquals("Leonardo Soares", clienteAlterado.getNome());
		
		clienteDao.excluir(cliente.getId());
		clienteConsultado = clienteDao.consultar(cliente.getId());
		Assertions.assertNull(clienteConsultado);
	}
	
	@Test
	public void buscarTodos() throws TipoChaveNaoEncontradaException, DAOException {
		Cliente cliente = new Cliente();
		cliente.setCpf(56565656565L);
		cliente.setNome("Leonardo Soares");
		cliente.setCidade("São Paulo");
		cliente.setEnd("End");
		cliente.setEstado("SP");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		Boolean retorno = clienteDao.cadastrar(cliente);
		Assertions.assertTrue(retorno);
		
		Cliente cliente1 = new Cliente();
		cliente1.setCpf(56565656569L);
		cliente1.setNome("Veronica Soares");
		cliente1.setCidade("São Paulo");
		cliente1.setEnd("End");
		cliente1.setEstado("SP");
		cliente1.setNumero(10);
		cliente1.setTel(1199999999L);
		Boolean retorno1 = clienteDao.cadastrar(cliente1);
		Assertions.assertTrue(retorno1);
		
		Collection<Cliente> list = clienteDao.buscarTodos();
		assertTrue(list != null);
		assertTrue(list.size() >= 1);
		
		list.forEach(cli -> {
			try {
				clienteDao.excluir(cli.getId());
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Collection<Cliente> list1 = clienteDao.buscarTodos();
		assertTrue(list1 != null);
		assertTrue(list1.size() == 0);
	}
}

