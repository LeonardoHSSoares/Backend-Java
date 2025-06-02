import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.leonardo.dao.GenericDAOImpl;
import com.leonardo.domain.Cliente;
import com.leonardo.domain.Produto;
import com.leonardo.domain.Venda;

public class VendaTest {

    private GenericDAOImpl<Cliente> clienteDAO;
    private GenericDAOImpl<Produto> produtoDAO;
    private GenericDAOImpl<Venda> vendaDAO;

    @BeforeEach
    public void setUp() {
        clienteDAO = new GenericDAOImpl<>(Cliente.class);
        produtoDAO = new GenericDAOImpl<>(Produto.class);
        vendaDAO = new GenericDAOImpl<>(Venda.class);
    }

    @Test
    public void testCriarVenda() {
    
        Cliente cliente = clienteDAO.consultar(1L);
        assertNotNull(cliente);
        Produto produto = produtoDAO.consultar(13L);

        Venda venda = new Venda();
        venda.setCliente(cliente);
        venda.getProdutos().add(produto);
        venda.setQuantidade(2);
        venda.calcularValorTotal();
        
        vendaDAO.cadastrar(venda);

        Venda encontrada = vendaDAO.consultar(venda.getId());
        assertNotNull(encontrada);
        assertEquals(2000, encontrada.getValorTotal(), 0.01);
    }

    @Test
    public void testExclusaoLogicaVenda() {
        List<Venda> vendas = vendaDAO.buscarTodos();
        for (Venda v : vendas) {
            v.setAtivo(false);
            vendaDAO.atualizar(v);
        }

        for (Venda v : vendaDAO.buscarTodos()) {
            assertFalse(v.isAtivo());
        }
    }

}
