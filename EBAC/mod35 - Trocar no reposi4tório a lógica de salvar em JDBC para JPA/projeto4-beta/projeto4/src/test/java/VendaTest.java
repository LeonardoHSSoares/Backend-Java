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

    private GenericDAOImpl<Cliente> daoCliente;
    private GenericDAOImpl<Produto> daoProduto;
    private GenericDAOImpl<Venda> daoVenda;

    @BeforeEach
    public void setUp() {
        daoCliente = new GenericDAOImpl<>(Cliente.class);
        daoProduto = new GenericDAOImpl<>(Produto.class);
        daoVenda = new GenericDAOImpl<>(Venda.class);
    }

    @Test
    public void testCriarVenda() {
        Cliente cliente = new Cliente();
        cliente.setNome("Cliente Venda");
        cliente.setCpf("12312312300");
        cliente.setEndereco("Rua Venda");
        cliente.setTelefone("1177777777");
        daoCliente.cadastrar(cliente);

        Produto produto = new Produto();
        produto.setNome("Produto Teste");
        produto.setPreco(100);
        daoProduto.cadastrar(produto);

        Venda venda = new Venda();
        venda.setCliente(cliente);
        venda.getProdutos().add(produto);
        venda.setQuantidade(2);
        venda.calcularValorTotal();

        daoVenda.cadastrar(venda);

        Venda encontrada = daoVenda.consultar(venda.getId());
        assertNotNull(encontrada);
        assertEquals(200, encontrada.getValorTotal(), 0.01);
    }

    @Test
    public void testExclusaoLogicaVenda() {
        List<Venda> vendas = daoVenda.buscarTodos();
        for (Venda v : vendas) {
            v.setAtivo(false);
            daoVenda.atualizar(v);
        }

        for (Venda v : daoVenda.buscarTodos()) {
            assertFalse(v.isAtivo());
        }
    }

}
