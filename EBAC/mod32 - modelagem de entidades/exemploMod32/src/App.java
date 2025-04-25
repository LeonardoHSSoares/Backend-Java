
import main.java.dao.IProdutoDAO;
import main.java.dao.ProdutoDAO;
import main.java.domain.Produto;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        IProdutoDAO produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();

        Produto produto1 = produtoDAO.cadastrar(produto);
        System.out.println("Produto cadastrado: " + produto1.getId() + " - " + produto1.getNome());
    }
}
