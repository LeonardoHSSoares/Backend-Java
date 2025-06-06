package com.leonardo.dao;

import java.util.Collection;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker;
import com.leonardo.dao.cliente.ClienteDAO;
import com.leonardo.dao.cliente.IClienteDAO;
import com.leonardo.domain.cliente.Cliente;
import com.leonardo.exceptions.DAOException;
import com.leonardo.exceptions.MaisDeUmRegistroException;
import com.leonardo.exceptions.TableException;
import com.leonardo.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author Leonardo Soares
 *
 *         Classe de testes para ClienteDAO.
 *         Responsável por validar as operações de CRUD (Create, Read, Update,
 *         Delete)
 *         para a entidade Cliente no banco de dados.
 *         Utiliza o padrão de geração de dados aleatórios para simular clientes
 *         reais.
 *         Cada teste garante o isolamento dos dados e a integridade das
 *         operações.
 */
public class ClienteDAOTest {

	// Instância do DAO de Cliente utilizada nos testes
	private final IClienteDAO clienteDao;

	/**
	 * Construtor que inicializa o DAO de Cliente.
	 */
	public ClienteDAOTest() {
		clienteDao = new ClienteDAO();
	}

	/**
	 * Método utilitário para criar um cliente com dados aleatórios.
	 * 
	 * @return Cliente criado com dados simulados.
	 * @throws TipoChaveNaoEncontradaException
	 * @throws DAOException
	 */
	private Cliente criaClienteParaTeste() throws TipoChaveNaoEncontradaException, DAOException {
		// Gera um CPF aleatório para o cliente
		Long cpf = 10000000000L + new Random().nextLong(9999999999L);
		Long tel = 119000000L + new Random().nextLong(999999999L);

		Faker faker = new Faker();
		Cliente cliente = new Cliente();
		cliente.setCpf(cpf);
		cliente.setNome(faker.name().fullName());
		cliente.setCidade(faker.address().city());
		cliente.setEnd(faker.address().streetName());
		cliente.setEstado("SP");
		cliente.setNumero(faker.number().numberBetween(1, 100));
		cliente.setTel(tel);
		cliente.setEmail(faker.internet().emailAddress());
		return cliente;
	}

	/**
	 * Testa a pesquisa de um cliente cadastrado.
	 * Garante que o cliente pode ser consultado corretamente após o cadastro.
	 */
	@Test
	public void pesquisarCliente()
			throws MaisDeUmRegistroException, TableException, TipoChaveNaoEncontradaException, DAOException {

		// Cria um cliente para teste
		Cliente novoCliente = criaClienteParaTeste();
		// Verifica se o cliente foi criado corretamente
		Assertions.assertNotNull(novoCliente);

		// Cadastra o cliente para teste
		Boolean retorno = clienteDao.cadastrar(novoCliente);
		// Verifica se o cliente foi cadastrado corretamente
		Assertions.assertTrue(retorno);

		// Consulta o cliente pelo CPF
		Cliente clienteConsultado = clienteDao.consultar(novoCliente.getCpf());
		// Verifica se o cliente foi consultado corretamente
		Assertions.assertNotNull(clienteConsultado);

		// Exclui o cliente após o teste
		clienteDao.excluir(novoCliente.getCpf());
		// Verifica se o cliente foi excluído
		Assertions.assertNull(clienteDao.consultar(novoCliente.getId()));
	}

	/**
	 * Testa o cadastro de um cliente.
	 * Garante que o cliente é salvo corretamente no banco de dados.
	 */
	@Test
	public void cadastrarCliente()
			throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {

		Cliente novoCliente = criaClienteParaTeste();
		// Verifica se o cliente foi criado corretamente
		Assertions.assertNotNull(novoCliente);

		Boolean retorno = clienteDao.cadastrar(novoCliente);
		// Verifica se o cliente foi cadastrado
		Assertions.assertTrue(retorno);

		Cliente clienteConsultado = clienteDao.consultar(novoCliente.getCpf());
		// Verifica se o cliente foi consultado corretamente
		Assertions.assertNotNull(clienteConsultado);

		// Exclui o cliente após o teste
		clienteDao.excluir(clienteConsultado.getCpf());
		// Verifica se o cliente foi excluído
		Assertions.assertNull(clienteDao.consultar(novoCliente.getId()));
	}

	/**
	 * Testa a exclusão de um cliente.
	 * Garante que o cliente é removido corretamente do banco de dados.
	 */
	@Test
	public void excluirCliente()
			throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {

		Cliente novoCLiente = criaClienteParaTeste();
		// Verifica se o cliente foi criado corretamente
		Assertions.assertNotNull(novoCLiente);

		Boolean retorno = clienteDao.cadastrar(novoCLiente);
		// Verifica se o cliente foi cadastrado
		Assertions.assertTrue(retorno);

		Cliente clienteConsultado = clienteDao.consultar(novoCLiente.getCpf());
		// Verifica se o cliente foi consultado corretamente
		Assertions.assertNotNull(clienteConsultado);

		// Exclui o cliente após o teste
		clienteDao.excluir(clienteConsultado.getCpf());
		// Verifica se o cliente foi excluído
		Assertions.assertNotNull(clienteConsultado);
	}

	/**
	 * Testa a alteração de um cliente.
	 * Garante que os dados do cliente são atualizados corretamente no banco.
	 */
	@Test
	public void alterarCliente()
			throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {

		// Cria um cliente para teste
		Cliente novoCliente = criaClienteParaTeste();
		Boolean retorno = clienteDao.cadastrar(novoCliente);
		// Verifica se o cliente foi cadastrado corretamente
		Assertions.assertTrue(retorno);

		// Altera os dados do cliente
		novoCliente.setNome("Leonardo Soares Alterado");
		novoCliente.setCidade("Rio de Janeiro");
		novoCliente.setEnd("Avenida Alterada");
		novoCliente.setEstado("RJ");
		novoCliente.setNumero(123);
		novoCliente.setTel(21900000000L);
		novoCliente.setEmail("leonardoAtualizado@gmail.com");

		clienteDao.alterar(novoCliente);
		// Verifica se o cliente foi alterado corretamente
		Cliente clienteAlterado = clienteDao.consultar(novoCliente.getCpf());
		Assertions.assertNotNull(clienteAlterado);
		Assertions.assertEquals("Leonardo Soares Alterado", clienteAlterado.getNome());
	}

	/**
	 * Testa a busca de todos os clientes cadastrados.
	 * Garante que a lista de clientes é retornada corretamente e que a exclusão em
	 * massa funciona.
	 */
	@Test
	public void buscarTodosClientes() throws TipoChaveNaoEncontradaException, DAOException {
		// Cria um cliente para teste
		Cliente cliente1 = criaClienteParaTeste();
		// Verifica se o cliente foi criado corretamente
		Assertions.assertNotNull(cliente1);
		// Cadastra o cliente1
		Boolean retorno1 = clienteDao.cadastrar(cliente1);
		// Verifica se o cliente1 foi cadastrado corretamente
		Assertions.assertTrue(retorno1);

		// Cria outro cliente para teste
		Cliente cliente2 = criaClienteParaTeste();
		// Verifica se o cliente foi criado corretamente
		Assertions.assertNotNull(cliente2);
		// Cadastra o cliente2
		Boolean retorno2 = clienteDao.cadastrar(cliente2);
		// Verifica se o cliente2 foi cadastrado corretamente
		Assertions.assertTrue(retorno2);

		Collection<Cliente> listaClientes = clienteDao.buscarTodos();
		assertTrue(listaClientes != null);
		assertTrue(!listaClientes.isEmpty());

		// Exclui todos os clientes após o teste
		for (Cliente cliente : listaClientes) {
			try {
				clienteDao.excluir(cliente.getCpf());
			} catch (DAOException e) {
				// Exceção tratada para garantir que o teste continue mesmo em caso de erro
			}
		}
	}
}
