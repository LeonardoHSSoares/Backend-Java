package com.leonardo.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.leonardo.domain.Cliente;
import com.leonardo.exceptions.DAOException;
import com.leonardo.exceptions.TipoChaveNaoEncontradaException;
import com.leonardo.gateway.IClienteGateway;
import com.leonardo.infrastructure.dao.ClienteDAO;
import com.leonardo.service.cliente.ClienteService;
import com.leonardo.service.cliente.IClienteService;

public class ClienteServiceTest {

    private IClienteService clienteService;
	
	private Cliente cliente;
	
	public ClienteServiceTest() {
		IClienteGateway dao = new ClienteDAO();
		clienteService = new ClienteService(dao);
	}
	
	@BeforeEach
	public void init() {
		cliente = new Cliente();
		cliente.setCpf(12312312312L);
		cliente.setNome("Leonardo");
		cliente.setCidade("São Paulo");
		cliente.setEnd("End");
		cliente.setEstado("SP");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		
	}
	
	@Test
	public void pesquisarCliente() throws DAOException {
		Cliente cliente = new Cliente();
		Cliente clienteConsultado = clienteService.buscarPorID(cliente.getCpf());
		// Assertions.assertTrue(clienteConsultado != null);
	}
	
	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		Boolean retorno = clienteService.cadastrar(cliente);
		
		Assertions.assertTrue(retorno);
	}
	
	@Test
	public void excluirCliente() throws DAOException {
		clienteService.excluir(cliente.getCpf());
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		cliente.setNome("Leonardo Alterado");
		clienteService.alterar(cliente);
		
		Assertions.assertEquals("Leonardo Alterado", cliente.getNome());
	}
}
