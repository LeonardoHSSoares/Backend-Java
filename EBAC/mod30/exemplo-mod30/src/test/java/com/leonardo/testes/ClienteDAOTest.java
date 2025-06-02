package com.leonardo.testes;

import java.util.Collection;

import org.junit.Assert;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import com.leonardo.dao.ClienteDAO;
import com.leonardo.dao.IClienteDAO;
import com.leonardo.domain.Cliente;
import com.leonardo.exceptions.DAOException;
import com.leonardo.exceptions.MaisDeUmRegistroException;
import com.leonardo.exceptions.TableException;
import com.leonardo.exceptions.TipoChaveNaoEncontradaException;

public class ClienteDAOTest {

	private IClienteDAO clienteDao;

	public ClienteDAOTest() {
		clienteDao = new ClienteDAO();
	}

	// @After
	// public void end() throws DAOException {
	// 	Collection<Cliente> list = clienteDao.buscarTodos();
	// 	list.forEach(cli -> {
	// 		clienteDao.excluir(cli.getCpf());
			
	// 	});
	// }

	@Test
	public void pesquisarCliente()
			throws MaisDeUmRegistroException, TableException, TipoChaveNaoEncontradaException, DAOException {
		Cliente cliente = new Cliente();
		cliente.setCpf(12312312312L);
		cliente.setNome("Rodrigo");
		cliente.setCidade("São Paulo");
		cliente.setEnd("End");
		cliente.setEstado("SP");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		cliente.setEmail("Leonardo@gmail.com");
		clienteDao.cadastrar(cliente);

		Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);

		clienteDao.excluir(cliente.getCpf());
	}

	@Test
	public void salvarCliente()
			throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		Cliente cliente = new Cliente();
		cliente.setCpf(56565656565L);
		cliente.setNome("Rodrigo");
		cliente.setCidade("São Paulo");
		cliente.setEnd("End");
		cliente.setEstado("SP");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		cliente.setEmail("leonardo@gmail.com");
		Boolean retorno = clienteDao.cadastrar(cliente);
		Assert.assertTrue(retorno);

		Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);

		clienteDao.excluir(cliente.getCpf());
	}

	@Test
	public void excluirCliente()
			throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		Cliente cliente = new Cliente();
		cliente.setCpf(56565656565L);
		cliente.setNome("Leonardo");
		cliente.setCidade("São Paulo");
		cliente.setEnd("End");
		cliente.setEstado("SP");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		cliente.setEmail("leonardo@gmail.com");
		Boolean retorno = clienteDao.cadastrar(cliente);
		Assert.assertTrue(retorno);

		Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);

		clienteDao.excluir(cliente.getCpf());
		clienteConsultado = clienteDao.consultar(cliente.getCpf());
		Assert.assertNull(clienteConsultado);
	}

	@Test
	public void alterarCliente()
			throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		Cliente cliente = new Cliente();
		cliente.setCpf(56565656565L);
		cliente.setNome("Leonardo");
		cliente.setCidade("São Paulo");
		cliente.setEnd("End");
		cliente.setEstado("SP");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		cliente.setEmail("leonardo@gmail.com");
		Boolean retorno = clienteDao.cadastrar(cliente);
		Assert.assertTrue(retorno);

		Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);

		clienteConsultado.setNome("Leonardo Soares");
		clienteDao.alterar(clienteConsultado);

		Cliente clienteAlterado = clienteDao.consultar(clienteConsultado.getCpf());
		Assert.assertNotNull(clienteAlterado);
		Assert.assertEquals("Leonardo Soares", clienteAlterado.getNome());

		clienteDao.excluir(cliente.getCpf());
		clienteConsultado = clienteDao.consultar(cliente.getCpf());
		Assert.assertNull(clienteConsultado);
	}

	@Test
	public void buscarTodos() throws TipoChaveNaoEncontradaException, DAOException {
		Cliente cliente = new Cliente();
		cliente.setCpf(56565656565L);
		cliente.setNome("Leonardo");
		cliente.setCidade("São Paulo");
		cliente.setEnd("End");
		cliente.setEstado("SP");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		Boolean retorno = clienteDao.cadastrar(cliente);
		Assert.assertTrue(retorno);

		Cliente cliente1 = new Cliente();
		cliente1.setCpf(56565656569L);
		cliente1.setNome("Leonardo");
		cliente1.setCidade("São Paulo");
		cliente1.setEnd("End");
		cliente1.setEstado("SP");
		cliente1.setNumero(10);
		cliente1.setTel(1199999999L);
		cliente1.setEmail("leonardo@gmail.com");
		Boolean retorno1 = clienteDao.cadastrar(cliente1);
		Assert.assertTrue(retorno1);

		Collection<Cliente> list = clienteDao.buscarTodos();
		assertTrue(list != null);
		assertTrue(list.size() == 2);

		list.forEach(cli -> {
                    clienteDao.excluir(cli.getCpf()); 
		});

		Collection<Cliente> list1 = clienteDao.buscarTodos();
		assertTrue(list1 != null);
		assertTrue(list1.size() == 0);
	}
}