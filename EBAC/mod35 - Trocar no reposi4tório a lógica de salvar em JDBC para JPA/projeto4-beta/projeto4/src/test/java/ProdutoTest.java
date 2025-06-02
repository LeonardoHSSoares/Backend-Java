import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.leonardo.dao.GenericDAOImpl;
import com.leonardo.domain.Produto;

public class ProdutoTest {

    private GenericDAOImpl<Produto> produtoDAO;

    @BeforeEach
    public void setUp() {
        produtoDAO = new GenericDAOImpl<>(Produto.class);
    
    }

    @Test
    public void cadastrarProdutoTest() {
        Produto produto = new Produto();
        produto.setNome("Computador Desktop Dell");
        produto.setPreco(1500.0);
        produto.setAtivo(true);

        produtoDAO.cadastrar(produto);

        Produto encontrado = produtoDAO.consultar(produto.getId());
        assertNotNull(encontrado);
        assertEquals(produto.getId(), encontrado.getId());
        assertEquals("Computador Desktop Dell", encontrado.getNome());
    }

    @Test
    public void atualizarProdutoTest() {
        
        Produto produtoEncontrado = produtoDAO.consultar(14L);
        assertNotNull(produtoEncontrado);

        produtoEncontrado.setNome("Notebook Samsung");
        produtoEncontrado.setPreco(900.0);
        produtoEncontrado.setAtivo(true);

        produtoDAO.atualizar(produtoEncontrado);

        Produto produtoAtualizado = produtoDAO.consultar(produtoEncontrado.getId());
        assertEquals("Notebook Samsung", produtoAtualizado.getNome());
    }

    @Test

    public void consultarProdutoTest() {
        Produto produto = produtoDAO.consultar(13L);
        assertNotNull(produto);
        assertEquals("Notebook Acer Inspiron", produto.getNome());
        
    }

    @Test
    public void excluirProdutoTest() {
        Produto produto = new Produto();
        produto.setNome("Smartphone Motorola");
        produto.setPreco(500.0);

        produtoDAO.cadastrar(produto);
        assertNotNull(produto);

        produtoDAO.excluir(produto.getId());

        Produto produtoExcluido = produtoDAO.consultar(produto.getId());
        assertEquals(null, produtoExcluido);
    }

    @Test
    public void consultarTodosProdutosTest() {
        List<Produto> produtos = produtoDAO.buscarTodos();
        assertNotNull(produtos);
        assertEquals(4, produtos.size()); // Verifica se existem 1 produtos cadastrados 
    
    }
}
