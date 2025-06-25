package com.leonardo.jpa;

import java.util.Collection;
import java.util.Random;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.leonardo.domain.jpa.ClienteJPA;
import com.leonardo.exceptions.DAOException;
import com.leonardo.exceptions.MaisDeUmRegistroException;
import com.leonardo.exceptions.TableException;
import com.leonardo.exceptions.TipoChaveNaoEncontradaException;
import com.leonardo.gateway.jpa.IClienteJPAGateway;
import com.leonardo.infrastructure.dao.jpa.ClienteJPADAO;

/**
 * Classe de teste para o ClienteJPADAO, que implementa as operações de acesso a dados
 * para a entidade ClienteJPA.
 * 
 * @author Leonardo Soares
 */
public class ClienteJPADAOTest {
	
	private IClienteJPAGateway clienteDao;
	
	private Random rd;
	
	public ClienteJPADAOTest() {
		this.clienteDao = new ClienteJPADAO();
		rd = new Random();
	}
	
	@AfterAll
	public void end() throws DAOException {
		Collection<ClienteJPA> list = clienteDao.buscarTodos();
		list.forEach(cli -> {
			try {
				clienteDao.excluir(cli);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
	
	@Test
	public void pesquisarCliente() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
		ClienteJPA cliente = criarCliente();
		clienteDao.cadastrar(cliente);
		
		ClienteJPA clienteConsultado = clienteDao.consultar(cliente.getId());
		Assertions.assertNotNull(clienteConsultado);
		
	}

	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		ClienteJPA cliente = criarCliente();
		ClienteJPA retorno = clienteDao.cadastrar(cliente);
		Assertions.assertNotNull(retorno);
		
		ClienteJPA clienteConsultado = clienteDao.consultar(retorno.getId());
		Assertions.assertNotNull(clienteConsultado);
		
		clienteDao.excluir(cliente);
		
		ClienteJPA clienteConsultado1 = clienteDao.consultar(retorno.getId());
		Assertions.assertNull(clienteConsultado1);
	}
	
	@Test
	public void excluirCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		ClienteJPA cliente = criarCliente();
		ClienteJPA retorno = clienteDao.cadastrar(cliente);
		Assertions.assertNotNull(retorno);
		
		ClienteJPA clienteConsultado = clienteDao.consultar(cliente.getId());
		Assertions.assertNotNull(clienteConsultado);
		
		clienteDao.excluir(cliente);
		clienteConsultado = clienteDao.consultar(cliente.getId());
		Assertions.assertNull(clienteConsultado);
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		ClienteJPA cliente = criarCliente();
		ClienteJPA retorno = clienteDao.cadastrar(cliente);
		Assertions.assertNotNull(retorno);
		
		ClienteJPA clienteConsultado = clienteDao.consultar(cliente.getId());
		Assertions.assertNotNull(clienteConsultado);
		
		clienteConsultado.setNome("Leonardo Soares");
		clienteDao.alterar(clienteConsultado);
		
		ClienteJPA clienteAlterado = clienteDao.consultar(clienteConsultado.getId());
		Assertions.assertNotNull(clienteAlterado);
		Assertions.assertEquals("Leonardo Soares", clienteAlterado.getNome());
		
		clienteDao.excluir(cliente);
		clienteConsultado = clienteDao.consultar(clienteAlterado.getId());
		Assertions.assertNull(clienteConsultado);
	}
	
	@Test
	public void buscarTodos() throws TipoChaveNaoEncontradaException, DAOException {
		ClienteJPA cliente = criarCliente();
		ClienteJPA retorno = clienteDao.cadastrar(cliente);
		Assertions.assertNotNull(retorno);
		
		ClienteJPA cliente1 = criarCliente();
		ClienteJPA retorno1 = clienteDao.cadastrar(cliente1);
		Assertions.assertNotNull(retorno1);
		
		Collection<ClienteJPA> list = clienteDao.buscarTodos();
		assertTrue(list != null);
		assertTrue(list.size() == 2);
		
		list.forEach(cli -> {
			try {
				clienteDao.excluir(cli);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Collection<ClienteJPA> list1 = clienteDao.buscarTodos();
		assertTrue(list1 != null);
		assertTrue(list1.size() == 0);
	}
	
	private ClienteJPA criarCliente() {
		ClienteJPA cliente = new ClienteJPA();
		cliente.setCpf(rd.nextLong());
		cliente.setNome("Leonardo Soares");
		cliente.setCidade("São Paulo");
		cliente.setEnd("End");
		cliente.setEstado("SP");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		return cliente;
	}

}
