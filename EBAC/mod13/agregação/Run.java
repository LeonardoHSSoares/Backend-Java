package EBAC.mod13.agregação;

public class Run {
    public static void main(String args[]) {
        Produto produto = criarProduto("1L",10d,"TV");
    }

    private static Produto criarProduto(Long codigo, Double valor, String nome) {
        Produto produto = new Produto();
        produto.setCodigo(1L);
    }
}
