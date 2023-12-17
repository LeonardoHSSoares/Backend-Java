package trainning.Junior.ArquiteturaHexagonal;

import java.util.List;

public class Produto {

    private Long id;
    private String nome;
    private double preco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Produto(Long id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public interface ProdutoService {
        Produto obterProdutoPorId(Long id);

        List<Produto> listarProdutos();

        void salvarProduto(Produto produto);

        void removerProduto(Long id);

        List<Produto> buscarProdutosPorNome(String nome);

    }

}
