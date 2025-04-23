package test.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.java.IProduto;
import main.java.Produto;
import main.java.ProdutoDao;

public class ProdutoTest {

    @Test
    public void testProduto() {
        // Criação de um objeto Produto
        Produto produto = new Produto();
        ProdutoDao produtoDao = new ProdutoDao();
        
        // Definindo valores para os atributos
        produto.setId(1);
        produto.setNome("Produto Teste");
        produto.setPreco(10.0);
        produto.setQuantidade(5);
        
        // Verificando se os valores foram definidos corretamente
        Assertions.assertEquals(1, produto.getId());
        Assertions.assertEquals("Produto Teste", produto.getNome());
        Assertions.assertEquals(10.0, produto.getPreco());
        Assertions.assertEquals(5, produto.getQuantidade());

        produtoDao.cadastrar(produto);
        Assertions.assertNotNull(produto);
        Assertions.assertEquals(produto.getId(), produto.getId());


    }
}
