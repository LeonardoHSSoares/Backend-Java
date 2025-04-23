package main.java;

public class ProdutoDao implements IProduto {

    @Override
    public Produto cadastrar(Produto produto) {
        // Lógica para cadastrar o produto no banco de dados
        // Aqui você pode usar JDBC, Hibernate ou qualquer outra tecnologia de persistência
        // Exemplo fictício:
        System.out.println("Produto cadastrado: " + produto.getNome());
        return produto;
    }

}
