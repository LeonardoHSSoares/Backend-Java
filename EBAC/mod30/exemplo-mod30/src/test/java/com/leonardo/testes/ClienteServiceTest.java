package com.leonardo.testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.leonardo.dao.IClienteDAO;
import com.leonardo.domain.Cliente;
import com.leonardo.exceptions.DAOException;
import com.leonardo.exceptions.TipoChaveNaoEncontradaException;
import com.leonardo.services.ClienteService;
import com.leonardo.services.IClienteService;
import com.leonardo.testes.dao.ClienteDAOMock;

public class ClienteServiceTest {
	
	private IClienteService clienteService;
	
	private Cliente cliente;
	
	public ClienteServiceTest() {
		IClienteDAO dao = new ClienteDAOMock();
		clienteService = new ClienteService(dao);
	}
	
	@Before
	public void init() {
		cliente = new Cliente();
		cliente.setCpf(12312312312L);
		cliente.setNome("Leonardo");
		cliente.setCidade("São Paulo");
		cliente.setEnd("End");
		cliente.setEstado("SP");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		cliente.setEmail("leonardo@gmail.com");
		
	}
	
	@Test
	public void pesquisarCliente() throws DAOException {
		Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);
	}
	
	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		Boolean retorno = clienteService.cadastrar(cliente);
		
		Assert.assertTrue(retorno);
	}
	
	@Test
	public void excluirCliente() throws DAOException {
		clienteService.excluir(cliente.getCpf());
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		cliente.setNome("Leonardo Soares");
		clienteService.alterar(cliente);
		
		Assert.assertEquals("Leonardo Soares", cliente.getNome());
	}
}
