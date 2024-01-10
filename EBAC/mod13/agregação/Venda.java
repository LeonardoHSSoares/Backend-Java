package EBAC.mod13.agregação;

import java.util.List;

//Classe agregada
public class Venda {
    
    // uma classe agregada vai receber a cada 
    private Comprador comprador;

    private Vendedor vendedor;

    private List<Produto> produtos;

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void adicionaProdutos(Produto produto) {
        this.produtos.add(produto);
    }

    public void concretizaVenda() {
        
    }

    public void cancelarVenda() {
        System.out.println("Venda Cancelada!");
    }

}
